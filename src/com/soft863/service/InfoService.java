package com.soft863.service;

import java.util.List;

import com.soft863.entity.Info;
import com.soft863.entity.Types;

public interface InfoService {
	/**
	 * 通过ID查询
	 * 
	 * @param info
	 * @return
	 */
	public Info queryInfoids(int info_id);

	/**
	 * info 信息发布模糊 查询
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
	 * @param title
	 * @return
	 */
	public List<Info> queryexcel();

	/**
	 * 删除信息
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
	 * 查询信息
	 */
	public List<Types> queryType();

	/**
	 * 查询总条数
	 */
	public int countInfo(Info info);
}
