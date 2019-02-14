package com.soft863.entity;

/**
 * 投诉页面的模糊查询 标题,投诉时间,状态
 * 
 * @author Administrator
 *
 */
public class RoleSplit {
	private String comp_Searchtitle;
	private String comp_SearchstarTime;
	private String comp_SearchendTime;
	private String Searchstate;

	private int start;// 开始页数
	private int end;// 结束页数
	private int p_size = 5;// 每页条数
	private int currpage;// 当前页数
	private int totalpage;// 总页数
	private int totalcnt;// 总条数

	public RoleSplit(int currpage, int totalcnt) {
		this.currpage = currpage;
		this.totalcnt = totalcnt;
		// 总页数
		this.totalpage = totalcnt % p_size == 0 ? totalcnt / p_size : totalcnt / p_size + 1;
		this.start = (currpage - 1) * p_size;
		this.end = p_size;
	}

	public RoleSplit(int totalcnt) {
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

	public String getComp_Searchtitle() {
		return comp_Searchtitle;
	}

	public void setComp_Searchtitle(String comp_Searchtitle) {
		this.comp_Searchtitle = comp_Searchtitle;
	}

	public String getComp_SearchstarTime() {
		return comp_SearchstarTime;
	}

	public void setComp_SearchstarTime(String comp_SearchstarTime) {
		this.comp_SearchstarTime = comp_SearchstarTime;
	}

	public String getComp_SearchendTime() {
		return comp_SearchendTime;
	}

	public void setComp_SearchendTime(String comp_SearchendTime) {
		this.comp_SearchendTime = comp_SearchendTime;
	}

	public String getSearchstate() {
		return Searchstate;
	}

	public void setSearchstate(String searchstate) {
		Searchstate = searchstate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Searchstate == null) ? 0 : Searchstate.hashCode());
		result = prime * result + ((comp_SearchendTime == null) ? 0 : comp_SearchendTime.hashCode());
		result = prime * result + ((comp_SearchstarTime == null) ? 0 : comp_SearchstarTime.hashCode());
		result = prime * result + ((comp_Searchtitle == null) ? 0 : comp_Searchtitle.hashCode());
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
		RoleSplit other = (RoleSplit) obj;
		if (Searchstate == null) {
			if (other.Searchstate != null)
				return false;
		} else if (!Searchstate.equals(other.Searchstate))
			return false;
		if (comp_SearchendTime == null) {
			if (other.comp_SearchendTime != null)
				return false;
		} else if (!comp_SearchendTime.equals(other.comp_SearchendTime))
			return false;
		if (comp_SearchstarTime == null) {
			if (other.comp_SearchstarTime != null)
				return false;
		} else if (!comp_SearchstarTime.equals(other.comp_SearchstarTime))
			return false;
		if (comp_Searchtitle == null) {
			if (other.comp_Searchtitle != null)
				return false;
		} else if (!comp_Searchtitle.equals(other.comp_Searchtitle))
			return false;
		return true;
	}

	public RoleSplit() {
		super();
	}

	public RoleSplit(String comp_Searchtitle, String comp_SearchstarTime, String comp_SearchendTime,
			String searchstate) {
		super();
		this.comp_Searchtitle = comp_Searchtitle;
		this.comp_SearchstarTime = comp_SearchstarTime;
		this.comp_SearchendTime = comp_SearchendTime;
		Searchstate = searchstate;
	}

	@Override
	public String toString() {
		return "FuzzyQuery [comp_Searchtitle=" + comp_Searchtitle + ", comp_SearchstarTime=" + comp_SearchstarTime
				+ ", comp_SearchendTime=" + comp_SearchendTime + ", Searchstate=" + Searchstate + "]";
	}

}
