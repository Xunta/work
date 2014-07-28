package com.xunta.android.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

public abstract class BaseActivity extends FragmentActivity{

	/** ���󷽷� ���������ʵ�֣��߼����� */
	protected abstract void process(Bundle savedInstanceState);
	/** ���󷽷� ���������ʵ�֣���ʼ��ҳ��ؼ��� */
	protected abstract void initPageView();

	/** ���󷽷� ���������ʵ�֣�ҳ��ؼ�����¼����� */
	protected abstract void initPageViewListener();
	
	/**
	 * ��ȡ���ݲ���
	 */
	protected abstract int loadContentLayout();
	
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(loadContentLayout());
		initPageView();
		initPageViewListener();
		process(arg0);
	}
	
	/**
	 * toast��ʾ
	 * */
	public void showToast(String content){
		Toast.makeText(this, content, 1000).show();
	}
	
}
