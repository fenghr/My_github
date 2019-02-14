package com.soft863.entity;

import java.io.Serializable;

/**
 * 权限表
 * @author Administrator
 *
 */
public class Code implements Serializable{

	private static final long serialVersionUID = 6514475241099621866L;
	private Integer id; //权限ID
	private String code;//权限内容

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Code [id=" + id + ", code=" + code + "]";
	}
	
}
