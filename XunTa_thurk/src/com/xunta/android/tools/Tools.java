package com.xunta.android.tools; 

import android.text.TextUtils;


/**   
 * @Title: Tools.java 
 * @Package com.seekta.android.tools 
 * @Description: TODO(������) 
 * @author zhangchao   
 * @date 2014��7��23�� ����10:27:01   
 */
public class Tools {
	
	/**
	 * �ж��ַ����Ƿ�Ϊ��
	 * �� ���� false
	 * ��Ϊ�� ���� true
	 * */
	public static boolean isNull(String content){
		if(null != content && !"".equals(content) && !"null".equals(content)){
			return true;
		}
		return false;
	}
	
	/**
	 * ��֤�ֻ���ʽ
	 */
	public static boolean isMobileNO(String mobiles) {
		/*
		�ܽ��������ǵ�һλ�ض�Ϊ1���ڶ�λ�ض�Ϊ2��9������λ�õĿ���Ϊ0-9
		*/
		//"[1]"�����1λΪ����1��"[3-9]"����ڶ�λ����Ϊ3-9�е�һ����"\\d{9}"��������ǿ�����0��9�����֣���9λ��
		String telRegex = "[1][3-9]\\d{9}";
		if (TextUtils.isEmpty(mobiles)){
			return false;
		}else{
			return mobiles.matches(telRegex);
		}
    }

}
 