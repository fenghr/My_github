package com.soft863.entity;

/**
 * 投诉页面的模糊查询 标题,投诉时间,状态
 * 
 * @author Administrator
 *
 */
public class FuzzyQuery extends PageSplit {
	private String comp_Searchtitle;
	private String comp_SearchstarTime;
	private String comp_SearchendTime;
	private String Searchstate;


	@Override
	public String toString() {
		return "FuzzyQuery [comp_Searchtitle=" + comp_Searchtitle + ", comp_SearchstarTime=" + comp_SearchstarTime
				+ ", comp_SearchendTime=" + comp_SearchendTime + ", Searchstate=" + Searchstate + "]";
	}

	public FuzzyQuery(String comp_Searchtitle, String comp_SearchstarTime, String comp_SearchendTime,
			String searchstate) {
		super();
		this.comp_Searchtitle = comp_Searchtitle;
		this.comp_SearchstarTime = comp_SearchstarTime;
		this.comp_SearchendTime = comp_SearchendTime;
		Searchstate = searchstate;
	}

	public FuzzyQuery() {
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

}
