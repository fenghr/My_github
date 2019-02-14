package com.soft863.controller;


import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soft863.entity.Code;
import com.soft863.entity.ListCode;
import com.soft863.entity.PageSplit;
import com.soft863.entity.Role;
import com.soft863.entity.Role_Code;
import com.soft863.service.RoleService;

@Controller
@RequestMapping("/roled")
public class RoleController {
	@Resource
	RoleService rs;
	//查找权限表
	@RequestMapping("/code1")
	public String code(HttpSession hs){
		List<Code> list = rs.find();
		hs.setAttribute("list", list);
		return "/tax/role/addUI";
	}
	//添加角色
	@RequestMapping("/roleAdd")
	public String roleAdd(ListCode list,HttpServletRequest req,Role r){
		//添加角色前判断角色是否存在
			int rcid = 0;
			//存储用户名
			int i = rs.addRole(r);
			if(i>0){
				//拿取新注册用户的ID
				Role role = rs.updateId(r);
				//前台新增存储角色权限
				List<Code> list2 = list.getGoodslist();
				for (Code code : list2) {
					if(code.getCode() != null){
						//角色ID 与 权限ID 存储入中间表 j0305_g2_tb_role_code
						Role_Code  rc= new Role_Code(role.getId(),code.getId()); 
						int in = rs.addRCid(rc);
						if(in >0){
							rcid = rcid+1;
						}
					}
				}
				return "redirect:/roled/stampa";
		}
		return "/tax/role/addUI";
	}
	
	//分页查询
	@RequestMapping("/cooo")
	public String pagingRole(PageSplit rsp,HttpSession hs,String inputRole){
		int totalpage = rsp.getTotalpage();
		if(inputRole != null && inputRole!= ""){
			int parseInt = Integer.parseInt(inputRole);
			if(parseInt<=1){
				parseInt = 1;
			}else if(parseInt>=totalpage){
				parseInt=totalpage;
			}
			rsp.setCurrpage(parseInt);
		}
		int t = rsp.getTotalcnt();
		int c = rsp.getCurrpage();
		PageSplit r = new PageSplit(c,t);
		List<Role> list = rs.updateRole(r);
		hs.setAttribute("fq", r);
		hs.setAttribute("role", list);
		return "/tax/role/listUI";
		
	}
	
	//角色前台显示 
	@RequestMapping("/stampa")
	public String stamp(HttpSession hs){
		//查询总条数数据
		int countRole = rs.countRole();
		hs.setAttribute("countRole", countRole);
		
		PageSplit fq = new PageSplit(1,countRole);
		//将总页数存入
		hs.setAttribute("fq", fq);
		List<Role> list = rs.updateRole(fq);
		hs.setAttribute("role", list);
		return "/tax/role/listUI";
	}
	//编辑角色信息返回拿取点击角色信息
	@RequestMapping("/role_compile")
	public String compile(Integer id,HttpSession hs){
		//通过角色ID查询角色信息
		Role r = new Role(id);
		Role role = rs.updaId(r);
		hs.setAttribute("role1", role);
		List<Code> list = rs.find();
		hs.setAttribute("list", list);
		//通过用ID查询中间表role_code 对应的权限ID
		Role_Code rc = new Role_Code(id);
		 List<Role_Code> referCid = rs.referCid(rc);
		hs.setAttribute("RCode", referCid);
		return "/tax/role/editUI";
	}
	
	//修改编辑过的角色信息
	@RequestMapping("/amend")
	public String amendRole(ListCode lc,Role r){
		//修改角色信息
		List<Integer> lis = new ArrayList<Integer>();
		List<Code> goodslist = lc.getGoodslist();
		for (Code code : goodslist) {
			if(code.getCode() != null){
				Integer id = code.getId();
				lis.add(id);
			}
		}
		r.setIntegers(lis);
		rs.alter(r);
		return "redirect:/roled/stampa";
	}
	//删除角色信息
	@RequestMapping("/delete.action")
	public String deleteAction(Integer id){
		//删除
		int i = rs.deleteRole(id);
		if(i>0){
			return "redirect:/roled/stampa";
		}
		return "/tax/role/listUI";
	}
	
	//批量删除
	@RequestMapping(value="/delete.all" )
	public String deleteAll(Integer[] selectedRow){
		int i = 0;
		for (Integer id : selectedRow) {
			//删除
			  int j = rs.deleteRole(id);
			  if(j>0){
				  i = i+1;
			  }
		}
		if(i == selectedRow.length){
			return "redirect:/roled/stampa";
		}
		return "/tax/role/listUI";
	}
	//模糊查询
	@RequestMapping("/inquire.Role")
	public String inquireRole(String rname,HttpSession hs){
		 if(rname == null || rname.equals("")){
			 return "redirect:/roled/stampa"; 
		 }
		 hs.setAttribute("rname", rname);
		Role r = new Role(rname);
		List<Role> list = rs.inquireRole(r);
		int size = list.size();
		hs.setAttribute("countRole", size);
		PageSplit fq = new PageSplit(1,size);
		//将总页数存入
		hs.setAttribute("fq", fq);
		List<Role> dimRole = rs.dimRole(r);
		
		hs.setAttribute("role", dimRole);
		return "/tax/role/listUI";
	}
	
	//ajax验证
	@RequestMapping("/ajaxRole")
	public void judgeRole(Role r,HttpServletResponse resp) throws Exception{
		resp.setCharacterEncoding("utf-8");
		Role role = rs.judgeRole(r);
		
		PrintWriter writer = resp.getWriter();
		if(role != null ){
			writer.println("角色名无效");
		}else{
			writer.println("角色名有效");
		}
		
	}
	
	
	
}
