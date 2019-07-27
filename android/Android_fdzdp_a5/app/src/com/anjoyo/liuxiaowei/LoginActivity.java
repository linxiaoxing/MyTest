package com.anjoyo.liuxiaowei;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 登录模块
 * </BR> </BR> By：苦涩 </BR> 联系作者：QQ 534429149
 * */

public class LoginActivity extends Activity {

	private ImageView mLogin_back;
	private EditText mLogin_user, mLogin_password;
	private TextView mLogin_OK, mLogin_wangjimima, mLogin_zhuce;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);
		initView();
	}

	private void initView() {
		mLogin_back = (ImageView) findViewById(R.id.Login_back);
		mLogin_user = (EditText) findViewById(R.id.Login_user);
		mLogin_password = (EditText) findViewById(R.id.Login_password);
		mLogin_OK = (TextView) findViewById(R.id.Login_OK);
		mLogin_wangjimima = (TextView) findViewById(R.id.Login_wangjimima);
		mLogin_zhuce = (TextView) findViewById(R.id.Login_zhuce);
		MyOnClickLietener myonclick = new MyOnClickLietener();
		mLogin_back.setOnClickListener(myonclick);
		mLogin_OK.setOnClickListener(myonclick);
		mLogin_wangjimima.setOnClickListener(myonclick);
		mLogin_zhuce.setOnClickListener(myonclick);
	}

	private class MyOnClickLietener implements View.OnClickListener {
		public void onClick(View arg0) {
			int mID = arg0.getId();
			if (mID == R.id.Login_back) {
				LoginActivity.this.finish();
			}
			if (mID == R.id.Login_OK) {
				Toast.makeText(LoginActivity.this, "登录按钮被单击", 1).show();
			}
			if (mID == R.id.Login_wangjimima) {
				Toast.makeText(LoginActivity.this, "忘记密码被单击", 1).show();
			}
			if (mID == R.id.Login_zhuce) {
				Intent intent = new Intent(LoginActivity.this,
						RegistrationActivity.class);
				startActivity(intent);
			}
		}
	}
}
