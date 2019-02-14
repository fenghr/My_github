package com.soft863.entity;

import java.io.Serializable;

/**
 * 投诉信息
 * 
 * @author Administrator
 *
 */
public class Complain implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1165993656601697133L;
	private Integer id;
	private Integer comp_id;
	private String comp_deptname;
	private String comp_deptid;
	private String comop_name;
	private String comp_mobile;
	private String comp_time;
	private Integer is_NM;
	private String comp_title;
	private Integer to_comp_id;
	private String to_comp_name;
	private String to_comp_deptname;
	private Integer to_comp_deptid;
	private String to_comp_content;
	private String state;
	private Complain_reply cr;

	@Override
	public String toString() {
		return "Complain [id=" + id + ", comp_id=" + comp_id + ", comp_deptname=" + comp_deptname + ", comp_deptid="
				+ comp_deptid + ", comop_name=" + comop_name + ", comp_mobile=" + comp_mobile + ", comp_time="
				+ comp_time + ", is_NM=" + is_NM + ", comp_title=" + comp_title + ", to_comp_id=" + to_comp_id
				+ ", to_comp_name=" + to_comp_name + ", to_comp_deptname=" + to_comp_deptname + ", to_comp_deptid="
				+ to_comp_deptid + ", to_comp_content=" + to_comp_content + ", state=" + state + ", cr=" + cr + "]";
	}

	public Complain() {
		super();
	}

	public Complain(Integer id, Integer comp_id, String comp_deptname, String comp_deptid, String comop_name,
			String comp_mobile, String comp_time, Integer is_NM, String comp_title, Integer to_comp_id,
			String to_comp_name, String to_comp_deptname, Integer to_comp_deptid, String to_comp_content, String state,
			Complain_reply cr) {
		super();
		this.id = id;
		this.comp_id = comp_id;
		this.comp_deptname = comp_deptname;
		this.comp_deptid = comp_deptid;
		this.comop_name = comop_name;
		this.comp_mobile = comp_mobile;
		this.comp_time = comp_time;
		this.is_NM = is_NM;
		this.comp_title = comp_title;
		this.to_comp_id = to_comp_id;
		this.to_comp_name = to_comp_name;
		this.to_comp_deptname = to_comp_deptname;
		this.to_comp_deptid = to_comp_deptid;
		this.to_comp_content = to_comp_content;
		this.state = state;
		this.cr = cr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comop_name == null) ? 0 : comop_name.hashCode());
		result = prime * result + ((comp_deptid == null) ? 0 : comp_deptid.hashCode());
		result = prime * result + ((comp_deptname == null) ? 0 : comp_deptname.hashCode());
		result = prime * result + ((comp_id == null) ? 0 : comp_id.hashCode());
		result = prime * result + ((comp_mobile == null) ? 0 : comp_mobile.hashCode());
		result = prime * result + ((comp_time == null) ? 0 : comp_time.hashCode());
		result = prime * result + ((comp_title == null) ? 0 : comp_title.hashCode());
		result = prime * result + ((cr == null) ? 0 : cr.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((is_NM == null) ? 0 : is_NM.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((to_comp_content == null) ? 0 : to_comp_content.hashCode());
		result = prime * result + ((to_comp_deptid == null) ? 0 : to_comp_deptid.hashCode());
		result = prime * result + ((to_comp_deptname == null) ? 0 : to_comp_deptname.hashCode());
		result = prime * result + ((to_comp_id == null) ? 0 : to_comp_id.hashCode());
		result = prime * result + ((to_comp_name == null) ? 0 : to_comp_name.hashCode());
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
		Complain other = (Complain) obj;
		if (comop_name == null) {
			if (other.comop_name != null)
				return false;
		} else if (!comop_name.equals(other.comop_name))
			return false;
		if (comp_deptid == null) {
			if (other.comp_deptid != null)
				return false;
		} else if (!comp_deptid.equals(other.comp_deptid))
			return false;
		if (comp_deptname == null) {
			if (other.comp_deptname != null)
				return false;
		} else if (!comp_deptname.equals(other.comp_deptname))
			return false;
		if (comp_id == null) {
			if (other.comp_id != null)
				return false;
		} else if (!comp_id.equals(other.comp_id))
			return false;
		if (comp_mobile == null) {
			if (other.comp_mobile != null)
				return false;
		} else if (!comp_mobile.equals(other.comp_mobile))
			return false;
		if (comp_time == null) {
			if (other.comp_time != null)
				return false;
		} else if (!comp_time.equals(other.comp_time))
			return false;
		if (comp_title == null) {
			if (other.comp_title != null)
				return false;
		} else if (!comp_title.equals(other.comp_title))
			return false;
		if (cr == null) {
			if (other.cr != null)
				return false;
		} else if (!cr.equals(other.cr))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (is_NM == null) {
			if (other.is_NM != null)
				return false;
		} else if (!is_NM.equals(other.is_NM))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (to_comp_content == null) {
			if (other.to_comp_content != null)
				return false;
		} else if (!to_comp_content.equals(other.to_comp_content))
			return false;
		if (to_comp_deptid == null) {
			if (other.to_comp_deptid != null)
				return false;
		} else if (!to_comp_deptid.equals(other.to_comp_deptid))
			return false;
		if (to_comp_deptname == null) {
			if (other.to_comp_deptname != null)
				return false;
		} else if (!to_comp_deptname.equals(other.to_comp_deptname))
			return false;
		if (to_comp_id == null) {
			if (other.to_comp_id != null)
				return false;
		} else if (!to_comp_id.equals(other.to_comp_id))
			return false;
		if (to_comp_name == null) {
			if (other.to_comp_name != null)
				return false;
		} else if (!to_comp_name.equals(other.to_comp_name))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getComp_id() {
		return comp_id;
	}

	public void setComp_id(Integer comp_id) {
		this.comp_id = comp_id;
	}

	public String getComp_deptname() {
		return comp_deptname;
	}

	public void setComp_deptname(String comp_deptname) {
		this.comp_deptname = comp_deptname;
	}

	public String getComp_deptid() {
		return comp_deptid;
	}

	public void setComp_deptid(String comp_deptid) {
		this.comp_deptid = comp_deptid;
	}

	public String getComop_name() {
		return comop_name;
	}

	public void setComop_name(String comop_name) {
		this.comop_name = comop_name;
	}

	public String getComp_mobile() {
		return comp_mobile;
	}

	public void setComp_mobile(String comp_mobile) {
		this.comp_mobile = comp_mobile;
	}

	public String getComp_time() {
		return comp_time;
	}

	public void setComp_time(String comp_time) {
		this.comp_time = comp_time;
	}

	public Integer getIs_NM() {
		return is_NM;
	}

	public void setIs_NM(Integer is_NM) {
		this.is_NM = is_NM;
	}

	public String getComp_title() {
		return comp_title;
	}

	public void setComp_title(String comp_title) {
		this.comp_title = comp_title;
	}

	public Integer getTo_comp_id() {
		return to_comp_id;
	}

	public void setTo_comp_id(Integer to_comp_id) {
		this.to_comp_id = to_comp_id;
	}

	public String getTo_comp_name() {
		return to_comp_name;
	}

	public void setTo_comp_name(String to_comp_name) {
		this.to_comp_name = to_comp_name;
	}

	public String getTo_comp_deptname() {
		return to_comp_deptname;
	}

	public void setTo_comp_deptname(String to_comp_deptname) {
		this.to_comp_deptname = to_comp_deptname;
	}

	public Integer getTo_comp_deptid() {
		return to_comp_deptid;
	}

	public void setTo_comp_deptid(Integer to_comp_deptid) {
		this.to_comp_deptid = to_comp_deptid;
	}

	public String getTo_comp_content() {
		return to_comp_content;
	}

	public void setTo_comp_content(String to_comp_content) {
		this.to_comp_content = to_comp_content;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Complain_reply getCr() {
		return cr;
	}

	public void setCr(Complain_reply cr) {
		this.cr = cr;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
