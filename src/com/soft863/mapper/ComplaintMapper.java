package com.soft863.mapper;

import java.util.List;

import com.soft863.entity.Complain;
import com.soft863.entity.Complain_reply;
import com.soft863.entity.Dept;
import com.soft863.entity.FuzzyQuery;
import com.soft863.entity.PageSplit;
import com.soft863.entity.StatisticsChart;
import com.soft863.entity.User;

/**
 * 投诉管理
 * 
 * @author Administrator
 *
 */
public interface ComplaintMapper {
	/**
	 * home.Jsp页面根据用户Id查询的投诉信息模块展示
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Complain> complainAllMessage() throws Exception;

	/**
	 * complainViewUI.jsp页面查询All投诉人信息,投诉信息的select,受理信息状态
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Complain> queryComplainAllMessage(int id) throws Exception;

	/**
	 * 二级联动---查询部门
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Dept> queryAllDept() throws Exception;

	/**
	 * 二级联动----查询用户名
	 * 
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
	 * 工作主页-----我要投诉保存投诉信息是查询出投诉人/被投诉人的所有信息保存在Complain对象
	 * 
	 * @param comp_id
	 * @param comp_deptid
	 * @return
	 */
	public Complain additionalInformation(Complain compd) throws Exception;

	/**
	 * 纳税服务----投诉受理管理--查询出所有的投诉信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Complain> complaintManagement(PageSplit page) throws Exception;

	/**
	 * 投诉信息受理 根据投诉信息id查询投诉信息 根据当前用户id查询受理人信息
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
	public int saveAcceptComplainReplyMessage(Complain_reply cr) throws Exception;

	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int updateComplainState(Integer id) throws Exception;

	/**
	 * 
	 * @param cr
	 * @return
	 * @throws Exception
	 */
	public List<Complain> queryComplainAllMessage11(Integer cr) throws Exception;

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public int totalCount() throws Exception;

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public int likeCount(FuzzyQuery fq) throws Exception;

	/**
	 * 
	 * @param fq
	 * @return
	 * @throws Exception
	 */
	public List<Complain> doSearchFuzzyQuery(FuzzyQuery fq) throws Exception;

	/**
	 * 更新投诉状态为已失效
	 * 
	 * @param comp
	 * @return
	 * @throws Exception
	 */
	public int timing(Complain comp) throws Exception;

	/**
	 * 查询当前投诉信息中没处理的投诉信id和投诉时间
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Complain> allIdComp_time() throws Exception;

	/**
	 * 投诉统计饼状图
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<StatisticsChart> showStatisticsChart(Integer year) throws Exception;

	/**
	 * 查询统计表中的年份...
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<StatisticsChart> statisticsChartYear() throws Exception;

}
