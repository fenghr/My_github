package com.soft863.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.soft863.entity.Complain;
import com.soft863.entity.Complain_reply;
import com.soft863.entity.Dept;
import com.soft863.entity.FuzzyQuery;
import com.soft863.entity.PageSplit;
import com.soft863.entity.StatisticsChart;
import com.soft863.entity.User;
import com.soft863.service.ComplainService;

/**
 * 
 * @author Administrator
 *
 */
@Controller
public class ComplainController {
	@Resource
	ComplainService cs;

	/**
	 * home.jsp主页面 定时...... final Timer timer = new Timer();
	 * timer.scheduleAtFixedRate(new TimerTask() {
	 * 
	 * @Override public void run() {
	 * 
	 *           }}, firstTime, period);
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/complaintView.action")
	public @ResponseBody List<Complain> complainAllMessage() throws Exception {

		final Timer timer = new Timer();

		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				Date dd = new Date();
				List<Complain> list2;
				try {
					list2 = cs.allIdComp_time();
					for (Complain lis : list2) {
						Date time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(lis.getComp_time());
						long time2 = time.getTime();
						if (dd.getTime() - time2 > 2000) {
							cs.timing(lis);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, 0, 600000);
		List<Complain> list = cs.complainAllMessage();
		return list;
	}

	/**
	 * 投诉管理页面 正常页面显示+分页
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/complaintShowAccept.comp")
	public @ResponseBody PageSplit complaintShowView(FuzzyQuery fq) throws Exception {

		if ((fq.getComp_SearchendTime() == null && fq.getComp_SearchstarTime() == null && fq.getSearchstate() == null
				&& fq.getComp_Searchtitle() == null)
				|| (fq.getComp_SearchendTime() == "" && fq.getComp_SearchstarTime() == "" && fq.getSearchstate() == ""
						&& fq.getComp_Searchtitle() == "")) {
			int totalcnt = cs.totalCount();// 总条数
			PageSplit ps1 = new PageSplit(totalcnt);

			if (fq.getCurrpage() == 0 || fq.getCurrpage() < 0 || fq.getCurrpage() == 1) {
				fq.setCurrpage(1);
			} else if (fq.getCurrpage() == ps1.getTotalpage() || fq.getCurrpage() > ps1.getTotalpage()) {
				fq.setCurrpage(ps1.getTotalpage());
			}
			// 正常查询
			PageSplit pss = new PageSplit(fq.getCurrpage(), totalcnt);
			List<Complain> list = cs.complaintManagement(pss);
			pss.setList(list);
			return pss;
		} else {
			// 模糊查询
			// 模糊查询总条数
			int totalcnt2 = cs.likeCount(fq);
			PageSplit ps2 = new PageSplit(totalcnt2);
			if (fq.getCurrpage() == 0 || fq.getCurrpage() < 0 || fq.getCurrpage() == 1) {
				fq.setCurrpage(1);
			} else if (fq.getCurrpage() == ps2.getTotalpage() || fq.getCurrpage() > ps2.getTotalpage()) {
				fq.setCurrpage(ps2.getTotalpage());
			}
			// 模糊查询中数据
			PageSplit pss = new PageSplit(fq.getCurrpage(), totalcnt2);
			fq.setStart(pss.getStart());
			List<Complain> list = cs.doSearchFuzzyQuery(fq);
			pss.setList(list);
			int currpage = fq.getCurrpage();
			int start = fq.getStart();
			int p_size = fq.getP_size();
			return pss;
		}

	}

	/**
	 * 点击home.jsp中投诉标题展示投诉的message k
	 * 
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/restful/complainUserIdMessage.action/{id}/{state}")
	public String queryComplainAllMessage(@PathVariable("id") Integer id, Model model, Complain comp) throws Exception {
		List<Complain> list = null;
		if ("1".equals(comp.getState())) {
			list = cs.queryComplainAllMessage11(id);
		} else {
			list = cs.queryComplainAllMessage(id);
		}
		model.addAttribute("list", list);
		return "/home/complainViewUI";
	}

	/**
	 * 点击home.jsp中我要投诉
	 * 
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/restful/complainAddUIView.action")
	public String complainUserIdMessage(Model model) throws Exception {
		return "/home/complainAddUI";
	}

	/**
	 * ajax二级联动
	 * 
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	@RequestMapping("/queryByUserName.action")
	public @ResponseBody List<?> queryByUserName(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		resp.setCharacterEncoding("UTF-8");
		String deptid = req.getParameter("deptid");
		if ("0".equals(deptid)) {
			List<Dept> list = cs.queryAllDept();
			return list;
		} else {
			List<User> list = cs.queryByUserName(Integer.parseInt(deptid));
			return list;
		}
	}

	/**
	 * 
	 * 工作主页---保存投诉信息
	 * 
	 * @param comp_id
	 * @param comp
	 * @param resp
	 * @throws Exception
	 */
	@RequestMapping("/restful/addComplainMessage.action")
	public void addComplainMessage(Complain comp, HttpServletResponse resp, HttpSession session) throws Exception {
		User user = (User) session.getAttribute("loginUser");
		comp.setComp_id(user.getId());
		Complain cc = cs.additionalInformation(comp);
		comp.setComp_deptname(cc.getComp_deptname());
		comp.setComp_deptid(cc.getComp_deptid());
		comp.setComop_name(cc.getComop_name());
		comp.setComp_mobile(cc.getComp_mobile());
		comp.setTo_comp_deptname(cc.getTo_comp_deptname());
		comp.setTo_comp_name(cc.getTo_comp_name());
		int i = cs.addComplainMessage(comp);
		if (i > 0) {
			resp.getWriter().write("success");
		} else {
			resp.getWriter().write("defeated");
		}
	}

	/**
	 * 点击受理-------
	 * 
	 * @param 投诉信息id;回复者id;
	 *            查询出投诉人信息,被投诉人信息,回复者信息,dealUI.jsp页面显示
	 * @param model
	 * @param comp
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/restful/acceptComplainMessage.comp")
	public String acceptComplainMessage(Integer id, Model model, Complain_reply comp, HttpSession session)
			throws Exception {
		comp.setComplain_id(id);
		// 回复人id
		User user = (User) session.getAttribute("loginUser");
		comp.setReplyer_id(user.getId());
		Complain list = cs.acceptComplainMessage(comp);
		model.addAttribute("list", list);
		return "/tax/complain/dealUI";
	}

	/**
	 * 点击受理------回复信息保存
	 * 
	 * @param id受理信息id;cr
	 *            对象回复人id,部门id,回复人名;部门名,回复时间,回复内容做insert into 插入数据在complain_reply回复表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/saveAcceptComplainReplyMessage.comp")
	public String saveAcceptComplainReplyMessage(Complain_reply cr) throws Exception {
		cs.saveAcceptComplainReplyMessage(cr.getComplain_id(), cr);
		return "/tax/complain/listUI";

	}

	@RequestMapping("/annualStatisticChartUI.action")
	public String annualStatisticChartUI(Model model) throws Exception {
		List<StatisticsChart> list = cs.statisticsChartYear();
		model.addAttribute("list", list);
		return "/tax/complain/annualStatisticChartUI";
	}

	@RequestMapping("/showStatisticsChart.action")
	public @ResponseBody Map<String, Object> showStatisticsChart(@RequestParam("year") Integer year) throws Exception {
		@SuppressWarnings("rawtypes")
		List<Map> list = cs.showStatisticsChart(year);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("chartData", list);
		return map;
	}
}
