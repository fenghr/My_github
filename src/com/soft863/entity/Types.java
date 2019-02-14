package com.soft863.entity;

import java.io.Serializable;

/**
 * 信息类型表
 * 
 * @author fenghr
 *
 */
public class Types implements Serializable {
	private static final long serialVersionUID = 5964858161253290810L;
	private Integer id;
	private String tname;

	public Types() {
	}

	public Types(Integer id, String tname) {
		super();
		this.id = id;
		this.tname = tname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	@Override
	public String toString() {
		return "Types [id=" + id + ", tname=" + tname + "]";
	}

}
