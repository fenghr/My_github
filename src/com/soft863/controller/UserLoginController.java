package com.soft863.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soft863.entity.User;
import com.soft863.entity.User_Bean;
import com.soft863.service.ComplainService;
import com.soft863.service.UserLoginService;
import com.soft863.utils.MD5Util;

/**
 * 用户登录控制层
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/demo")
public class UserLoginController {

	@Resource
	UserLoginService ulService;

	@Resource
	ComplainService cs;

	public UserLoginController() {
		System.out.println("userLoginController实例化");
	}

	/**
	 * 退出操作
	 * 
	 * @param sess
	 * @return
	 */
	@RequestMapping("/exit")
	public String exit(HttpSession sess) {
		sess.removeAttribute("loginUser");
		return "loginUI";

	}

	/**
	 * 登录产生随机码
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ma_randimg")
	public String randimg() throws Exception {
		System.out.println("产生随机数");
		return "extraCode";
	}

	/**
	 * 运用jQuery中的ajax请求判断用户名是否存在
	 * 
	 * @param user
	 * @param resp
	 * @throws Exception
	 */

	@RequestMapping("/checkName")
	public @ResponseBody User_Bean checkName(String account, HttpServletResponse resp, HttpServletRequest req,HttpSession sess) throws Exception {
		// 设置编码格式
		resp.setCharacterEncoding("utf-8");

		User u = new User();
		u.setAccount(account);
		// 获取输入的账户名ub
		User user2 = ulService.login(u);
		System.out.println(user2);
		// 创建对象
		User_Bean ub = new User_Bean();
		if (user2 != null) {
			if (user2.getAccount().equals(account)) {
				// 获取浏览器的所有Cookie
				Cookie[] cookies = req.getCookies();
				for (Cookie cookie : cookies) {
					String name = cookie.getName();
					String value = cookie.getValue();
					if (name.endsWith(account)) {
						ub.setPassword(value);
						ub.setMsg("用户名有效");
						System.out.println(value);
					}
				}
				ub.setMsg("用户名有效");
				// pw.println("{\"msg\":\"用户名有效\"}");
			} else {
				ub.setMsg("用户名不存在");
				// pw.println("{\"msg\":\"用户名不存在\"}");
			}
		} else {
			ub.setMsg("用户名不存在");
			// pw.println("{\"msg\":\"用户名不存在\"}");
		}
		return ub;
	}

	/**
	 * 判断用户名、密码、验证码是否为空
	 * 
	 * @param user
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/home")
	public String login(User user, Model model, HttpSession session, HttpServletRequest req, HttpServletResponse resp)
			throws Exception {

		String rand = (String) session.getAttribute("rand");// 从session中拿到验证码
		String res = null;
		String rand1 = user.getValidateCode();
		// 判断用户名、密码、验证码是否为空
		if (rand1 == null || rand1.equals("")) {
			model.addAttribute("msg_info", "验证码不能为空");
			res = "loginUI";
		}
		if (user.getAccount() == null || user.getAccount().equals("")) {
			model.addAttribute("msg_infu", "用户名不能为空！");
			res = "loginUI";
		}
		if (user.getPassword() == null || user.getPassword().equals("")) {
			model.addAttribute("msg_infa", "密码不能为空！");
			res = "loginUI";
		}
		// 基本校验
		if (res != null) {
			return res;
		}

		// 获取checkbox框的值
		String rememberpwd = req.getParameter("rememberpwd");
		if ("on".equals(rememberpwd) || rememberpwd != null) {
			// 生成Cookie对象,把账户密码存入Cookie
			Cookie c = new Cookie(user.getAccount(), user.getPassword());
			// 设置Cookie的最大年龄
			c.setMaxAge(60 * 60 * 2);
			// 向浏览器写Cookie
			resp.addCookie(c);
		}
		// 登录校验
		// 判断用户是否存在，及账户密码校验
		// user.setPassword(md5pwd);
		User user1 = ulService.login(user);
		
		System.out.println(user1);
		String md5pwd = MD5Util.GetMD5Code(user.getPassword());
		if (user1 == null) {
			model.addAttribute("msg_infu", "用户不存在");
			res = "loginUI";
			return res;
		} else {
			//查看用户身份是否有效
			String state = user1.getState();
			if (!rand1.equals(rand)) {
				model.addAttribute("msg_info", "验证码不正确");
				res = "loginUI";
			} else if (!md5pwd.equals(user1.getPassword())) {
				model.addAttribute("msg_infa", "密码不正确");
				res = "loginUI";
			} else if("1".equals(state)){
				session.setAttribute("loginUser", user1);
				res = "redirect:/demo/test";
			}else{
				model.addAttribute("msg_infu","用户身份无效");
				res = "loginUI";
			}
		}
		return res;
	
	}
	@RequestMapping("/test")
	public String method() {
		return "/home/home";

	}

}
