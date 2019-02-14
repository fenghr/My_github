package com.soft863.entity;

import java.io.Serializable;

/**
 * 投诉统计饼状图 年 月 每月条数
 * 
 * @author Administrator
 *
 */
public class StatisticsChart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2151041885908411737L;
	private Integer id;
	private Integer year;
	private String month;
	private String complainCount;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((complainCount == null) ? 0 : complainCount.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		StatisticsChart other = (StatisticsChart) obj;
		if (complainCount == null) {
			if (other.complainCount != null)
				return false;
		} else if (!complainCount.equals(other.complainCount))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (month == null) {
			if (other.month != null)
				return false;
		} else if (!month.equals(other.month))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getComplainCount() {
		return complainCount;
	}

	public void setComplainCount(String complainCount) {
		this.complainCount = complainCount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "StatisticsChart [id=" + id + ", year=" + year + ", month=" + month + ", complainCount=" + complainCount
				+ "]";
	}

	public StatisticsChart() {
		super();
	}

	public StatisticsChart(Integer id, Integer year, String month, String complainCount) {
		super();
		this.id = id;
		this.year = year;
		this.month = month;
		this.complainCount = complainCount;
	}

}
