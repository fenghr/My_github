package com.soft863.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 信息发布表 Info
 * 
 * @author fenghr
 *
 */
public class Info extends PageSplit implements Serializable  {

	private static final long serialVersionUID = -5526920462006604754L;
	private Integer info_id;// 信息id
	private int typeid;// 信息分类：通知公告、政策速递、纳税指导
	private String source;// 信息来源
	private String title;// 信息标题
	private String content;// 信息内容
	private String memo;// 信息备注
	private int creatorid;// 信息创建者
	private String create_time;// 信息创建的时间
	private String state;// 信息状态
	private List<Types> types;
	private User user;
	private PageSplit pageSplit;
	public Info() {
	}

	public PageSplit getPageSplit() {
		return pageSplit;
	}

	public void setPageSplit(PageSplit pageSplit) {
		this.pageSplit = pageSplit;
	}

	public Info(Integer info_id, int typeid, String source, String title, String content, String memo, int creatorid,
			String create_time, String state, List<Types> types, User user) {
		super();
		this.info_id = info_id;
		this.typeid = typeid;
		this.source = source;
		this.title = title;
		this.content = content;
		this.memo = memo;
		this.creatorid = creatorid;
		this.create_time = create_time;
		this.state = state;
		this.types = types;
		this.user = user;
	}

	public Integer getInfo_id() {
		return info_id;
	}

	public void setInfo_id(Integer info_id) {
		this.info_id = info_id;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public int getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(int creatorid) {
		this.creatorid = creatorid;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Types> getTypes() {
		return types;
	}

	public void setTypes(List<Types> types) {
		this.types = types;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Info [info_id=" + info_id + ", typeid=" + typeid + ", source=" + source + ", title=" + title
				+ ", content=" + content + ", memo=" + memo + ", creatorid=" + creatorid + ", create_time="
				+ create_time + ", state=" + state + ", types=" + types + ", user=" + user + ", pageSplit=" + pageSplit
				+ "]";
	}






}
