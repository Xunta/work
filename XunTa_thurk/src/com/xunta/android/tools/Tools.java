package com.xunta.android.tools; 


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

}
 