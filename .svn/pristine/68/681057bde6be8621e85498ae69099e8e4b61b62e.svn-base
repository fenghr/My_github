package com.soft863.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft863.entity.Complain;
import com.soft863.entity.Complain_reply;
import com.soft863.entity.Dept;
import com.soft863.entity.FuzzyQuery;
import com.soft863.entity.PageSplit;
import com.soft863.entity.StatisticsChart;
import com.soft863.entity.User;
import com.soft863.mapper.ComplaintMapper;
import com.soft863.service.ComplainService;

/**
 * 
 * @author Administrator
 *
 */
@Service
public class ComplainServiceImpl implements ComplainService {

	@Autowired
	ComplaintMapper cm;

	/**
	 * 
	 * @param fq0
	 * @return
	 * @throws Exception
	 */
	public int likeCount(FuzzyQuery fq0) throws Exception {
		return cm.likeCount(fq0);
	}

	/**
	 * 查询当前投诉信息中没处理的投诉信id和投诉时间
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Complain> allIdComp_time() throws Exception {
		return cm.allIdComp_time();
	}

	/**
	 * 
	 */
	public int timing(Complain comp) throws Exception {
		return cm.timing(comp);
	}

	@Override
	public List<Complain> complainAllMessage() throws Exception {
		return cm.complainAllMessage();
	}

	@Override
	public List<Complain> queryComplainAllMessage(int id) throws Exception {
		return cm.queryComplainAllMessage(id);
	}

	@Override
	public List<Complain> queryComplainAllMessage11(Integer cr) throws Exception {
		return cm.queryComplainAllMessage11(cr);
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Dept> queryAllDept() throws Exception {
		return cm.queryAllDept();
	}

	/**
	 * 
	 */
	@Override
	public List<User> queryByUserName(int id) throws Exception {
		return cm.queryByUserName(id);
	}

	/**
	 * 
	 * @param comp
	 * @return
	 * @throws Exception
	 */
	@Override
	public int addComplainMessage(Complain comp) throws Exception {
		return cm.addComplainMessage(comp);
	}

	@Override
	public Complain additionalInformation(Complain comp) throws Exception {
		return cm.additionalInformation(comp);
	}

	@Override
	public List<Complain> complaintManagement(PageSplit page) throws Exception {
		return cm.complaintManagement(page);
	}

	@Override
	public Complain acceptComplainMessage(Complain_reply id) throws Exception {
		return cm.acceptComplainMessage(id);
	}

	/**
	 * 点击受理------回复信息保存
	 * 
	 * @param id受理信息id;cr
	 *            对象回复人id,部门id,回复人名;部门名,回复时间,回复内容做insert into 插入数据在complain_reply回复表
	 * @return
	 * @throws Exception
	 */
	public int saveAcceptComplainReplyMessage(Integer id, Complain_reply cr) throws Exception {
		int i = cm.updateComplainState(id);
		if (i > 0) {
			return cm.saveAcceptComplainReplyMessage(cr);
		}
		return i;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public int totalCount() throws Exception {
		return cm.totalCount();
	}

	/**
	 * 
	 */
	public List<Complain> doSearchFuzzyQuery(FuzzyQuery fq) throws Exception {
		return cm.doSearchFuzzyQuery(fq);

	}

	/**
	 * 投诉统计饼状图
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List<Map> showStatisticsChart(Integer year) throws Exception {
		List<Map> listMap = new ArrayList<Map>();
		List<StatisticsChart> list = cm.showStatisticsChart(year);
		Map<String, String> map = null;
		for (StatisticsChart lis : list) {
			map = new HashMap<String, String>();
			String month = lis.getMonth();
			String complainCount = lis.getComplainCount();
			map.put("label", month);
			map.put("value", complainCount);
			listMap.add(map);
		}
		return listMap;
	}

	/**
	 * 
	 */
	@Override
	public List<StatisticsChart> statisticsChartYear() throws Exception {
		return cm.statisticsChartYear();
	}

}
