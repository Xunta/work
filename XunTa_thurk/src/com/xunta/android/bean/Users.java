package com.xunta.android.bean;

import cn.bmob.v3.BmobObject;

/**
 * @Title: Users.java 
 * @Package com.xunta.android.bean
 * @Description: TODO(��һ�仰�������ļ���ʲô) 
 * @author zhangchao
 * @date 2014��8��3�� ����5:52:25 
 */
public class Users extends BmobObject{
	
	private String phoneNum;
	private String password;
	
	
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
