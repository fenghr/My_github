package com.soft863.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2668496671202665703L;
	private Integer id;
	private String name;
	private String dept;
	private String account;
	private String password;
	private String headimg;
	private boolean gender;
	private String email;
	private String mobile;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	private String state;
	private String memo;
	
	private String validateCode;
	
    
  private List<Integer> ids;

  

	public List<Integer> getIds() {
	return ids;
}

public void setIds(List<Integer> ids) {
	this.ids = ids;
}

	public User(Integer id) {
		super();
		this.id = id;
	}

	public User(Integer id, String name, String dept, String account, String password, String headimg, boolean gender,
			String email, String mobile, Date birthday, String state, String memo, String validateCode) {
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.account = account;
		this.password = password;
		this.headimg = headimg;
		this.gender = gender;
		this.email = email;
		this.mobile = mobile;
		this.birthday = birthday;
		this.state = state;
		this.memo = memo;
		this.validateCode = validateCode;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public User() {
	}

	public Integer getId() {
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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHeadimg() {
		return headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

	public boolean getGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dept=" + dept + ", account=" + account + ", password="
				+ password + ", headimg=" + headimg + ", gender=" + gender + ", email=" + email + ", mobile=" + mobile
				+ ", birthday=" + birthday + ", state=" + state + ", memo=" + memo + ", validateCode=" + validateCode
				+ ", ids=" + ids + "]";
	}




	


	

}
