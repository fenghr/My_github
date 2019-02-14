package com.soft863.entity;

import java.util.List;

public class ListCode {
	
	List<Code> goodslist;

	public List<Code> getGoodslist() {
		return goodslist;
	}

	public void setGoodslist(List<Code> goodslist) {
		this.goodslist = goodslist;
	}

	@Override
	public String toString() {
		return "ListCode [goodslist=" + goodslist + "]";
	}
	

}
