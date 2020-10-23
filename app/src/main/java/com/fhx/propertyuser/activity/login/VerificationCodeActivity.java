package com.fhx.propertyuser.activity.login;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dalimao.corelibrary.VerificationCodeInput;
import com.fhx.propertyuser.MainActivity;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.utils.CutToUtils;


/**
 * 输入验证码
 */
public class VerificationCodeActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageBack;
    private TextView tv_number, tv_time, tv_get_code;
    private VerificationCodeInput verification;


    private String number;
    private String type;

    @Override
    protected int initLayout() {
        return R.layout.activity_verification_code;
    }

    @Override
    protected void initView() {
        number = mmkv.decodeString("RNumber");
        type = getIntent().getStringExtra("jumpOne");
        tv_number = (TextView) findViewById(R.id.tv_number);
        tv_time = (TextView) findViewById(R.id.tv_time);
        tv_get_code = (TextView) findViewById(R.id.tv_get_code);
        imageBack = (ImageView) findViewById(R.id.image_back);
        verification = (VerificationCodeInput) findViewById(R.id.verificationCodeInput);
    }

    @Override
    protected void onResume() {
        super.onResume();
        for (int i = 0; i < verification.getChildCount(); i++) {//遍历子类
            verification.getChildAt(i).setEnabled(true);//设置可点击
            EditText childAt = (EditText) verification.getChildAt(i);
//            childAt.setText("");//清空内容
            if (i == 0) {//第一个获取焦点
                verification.getChildAt(i).requestFocus();
                verification.getChildAt(i).setFocusable(true);
                verification.getChildAt(i).setFocusableInTouchMode(true);
            }
        }
    }

    @Override
    protected void initData() {
        tv_number.setText("验证码已发送至 " + number);
        timer(5000);

    }

    @Override
    protected void initListen() {
        imageBack.setOnClickListener(this);
        tv_get_code.setOnClickListener(this);

        verification.setOnCompleteListener(new VerificationCodeInput.Listener() {
            @Override
            public void onComplete(String content) {
//                ToastShort(content);
                if (type.equals("codeLogin")) { //登录验证码
                    CutToUtils.getInstance().JumpTo(VerificationCodeActivity.this, MainActivity.class);
                    finish();
                }  if (type.equals("register")){//注册
                    mmkv.encode("code",content);

                    CutToUtils.getInstance().JumpToOne(VerificationCodeActivity.this, SettingPasswordActivity.class, "register");

                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_back:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
            case R.id.tv_get_code:
                timer(5000);
                tv_get_code.setVisibility(View.GONE);
                break;
        }
    }

    /**
     * 倒计时
     */

    private void timer(long time) {
        CountDownTimer countDownTimer = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tv_time.setText(millisUntilFinished / 1000 + "");
            }

            @Override
            public void onFinish() {
                tv_time.setText(0 + "");
                tv_get_code.setVisibility(View.VISIBLE);
//                ToastShort("完成");
            }
        };
        countDownTimer.start();
    }

    /**
     * 设置输入框完成后不可点击
     */

}
