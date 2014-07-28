package com.xunta.android.common; 

import android.app.Activity;
import android.content.SharedPreferences;

/**   
 * @Title: LoginState.java 
 * @Package com.seekta.android.common 
 * @Description: TODO(�洢��¼��Ϣ��) 
 * @author zhangchao   
 * @date 2014��7��26�� ����12:56:41   
 */
public class LoginState {

	public static final String USER_STATE = "user_state";
	public static final String USERID = "userId";
	public static final String USERNAME = "userName";
	public static final String PHOTOURL = "photoUrl";
	
	public static boolean isLogin(Activity activity){
		SharedPreferences sp = activity.getSharedPreferences(USER_STATE, 0);
		String str = sp.getString(USERID, "");
		if("".equals(str)){
			return false;
		}else{
			return true;
		}
		
	}
	
	/**�����û�ͷ��*/
	public static void setPhotoUrl(Activity activity,String str){
		SharedPreferences sp = activity.getSharedPreferences(USER_STATE, 0);
		sp.edit().putString(PHOTOURL, str).commit();
	}
	
	/**��ȡ�û�ͷ��*/
	public static String getPhotoUrl(Activity activity){
		SharedPreferences sp = activity.getSharedPreferences(USER_STATE, 0);
		return sp.getString(PHOTOURL, "");
	}
	
	/**�����û���*/
	public static void setUserName(Activity activity,String str){
		SharedPreferences sp = activity.getSharedPreferences(USER_STATE, 0);
		sp.edit().putString(USERNAME, str).commit();
	}
	
	/**��ȡ�û���*/
	public static String getUserName(Activity activity){
		SharedPreferences sp = activity.getSharedPreferences(USER_STATE, 0);
		return sp.getString(USERNAME, "");
	}
	
	/**����userid*/
	public static void setUserId(Activity activity,String str){
		SharedPreferences sp = activity.getSharedPreferences(USER_STATE, 0);
		sp.edit().putString(USERID, str).commit();
	}

	/**��ȡuserid*/
	public static String getUserId(Activity activity){
		SharedPreferences sp = activity.getSharedPreferences(USER_STATE, 0);
		return sp.getString(USERID, "");
	}
	
}
 