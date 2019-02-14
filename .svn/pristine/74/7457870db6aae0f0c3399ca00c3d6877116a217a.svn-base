package com.soft863.service;

import java.util.List;
import java.util.Map;
import com.soft863.entity.Complain;
import com.soft863.entity.Complain_reply;
import com.soft863.entity.Dept;
import com.soft863.entity.FuzzyQuery;
import com.soft863.entity.PageSplit;
import com.soft863.entity.StatisticsChart;
import com.soft863.entity.User;

/**
 * 
 * @author Administrator
 *
 */
public interface ComplainService {


	/**
	 * 投诉统计饼状图
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> showStatisticsChart(Integer year) throws Exception;

	/**
	 * 查询当前投诉信息中没处理的投诉信id和投诉时间
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Complain> allIdComp_time() throws Exception;

	/**
	 * 
	 * @param comp
	 * @return
	 * @throws Exception
	 */
	public int timing(Complain comp) throws Exception;

	/**
	 * 
	 * @param fq0 
	 * @return
	 * @throws Exception
	 */
	public int likeCount(FuzzyQuery fq0) throws Exception;

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Complain> complainAllMessage() throws Exception;

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Complain> queryComplainAllMessage(int id) throws Exception;

	/**
	 * 查询All部门
	 * 
	 * @return
	 * @throws Exception
	 */

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Dept> queryAllDept() throws Exception;

	/**
	 * 通过部门Id查询部门下姓名
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<User> queryByUserName(int id) throws Exception;

	/**
	 * 
	 * @param comp
	 * @return
	 * @throws Exception
	 */
	public int addComplainMessage(Complain comp) throws Exception;

	/**
	 * 
	 * @param comp
	 * @return
	 * @throws Exception
	 */
	public Complain additionalInformation(Complain comp) throws Exception;

	/**
	 * 
	 * @param comp
	 * @return
	 * @throws Exception
	 */
	public List<Complain> complaintManagement(PageSplit page) throws Exception;

	/**
	 * 
	 * @param cr
	 * @return
	 * @throws Exception
	 */
	public Complain acceptComplainMessage(Complain_reply id) throws Exception;

	/**
	 * 点击受理------回复信息保存
	 * 
	 * @param id受理信息id;cr
	 *            对象回复人id,部门id,回复人名;部门名,回复时间,回复内容做insert into 插入数据在complain_reply回复表
	 * @return
	 * @throws Exception
	 */
	public int saveAcceptComplainReplyMessage(Integer id, Complain_reply cr) throws Exception;

	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<Complain> queryComplainAllMessage11(Integer id) throws Exception;

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public int totalCount() throws Exception;

	/**
	 * 
	 * @param fq
	 * @return
	 * @throws Exception
	 */
	public List<Complain> doSearchFuzzyQuery(FuzzyQuery fq) throws Exception;

	/**
	 * 查询统计表中的年份...
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<StatisticsChart> statisticsChartYear() throws Exception;
}
