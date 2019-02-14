package com.soft863.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页
 * 
 * @author fenghr
 *
 */
public class PageSplit {

	private int start;// 开始页数
	private int end;// 结束页数
	private int p_size = 3;// 每页条数
	private int currpage;// 当前页数
	private int totalpage;// 总页数
	private int totalcnt;// 总条数
	private List<?> list = new ArrayList<>();
	public PageSplit() {
	}

	/**
	 * 分页处理
	 * 
	 * @param currpage
	 * @param totalcnt
	 */
	public PageSplit(int currpage, int totalcnt) {
		this.currpage = currpage;
		this.totalcnt = totalcnt;
		// 总页数
		this.totalpage = totalcnt % p_size == 0 ? totalcnt / p_size : totalcnt / p_size + 1;
		this.start = (currpage - 1) * p_size;
		this.end =  p_size;
	}

	public PageSplit(int totalcnt) {
		this.totalpage = totalcnt % p_size == 0 ? totalcnt / p_size : totalcnt / p_size + 1;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getP_size() {
		return p_size;
	}

	public void setP_size(int p_size) {
		this.p_size = p_size;
	}

	public int getCurrpage() {
		return currpage;
	}

	public void setCurrpage(int currpage) {
		this.currpage = currpage;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getTotalcnt() {
		return totalcnt;
	}

	public void setTotalcnt(int totalcnt) {
		this.totalcnt = totalcnt;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "PageSplit [start=" + start + ", end=" + end + ", p_size=" + p_size + ", currpage=" + currpage
				+ ", totalpage=" + totalpage + ", totalcnt=" + totalcnt + ", list=" + list + "]";
	}

}
