package com.soft863.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 等级表
 * 
 * @author Administrator
 *
 */

public class Role extends PageSplit implements Serializable {

	private static final long serialVersionUID = -5237842567912374163L;
	private Integer id;// 角色ID
	private String name;// 角色姓名
	private String state;// 角色状态 有效 无效
	
	private List<Integer> integers;
	
	private List<Code> lis;
	
	public List<Integer> getIntegers() {
		return integers;
	}

	public void setIntegers(List<Integer> integers) {
		this.integers = integers;
	}

	public List<Code> getLis() {
		return lis;
	}

	public Role(Integer id) {
		super();
		this.id = id;
	}

	public void setLis(List<Code> lis) {
		this.lis = lis;
	}

	public Role(String name) {
		this.name = name;
	}

	public Role(String name, String state) {
		super();
		this.name = name;
		this.state = state;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Role(Integer id, String name, String state) {
		this.id = id;
		this.name = name;
		this.state = state;
	}
	
	public Role() {
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", state=" + state + ", integers=" + integers + ", lis=" + lis
				+ "]";
	}
	
}
