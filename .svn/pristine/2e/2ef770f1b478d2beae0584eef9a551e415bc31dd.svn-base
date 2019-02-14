package com.soft863.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 投诉信息回复Message
 * 
 * @author Administrator
 *
 */
public class Complain_reply implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -4643735504501420008L;
	private Integer reply_id;
	private Integer complain_id;
	private Integer replyer_id;
	private Integer replyer_deptid;
	private Date reply_time;
	private String replyer_name;
	private String reply_deptname;
	private String reply_content;

	public Complain_reply() {
		super();
	}

	public Integer getReply_id() {
		return reply_id;
	}

	public void setReply_id(Integer reply_id) {
		this.reply_id = reply_id;
	}

	public Integer getComplain_id() {
		return complain_id;
	}

	public void setComplain_id(Integer complain_id) {
		this.complain_id = complain_id;
	}

	public Integer getReplyer_id() {
		return replyer_id;
	}

	public void setReplyer_id(Integer replyer_id) {
		this.replyer_id = replyer_id;
	}

	public Integer getReplyer_deptid() {
		return replyer_deptid;
	}

	public void setReplyer_deptid(Integer replyer_deptid) {
		this.replyer_deptid = replyer_deptid;
	}

	public Date getReply_time() {
		return reply_time;
	}

	public void setReply_time(Date reply_time) {
		this.reply_time = reply_time;
	}

	public String getReplyer_name() {
		return replyer_name;
	}

	public void setReplyer_name(String replyer_name) {
		this.replyer_name = replyer_name;
	}

	public String getReply_deptname() {
		return reply_deptname;
	}

	public void setReply_deptname(String reply_deptname) {
		this.reply_deptname = reply_deptname;
	}

	public String getReply_content() {
		return reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Complain_reply [reply_id=" + reply_id + ", complain_id=" + complain_id + ", replyer_id=" + replyer_id
				+ ", replyer_deptid=" + replyer_deptid + ", reply_time=" + reply_time + ", replyer_name=" + replyer_name
				+ ", reply_deptname=" + reply_deptname + ", reply_content=" + reply_content + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((complain_id == null) ? 0 : complain_id.hashCode());
		result = prime * result + ((reply_content == null) ? 0 : reply_content.hashCode());
		result = prime * result + ((reply_deptname == null) ? 0 : reply_deptname.hashCode());
		result = prime * result + ((reply_id == null) ? 0 : reply_id.hashCode());
		result = prime * result + ((reply_time == null) ? 0 : reply_time.hashCode());
		result = prime * result + ((replyer_deptid == null) ? 0 : replyer_deptid.hashCode());
		result = prime * result + ((replyer_id == null) ? 0 : replyer_id.hashCode());
		result = prime * result + ((replyer_name == null) ? 0 : replyer_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Complain_reply other = (Complain_reply) obj;
		if (complain_id == null) {
			if (other.complain_id != null)
				return false;
		} else if (!complain_id.equals(other.complain_id))
			return false;
		if (reply_content == null) {
			if (other.reply_content != null)
				return false;
		} else if (!reply_content.equals(other.reply_content))
			return false;
		if (reply_deptname == null) {
			if (other.reply_deptname != null)
				return false;
		} else if (!reply_deptname.equals(other.reply_deptname))
			return false;
		if (reply_id == null) {
			if (other.reply_id != null)
				return false;
		} else if (!reply_id.equals(other.reply_id))
			return false;
		if (reply_time == null) {
			if (other.reply_time != null)
				return false;
		} else if (!reply_time.equals(other.reply_time))
			return false;
		if (replyer_deptid == null) {
			if (other.replyer_deptid != null)
				return false;
		} else if (!replyer_deptid.equals(other.replyer_deptid))
			return false;
		if (replyer_id == null) {
			if (other.replyer_id != null)
				return false;
		} else if (!replyer_id.equals(other.replyer_id))
			return false;
		if (replyer_name == null) {
			if (other.replyer_name != null)
				return false;
		} else if (!replyer_name.equals(other.replyer_name))
			return false;
		return true;
	}

	public Complain_reply(Integer reply_id, Integer complain_id, Integer replyer_id, Integer replyer_deptid,
			Date reply_time, String replyer_name, String reply_deptname, String reply_content) {
		super();
		this.reply_id = reply_id;
		this.complain_id = complain_id;
		this.replyer_id = replyer_id;
		this.replyer_deptid = replyer_deptid;
		this.reply_time = reply_time;
		this.replyer_name = replyer_name;
		this.reply_deptname = reply_deptname;
		this.reply_content = reply_content;
	}

}