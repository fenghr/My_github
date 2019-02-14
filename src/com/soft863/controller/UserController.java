package com.soft863.controller;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.soft863.entity.Dept;
import com.soft863.entity.PageSplit;
import com.soft863.entity.Role;
import com.soft863.entity.User;
import com.soft863.entity.User_Role;
import com.soft863.service.UserService;
import com.soft863.utils.MD5Util;

@Controller
public class UserController {

	public UserController() {
		System.out.println("66666666");
	}

	@Resource(name = "se")
	UserService us;

	public UserService getUs() {
		return us;
	}

	public void setUs(UserService us) {
		this.us = us;
	}

	// 查询部门信息
	@RequestMapping("/querydept")
	public String viewAdd(Model model) {
		// 查询所有的部门
		List<Dept> list = us.query();
		// 查询所有的角色
		List<Role> queryCode = us.queryCode();
		System.out.println(queryCode);
		model.addAttribute("list", list);
		model.addAttribute("queryCole", queryCode);
		return "tax/user/addUI";
	}

	// 新增用户
	@RequestMapping("/adduser")
	public String insert(User user, MultipartFile headImg, Integer[] ids) throws Exception {
		// 获取文件名
		String filename = headImg.getOriginalFilename();
		// 产生新的文件名
		String name = UUID.randomUUID() + filename.substring(filename.lastIndexOf("."));
		// 文件保存路径
		String path = "D:\\images\\" + name;
		// 把文件进行拷贝
		headImg.transferTo(new File(path));
		// 执行数据库插入操作处理
		user.setHeadimg(name);
		String md5Pwd = MD5Util.GetMD5Code(user.getPassword());
		user.setPassword(md5Pwd);
		us.insert(user);
		Integer idd = user.getId();
		for (Integer id : ids) {
			us.insertId(new User_Role(idd, id));
		}
		return "redirect:/user/1";
	}

	/**
	 * currpage:当前页数 totalpage:总页数 totalcnt 总条数
	 * @param model
	 * @param ps
	 * @return
	 */
	// 用户管理遍历用户信息
	@RequestMapping("/user/{currpage}")
	public String queryUser(Model model, PageSplit ps) {
		// 拿出用户总条数
		int allUser = us.allUser();
		PageSplit p = new PageSplit();
		int totalpage = allUser % p.getP_size() == 0 ? allUser / p.getP_size() : allUser / p.getP_size() + 1;
		if (ps.getCurrpage() == 0 || ps.getCurrpage() < 0 || ps.getCurrpage() == 1) {
			ps.setCurrpage(1);
		} else if (ps.getCurrpage() == totalpage || ps.getCurrpage() > totalpage) {
			ps.setCurrpage(totalpage);
		}else{
			ps.setCurrpage(ps.getCurrpage());
		}
		PageSplit pss = new PageSplit(ps.getCurrpage(), allUser);
		List<User> queryUser = us.queryUser(pss);
		model.addAttribute("queryUser", queryUser);
		model.addAttribute("ps", pss);
		System.out.println(queryUser);
		return "tax/user/listUI";
	}

	// 编辑
	@RequestMapping("/updateuser")
	public String update(Integer id, Model model) {
		List<Dept> query = us.query();
		//
		List<Role> code = us.queryCode();
		// 拿出用户信息
		User update = us.update(id);
		System.out.println(update.getId());
		// 中间表实体类 角色和用户
		User_Role ur = new User_Role(id);
		List<User_Role> queryRole = us.queryRole(ur);
		// 前台拿角色
		model.addAttribute("code", code);
		// 前台拿部门
		model.addAttribute("query", query);
		// 前台拿用户信息
		model.addAttribute("update", update);
		// 前台拿中间表的与角色表对应的id
		model.addAttribute("userRole", queryRole);
		return "tax/user/editUI";
	}

	// 修改成功 跳转页面
	@RequestMapping("/updatesuccess")
	public String edit(User user, MultipartFile headImg, Integer[] ids) throws Exception {
		Integer id = user.getId();
		us.delete(id);
		// 获取文件名 ☆☆☆☆☆☆☆☆☆☆☆☆☆
		String originalFilename = headImg.getOriginalFilename();
		// 产生新的文件名 ☆☆☆☆☆☆☆☆☆☆☆☆☆
		String fileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
		// 文件保存路径☆☆☆☆☆☆☆☆☆☆☆☆☆
		String name = "D:\\images\\" + fileName;
		// 把文件进行拷贝☆☆☆☆☆☆☆☆☆☆☆☆☆
		// 执行数据库操作☆☆☆☆☆☆☆☆☆☆☆☆☆
		user.setHeadimg(fileName);
		// 拿出本次用户加密的用户id
		User update = us.update(id);
		// 数据库原加密 密码
		String password2 = update.getPassword();
		// 拿出修改 或者不修改的用户id 进行判断 如果修改 把新密码进行加密存进数据库 如果没修改 原密码存进数据库
		String password = user.getPassword();
		String updatePwd = MD5Util.GetMD5Code(user.getPassword());
		if (password.equals(password2)) {
			us.updateUser(user);
		}else{
			user.setPassword(updatePwd);
			us.updateUser(user);
		}
		// 直接把数组存到集合中 用Arrays.asList 方法
		List<Integer> asList = Arrays.asList(ids);
		user.setIds(asList);
		us.insertUserRole(user);
		return "redirect:/user/1";
	}

	// list页面 删除用户角色
	@RequestMapping("/deleteuser")
	public String delete(Integer id) {
		int delete = us.delete(id);
		System.out.println(delete);
		User user = new User(id);
		int deleteUser = us.deleteUser(user);
		System.out.println(deleteUser);
		return "redirect:/user/1";
	}

	// 批量删除
	@RequestMapping("/deleteRole")
	public String deleteRole(Integer[] ids,Model model) {
		if(ids != null && ids.length != 0){
			for (int i = 0; i < ids.length; i++) {
				Integer integer = ids[i];
				us.delete(integer);
				User user = new User(integer);
				us.deleteUser(user);
			}
		}else{
			model.addAttribute("delete", "删除的用户为空");
		}
		return "redirect:/user/1";
	}

	// 查询所有的用户Name
	@RequestMapping("/checkName")
	public void select(String account, HttpServletResponse resp) throws Exception {
		resp.setCharacterEncoding("utf-8");
		List<User> selectName = us.selectName(account);
		PrintWriter pw = resp.getWriter();
		if (selectName != null && selectName.size() != 0) {
			pw.println("{\"msg\":\"账号已存在\"}");
		} else {
			pw.println("{\"msg\":\"账号可用\"}");
		}
	}

	// 模糊查询 list页面进行查询
	@RequestMapping("/queryName")
	public String inquire(User user, Model model) {
		List<User> queryName = us.queryName(user);
		System.out.println(queryName);
		model.addAttribute("queryUser", queryName);
		return "/tax/user/listUI";
	}
	
	//导出
	@RequestMapping("/download")
	public String downExcel(ModelMap map){
		List<User> list = new ArrayList<User>();
		List<User> download = us.download();
		for (User user : download) {
			list.add(user);
		}
		map.put("list", list);
		//下载文件头信息
		String[] titles = {"用户名","账户","所属部门","性别","电子邮箱"};
		map.put("titles", titles);
		//下载文件名
		String filename = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+".xls";
		map.put("filename", filename);
		return "/excelView";
	}
	
	//导入
	@RequestMapping("/upload")
	public String upload(){
		System.out.println("111111");
		return "redirect:/user/1";
		
		
	}
}