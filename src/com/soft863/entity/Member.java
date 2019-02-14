package com.soft863.entity;

import java.io.Serializable;

/**
 * 用户实体类
 * 
 * @author j0305_lingyh
 *
 */
public class Member implements Serializable {
	
	private static final long serialVersionUID = 8040365059153491246L;
	private Integer id;
	private String username;// 用户名
	private String truename;// 真实姓名
	private String password;// 密码
	private String city;// 城市
	private String address;// 地址
	private Integer postcode;// 邮政编码
	private String cardno;// 证件号码
	private String cardtype;// 证件类型
	private String tel;// 电话
	private String email;// 电子邮箱
	private String freeze;// 冻结

	public Member() {
	}
	
	

	public String getCardno() {
		return cardno;
	}



	public void setCardno(String cardno) {
		this.cardno = cardno;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	// 用户注册
	public Member(String username, String truename, String password, String city, String address,
			Integer postcode, String cardno, String cardtype, String tel, String email) {
		this.username = username;
		this.truename = truename;
		this.password = password;
		this.city = city;
		this.address = address;
		this.postcode = postcode;
		this.cardno = cardno;
		this.cardtype = cardtype;
		this.tel = tel;
		this.email = email;
	}

	// 用户冻结会员修改
	public Member(String username, String truename, String password, String city, String address,
			Integer postcode, String cardno, String cardtype, String tel, String email, char freeze) {
		this.username = username;
		this.truename = truename;
		this.password = password;
		this.city = city;
		this.address = address;
		this.postcode = postcode;
		this.cardno = cardno;
		this.cardtype = cardtype;
		this.tel = tel;
		this.email = email;
	}

	// 用户登录
	public Member(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Integer setId(int id) {
		return id;
	}

	public Integer getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPostcode() {
		return postcode;
	}

	public void setPostcode(Integer postcode) {
		this.postcode = postcode;
	}

//	public String getcardno() {
//		return cardno;
//	}
//
//	public void setcardno(String cardno) {
//		this.cardno = cardno;
//	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFreeze() {
		return freeze;
	}

	public void setFreeze(String freeze) {
		this.freeze = freeze;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", username=" + username + ", truename=" + truename + ", password=" + password
				+ ", city=" + city + ", address=" + address + ", postcode=" + postcode + ", cardno=" + cardno
				+ ", cardtype=" + cardtype + ", tel=" + tel + ", email=" + email + ", freeze=" + freeze + "]";
	}

}
