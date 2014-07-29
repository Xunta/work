package com.xunta.android.base;

import com.xunta.android.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


public abstract class BaseFragment extends Fragment{

	/** �Ƿ�ִ����OnAttach */
	private boolean isExceOnAttach = false;
	/** �Ƿ�����ҳ���� */
	private boolean isHidePage = false;
	/** �Ƿ�����չʾҳ�� */
	public boolean isShowingPage = true;
	
	/** ҳ����ת���ݵĲ��� */
	private Bundle bundle;
	/** ����view */
	public View baseMainView;
	/** ����title���� */
	public RelativeLayout topFragmentLayout;
	/** �ײ��˵����� */
	public RelativeLayout contentFramentLayout;
	
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		isExceOnAttach = true;
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		baseMainView = inflater.inflate(R.layout.fragment_base, container,false);
		findBaseViewById();
		/** ��ʼ��ҳ��ؼ��� */
		initPageView();
		initPageViewListener();
		return baseMainView;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		process(savedInstanceState);
	}
	
	public void findBaseViewById(){
		topFragmentLayout = (RelativeLayout)baseMainView.findViewById(R.id.topLayout);
		contentFramentLayout = (RelativeLayout)baseMainView.findViewById(R.id.contentLayout);
		View topView = loadTopLayout();
		if (topView == null) {
			topFragmentLayout.setVisibility(View.GONE);
		} else {
			RelativeLayout.LayoutParams layoutParamsTop = new RelativeLayout.LayoutParams(
					RelativeLayout.LayoutParams.FILL_PARENT,
					RelativeLayout.LayoutParams.WRAP_CONTENT);
			topFragmentLayout.setVisibility(View.VISIBLE);
			topFragmentLayout.addView(topView, layoutParamsTop);
		}
		View contentView = loadContentLayout();
		if (contentView == null) {
			contentFramentLayout.setVisibility(View.GONE);
		} else {
			RelativeLayout.LayoutParams layoutParamsContent = new RelativeLayout.LayoutParams(
					RelativeLayout.LayoutParams.FILL_PARENT,
					RelativeLayout.LayoutParams.FILL_PARENT);
			contentFramentLayout.setVisibility(View.VISIBLE);
			contentFramentLayout.addView(contentView, layoutParamsContent);
		}
		
	}
	
	@Override
	public void onHiddenChanged(boolean hidden) {
		super.onHiddenChanged(hidden);
		isHidePage = hidden;
		isShowingPage = !hidden;
		if (!hidden) {
			
		} else {
			
		}
	}


	@Override
	public void onPause() {
		super.onPause();
		isExceOnAttach = false;
		isShowingPage = false;
	}


	@Override
	public void onResume() {
		super.onResume();
		if (!isExceOnAttach && !isHidePage) {
			// ���ǵ�һ�ν�������û�����أ���Ҫˢ��ҳ�����ʵ�ִ˷���
			isShowingPage = true;
			
		}
	}


	/**
	 * ҳ����ת���ݵĲ���
	 * 
	 * @param bundle
	 */
	public void setBundle(Bundle bundle) {
		this.bundle = bundle;
	}

	/**
	 * ��ȡҳ�洫�ݵĲ���
	 * 
	 * @return
	 */
	public Bundle getBundle() {
		return bundle;
	}
	
	/** ���󷽷� ���������ʵ�֣���ʼ��ҳ��ؼ��� */
	protected abstract void initPageView();

	/** ���󷽷� ���������ʵ�֣�ҳ��ؼ�����¼����� */
	protected abstract void initPageViewListener();

	/**
	 * ��ȡ��������
	 */
	protected abstract View loadTopLayout();

	/**
	 * ��ȡ���ݲ���
	 */
	protected abstract View loadContentLayout();

	/** ���󷽷� ���������ʵ�֣��߼����� */
	protected abstract void process(Bundle savedInstanceState);
	
}
