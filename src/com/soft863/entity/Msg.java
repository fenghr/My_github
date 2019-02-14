package com.soft863.entity;

import java.io.Serializable;

public class Msg implements Serializable {

	private static final long serialVersionUID = -1748444647860756592L;
	private String name;

	public Msg() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Msg [name=" + name + "]";
	}

}
