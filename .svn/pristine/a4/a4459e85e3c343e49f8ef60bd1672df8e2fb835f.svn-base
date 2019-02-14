package com.soft863.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.soft863.entity.Info;
import com.soft863.entity.PageSplit;
import com.soft863.entity.Types;
import com.soft863.service.InfoService;

@Controller
public class InfoController {
	@Resource
	InfoService infoService;

	/**
	 * 通过ID查询
	 * 
	 * @param info
	 * @return
	 */
	@RequestMapping("/queryinfoid")
	public String queryinfoids(Model model, int info_id) {
		Info info = infoService.queryInfoids(info_id);
		List<Types> list = infoService.queryType();
		System.out.println("----------" + info);
		model.addAttribute("list", list);
		model.addAttribute("info", info);
		return "/tax/info/editUI";
	}

	/**
	 * 模糊查询
	 * 
	 * @param info
	 * @return
	 */
	@RequestMapping("/queryAll")
	public @ResponseBody PageSplit query(Info info, PageSplit pageSplit) {
		PageSplit p = new PageSplit();
		int cnt = 0;
		cnt = infoService.countInfo(info);
		if(pageSplit.getCurrpage() <= 0){
			pageSplit.setCurrpage(1);
		}
		int maxpage = cnt % p.getP_size() == 0 ? cnt / p.getP_size() : cnt / p.getP_size() + 1;
		if(pageSplit.getCurrpage() >= maxpage){
			pageSplit.setCurrpage(maxpage);
		}
		PageSplit ps = new PageSplit(pageSplit.getCurrpage(), cnt);
		info.setStart(ps.getStart());
		List<Info> list = infoService.queryInfo(info);
		ps.setList(list);
		System.out.println("------------" + ps);
		return ps;
	}

	/**
	 * 前台查询
	 * 
	 * @param info
	 * @return
	 */
	@RequestMapping("/queryQian")
	public @ResponseBody List<Info> queryQ() {
		List<Info> list = infoService.queryInfos();
		return list;
	}

	/**
	 * 删除
	 * 
	 * @param selectedRow
	 * @return
	 */
	@RequestMapping("/delByid")
	public String del(Integer[] selectedRow) {
		if (selectedRow != null) {
			infoService.delInfo(selectedRow);
			return "tax/info/listUI";
		}
		return "tax/info/listUI";
	}

	/**
	 * 修改状态
	 * 
	 * @param selectedRow
	 * @return
	 */
	@RequestMapping("/upstate")
	public String updateState(Info info) {
		infoService.updateState(info);
		return "tax/info/listUI";
	}

	/**
	 * 修改信息
	 * 
	 * @param selectedRow
	 * @return
	 */
	@RequestMapping("/updateinfo")
	public String updateInfo(Info info,HttpServletRequest request) {
		infoService.updateInfo(info);
		request.getSession().setAttribute("upcurrpage", info.getCurrpage());
		return "tax/info/listUI";
	}

	/**
	 * 添加
	 * 
	 * @param selectedRow
	 * @return
	 */
	@RequestMapping("/addinfo")
	public String addInfo(Info info) {
		infoService.addInfo(info);
		return "tax/info/listUI";
	}

	/**
	 * queryexcel------------------------------------------------------------------------------------------
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/queryexc")
	public String queryExcel(Model model) {
		List<Info> list = infoService.queryexcel();
		model.addAttribute("list", list);
		return "downexcel";
	}

	/**
	 * 查询类型
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/queryType")
	public @ResponseBody List<Types> queryType() {
		List<Types> list = infoService.queryType();
		return list;
	}
	/**
	 * 前台通过ID查询
	 * 
	 * @param info
	 * @return
	 */
	@RequestMapping("/queryId")
	public String queryid(Model model, int info_id) {
		Info info = infoService.queryInfoids(info_id);
		model.addAttribute("info", info);
		System.out.println(info);
		return "/home/infoViewUI";
	}

}
