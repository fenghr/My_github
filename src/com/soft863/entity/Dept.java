package com.soft863.entity;

public class Dept {
	
	private Integer id;
	private String deptname;

	public Dept() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	@Override
	public String toString() {
		return "Dept [id=" + id + ", deptname=" + deptname + "]";
	}

}
