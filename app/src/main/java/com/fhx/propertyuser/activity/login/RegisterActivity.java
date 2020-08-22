package com.fhx.propertyuser.activity.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fhx.propertyuser.R;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.utils.CutToUtils;

/**
 * 注册页面
 */
public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout ll_user;
    private ImageView image_user, image_user_del;
    private EditText edit_user;
    private TextView tv_get_code, tv_to_password, tv_title, tv_tip;

    private String type;

    @Override
    protected int initLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        ll_user = (LinearLayout) findViewById(R.id.ll_user);
        image_user = (ImageView) findViewById(R.id.image_user);
        image_user_del = (ImageView) findViewById(R.id.image_user_del);
        edit_user = (EditText) findViewById(R.id.edit_user);
        tv_get_code = (TextView) findViewById(R.id.tv_get_code);
        tv_to_password = (TextView) findViewById(R.id.tv_to_password);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_tip = (TextView) findViewById(R.id.tv_tip);
    }

    @Override
    protected void initData() {
        type = getIntent().getStringExtra("jumpOne");
        switch (type) {
            case "codeLogin":
                tv_title.setText("验证码登录");
                tv_tip.setVisibility(View.GONE);
                break;
            case "register":
                tv_title.setText("注册");
                tv_tip.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    protected void initListen() {

        image_user_del.setOnClickListener(this);
        tv_to_password.setOnClickListener(this);
        tv_get_code.setOnClickListener(this);

        edit_user.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    ll_user.setBackgroundResource(R.drawable.shape_user_sel_bg);
                    image_user.setImageResource(R.mipmap.icon_little_phone_sel);
                } else {
                    ll_user.setBackgroundResource(R.drawable.shape_user_unsel_bg);
                    image_user.setImageResource(R.mipmap.icon_little_phone_unsel);
                }
            }
        });

        edit_user.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    image_user_del.setVisibility(View.VISIBLE);
                } else {
                    image_user_del.setVisibility(View.GONE);

                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_user_del:
                edit_user.setText("");
                break;
            case R.id.tv_get_code: //获取验证码
                CutToUtils.getInstance().JumpToTwo(RegisterActivity.this,VerificationCodeActivity.class,edit_user.getText().toString(),"login");
                break;
            case R.id.tv_to_password://密码登录
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
        }
    }
}
