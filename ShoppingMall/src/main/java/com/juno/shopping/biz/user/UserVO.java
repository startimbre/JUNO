package com.juno.shopping.biz.user;

import java.util.Date;

public class UserVO {
	private String id;
	private String password;
	private String name;
	private Date birthday;
	private String gender;
	private String email;
	private int postalCode;
	private String mobile;
	private String address1;
	private String address2;
	private String address3;
	private Date regesterDate;
	private int point;
	private String gradeCode;
	private int totalPurchase;
	private int totalPoint;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public Date getRegesterDate() {
		return regesterDate;
	}
	public void setRegesterDate(Date regesterDate) {
		this.regesterDate = regesterDate;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getGradeCode() {
		return gradeCode;
	}
	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}
	public int getTotalPurchase() {
		return totalPurchase;
	}
	public void setTotalPurchase(int totalPurchase) {
		this.totalPurchase = totalPurchase;
	}
	public int getTotalPoint() {
		return totalPoint;
	}
	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", name=" + name + ", birthday=" + birthday + ", gender="
				+ gender + ", email=" + email + ", postalCode=" + postalCode + ", mobile=" + mobile + ", address1="
				+ address1 + ", address2=" + address2 + ", address3=" + address3 + ", regesterDate=" + regesterDate
				+ ", point=" + point + ", gradeCode=" + gradeCode + ", totalPurchase=" + totalPurchase + ", totalPoint="
				+ totalPoint + "]";
	}
}
