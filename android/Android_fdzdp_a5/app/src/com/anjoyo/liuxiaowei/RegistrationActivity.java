package com.anjoyo.liuxiaowei;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
/**
 * ×¢²áÄ£¿é
 * */
public class RegistrationActivity extends Activity {

	private ImageView mRegistration_back;
	private EditText mRegistration_user, mRegistration_name,
			mRegistration_password, mRegistration_password2;
	private TextView mRegistration_OK;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_registration);
		initView();
	}

	private void initView() {
		mRegistration_back = (ImageView) findViewById(R.id.Registration_back);
		mRegistration_user = (EditText) findViewById(R.id.Registration_user);
		mRegistration_name = (EditText) findViewById(R.id.Registration_name);
		mRegistration_password = (EditText) findViewById(R.id.Registration_password);
		mRegistration_password2 = (EditText) findViewById(R.id.Registration_password2);
		mRegistration_OK = (TextView) findViewById(R.id.Registration_OK);
		MyOnClickLietener myonclick = new MyOnClickLietener();
		mRegistration_back.setOnClickListener(myonclick);
		mRegistration_OK.setOnClickListener(myonclick);
	}

	private class MyOnClickLietener implements View.OnClickListener {
		public void onClick(View arg0) {
			int mID = arg0.getId();
			if (mID == R.id.Registration_back) {
				RegistrationActivity.this.finish();
			}
			if (mID == R.id.Registration_OK) {
				Toast.makeText(RegistrationActivity.this, "×¢²á°´Å¥±»µ¥»÷", 1).show();
			}
		}
	}
}
