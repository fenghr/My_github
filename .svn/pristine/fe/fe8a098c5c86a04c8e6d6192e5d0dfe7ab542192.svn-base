package com.soft863.mapper;

import java.util.List;

import com.soft863.entity.Info;
import com.soft863.entity.Types;

public interface InfoMapper {
	/**
	 * 通过ID查询
	 * 
	 * @param info
	 * @return
	 */
	public Info queryInfoids(int info_id);

	/**
	 * info 信息发布 模糊查询
	 * 
	 * @return
	 */
	public List<Info> queryInfo(Info info);

	/**
	 * 前台查询
	 * 
	 * @param info
	 * @return
	 */
	public List<Info> queryInfos();

	/**
	 * excel
	 * 
	 * @return
	 */
	public List<Info> queryexcel();

	/**
	 * 删除
	 */
	public int delInfo(Integer[] id);

	/**
	 * 修改状态
	 */
	public int updateState(Info info);

	/**
	 * 修改信息
	 */
	public int updateInfo(Info info);

	/**
	 * 添加信息
	 */
	public int addInfo(Info info);

	/**
	 * 查询类型
	 */
	public List<Types> queryType();

	/**
	 * 查询总条数
	 */
	public int countInfo(Info info);
}
