package com.soft863.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.soft863.entity.User;

/**
 * 拦截器HandlerInterceptor
 * 
 * @author Administrator
 *
 */
public class InterceptorDemo implements HandlerInterceptor {
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object obj) throws Exception {
		String url = req.getRequestURI();
		HttpSession sess = req.getSession();
		User user = (User) sess.getAttribute("loginUser");
		System.out.println("♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣" + url);
		boolean flag = false;
		// 登录页面--放开
		if (url.endsWith("g2_tax/") || url.endsWith("loginUI.jsp") || url.endsWith(".js") || url.endsWith(".css")
				|| url.endsWith(".png") || url.endsWith("ma_randimg") || url.endsWith("map") || url.endsWith(".jpg")
				|| url.endsWith(".gif") || url.endsWith("flash.swf") || url.endsWith("exit")
				|| url.endsWith("demo/home")||url.endsWith("checkName")) {
			flag = true;
		}

		// 用户没有登录
		if (user == null) {
			// 工作主页
			// 用户没有登录拦截页面 demo/test queryQian View.action flash.swf Message.action queryId
			// frame.jsp
			if (url.endsWith("demo/test") || url.endsWith("queryQian") || url.endsWith("View.action")
					|| url.endsWith("flash.swf") || url.endsWith("Message.action") || url.endsWith("queryId")
					|| url.endsWith("stampa") || url.contains("user") || url.endsWith("queryAll")
					|| url.endsWith("Accept.comp") || url.contains("Message.action") || url.contains(".comp")
					|| url.endsWith("frame.jsp") || url.endsWith("queryType") || url.endsWith("ZeroClipboard.swf")) {
				resp.sendRedirect("/g2_tax/loginUI.jsp");
				// req.getRequestDispatcher("/loginUI.jsp").forward(req, resp);

				flag = false;
			}
		} else {
			// 用户登录 放开页面
			// 根据用户查询出的权限 拦截,放开某些页面
			flag = true;
		}
		return flag;
	}

}
