package com.huizhi.box.activity;

import android.os.Bundle;
import android.view.Window;

import com.huizhi.box.api.RxBus;
import com.huizhi.box.api.util.RxHelper;
import com.huizhi.box.api.util.RxSubscriber;
import com.huizhi.box.data.Constant;
import com.huizhi.box.util.TLog;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends RxAppCompatActivity {

	Unbinder unbinder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(layoutView());
	    unbinder= ButterKnife.bind(this);
		initview();
		initData();
		initListener();
	}
	/**
	 *初始化监听
	 * @return
	 */
	public void initListener() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 数据的加载
	 * @return
	 */
	public void initData() {
		// TODO Auto-generated method stub
		RxBus.getInstance().register(Constant.EVENT_RXBUS_GOTO_LOGIN)
				.compose(new RxHelper<Object>(null).io_main2(this))
				.subscribe(new RxSubscriber<Object>() {
					@Override
					public void _onNext(Object response) {
						if(!(BaseActivity.this instanceof LoginActivity)){
							finish();
						}
					}

					@Override
					public void _onError(String msg) {
						TLog.log(msg);
					}
				});
	}
	/**
	 * 初始化数据
	 * @return
	 */
	public void initview() {
		// TODO Auto-generated method stub
	}

	/**
	 * 加载布局的方法
	 * @return
	 */
	public abstract int layoutView();
	@Subscribe(threadMode = ThreadMode.MAIN)
	/**
	public void onEventMainThread(PrintMsgEvent event) {
		if (event.type == PrinterMsgType.MESSAGE_TOAST) {
			ToastUtils.showToast(event.msg);
		}
	}
	 */
	@Override
	public void onDestroy() {
		super.onDestroy();
		unbinder.unbind();
	}
}
