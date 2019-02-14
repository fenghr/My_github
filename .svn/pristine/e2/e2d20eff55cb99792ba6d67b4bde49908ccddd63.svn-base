//package servlet;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.alibaba.fastjson.JSON;
//
//import bean.PageSplit;
//import bean.Tb_MemberBean;
//import bean.Tb_OrderBean;
//import bean.Tb_OrderIdBean;
//import factory.BeanFactory;
//import service.Tb_OrderService;
//import service.serviceImpl.Tb_OrderServiceImpl;
//
//@WebServlet("/Tb_OrderServlet")
//public class Tb_OrderServlet extends BaseServlet {
//
//	private static final long serialVersionUID = 1L;
//	Tb_OrderService os = BeanFactory.getBean(Tb_OrderServiceImpl.class);
//	Tb_OrderBean ob = BeanFactory.getBean(Tb_OrderBean.class);
//	Tb_OrderIdBean oi = BeanFactory.getBean(Tb_OrderIdBean.class);
//
//	/**
//	 * 前台订单查询
//	 * 
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	public String queryOrder(HttpServletRequest request, HttpServletResponse response) {
//		try {
//			String curr = request.getParameter("currpage");
//			Tb_MemberBean memberid = (Tb_MemberBean) request.getSession().getAttribute("loginUser");
//			if (curr == null || "0".equals(curr)) {
//				curr = "1";
//			}
//			int cnt = os.count(memberid.getId());
//			PageSplit p = new PageSplit();
//			int maxpage = cnt % p.getP_size() == 0 ? cnt / p.getP_size() : cnt / p.getP_size() + 1;
//			if (curr == null || Integer.parseInt(curr) >= maxpage) {
//				curr = String.valueOf(maxpage);
//			}
//			PageSplit ps = new PageSplit(Integer.parseInt(curr), cnt);
//			ob.setMemberid(memberid.getId());
//			List<Map<String, Object>> list = os.queryOrder(ob, ps.getEnd(), ps.getStart());
//			ps.setList(list);
//			request.setAttribute("orderList", ps);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "chankan.jsp";
//	}
//
//	/**
//	 * 前台查询ajax无刷新
//	 */
//	public void queryOrderAjax(HttpServletRequest request, HttpServletResponse response) {
//		try {
//			PageSplit p = new PageSplit();
//			Tb_MemberBean memberid = (Tb_MemberBean) request.getSession().getAttribute("loginUser");
//			int cnt = os.count(memberid.getId());
//			int maxpage = cnt % p.getP_size() == 0 ? cnt / p.getP_size() : cnt / p.getP_size() + 1;
//			String curr = request.getParameter("currpage");
//			if (curr == null || "0".equals(curr)) {
//				curr = "1";
//			}
//			if (curr == null || Integer.parseInt(curr) >= maxpage) {
//				curr = String.valueOf(maxpage);
//			}
//			PageSplit ps = new PageSplit(Integer.parseInt(curr), cnt);
//			ob.setMemberid(memberid.getId());
//			List<Map<String, Object>> list = os.queryOrder(ob, ps.getEnd(), ps.getStart());
//			ps.setList(list);
//			List<PageSplit> lists = new ArrayList<PageSplit>();
//			lists.add(ps);
//			response.getWriter().print(JSON.toJSONString(ps));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * 订单单号查询
//	 * 
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	public String queryOrderId(HttpServletRequest request, HttpServletResponse response) {
//		try {
//			String ordercode = request.getParameter("ordercode");
//			String flag = request.getParameter("flag");
//			oi.setOrdercode(ordercode);
//			List<Map<String, Object>> list = os.queryOrderId(oi);
//			List<Map<String, Object>> list2 = os.queryOrderDetail(oi);
//			request.setAttribute("orderIdList", list);
//			request.setAttribute("orderIdList2", list2);
//			if ("o".equals(flag)) {
//				return "orderManageView.jsp";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "/diandanxianxi.jsp";
//	}
//
//}
