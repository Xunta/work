package com.xunta.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import cn.bmob.push.BmobPush;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.listener.SaveListener;

import com.xunta.android.R;
import com.xunta.android.base.BaseActivity;
import com.xunta.android.bean.XuntaData;
import com.xunta.android.common.Constent;
import com.xunta.android.common.LoginState;

/**
 * @Title: WelComeActivity.java
 * @Package com.seekta.android.activity
 * @Description: TODO(��ӭҳ)
 * @author zhangchao
 * @date 2014��7��23�� ����10:41:58
 */
public class WelComeActivity extends BaseActivity {

	private ImageView imageView;

	Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if (LoginState.isLogin(WelComeActivity.this)) {
				// �ѵ�¼
				startActivity(new Intent(WelComeActivity.this,
						IndexActivity.class));
				finish();
			} else {
				// δ��¼
				startActivity(new Intent(WelComeActivity.this,
						LoginActivity.class));
				finish();
			}
		}

	};

	@Override
	protected void process(Bundle savedInstanceState) {

		// ��ʼ��bmob
		Bmob.initialize(this, Constent.ApplicationID);
		BmobPush.startWork(this, Constent.ApplicationID);
		// ҳ����ͣ3�����ת
		pause();
	}

	@Override
	protected void initPageView() {
		imageView = (ImageView) findViewById(R.id.imageView);
	}

	@Override
	protected void initPageViewListener() {

	}

	@Override
	protected int loadContentLayout() {
		return R.layout.activity_welcome;
	}

	/**
	 * ��ͣ3����
	 * */
	public void pause() {
		handler.sendEmptyMessageDelayed(1, 3000);
	}

}
