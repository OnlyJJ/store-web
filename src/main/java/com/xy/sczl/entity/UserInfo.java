/**
 * 
 */
package com.xy.sczl.entity;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.List;

public class UserInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 数据序号
	 */
	private Integer id;

	/**
	 * 账号
	 */
	private String account;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 账户余额
	 */
	private Long balance;

	/**
	 * 积分值
	 */
	private Long point;

	/**
	 * 手机号码
	 */
	private String phone;

	/**
	 * 座机电话
	 */
	private String telPhone;

	/**
	 * 地址
	 */
	private String address;

	/**
	 * 邮编
	 */
	private String zipCode;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 密码信息(加密)
	 */
	private String password;

	/**
	 * 收货地址
	 */
	private List<UserAddress> addresses; // 关联收货地址

	/**
	 * 订单
	 */
	private List<Order> orders;// 订单

	/**
	 * 密码加密盐
	 */
    private String slat;

	public UserInfo() {
	};

	/**
	 * @param id
	 * @param username
	 * @param password
	 */
	public UserInfo(Integer id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Long getPoint() {
		return point;
	}

	public void setPoint(Long point) {
		this.point = point;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTelPhone() {
		return telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<UserAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<UserAddress> addresses) {
		this.addresses = addresses;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public String getSlat() {
        return slat;
    }

    public void setSlat(String slat) {
        this.slat = slat;
    }
}
