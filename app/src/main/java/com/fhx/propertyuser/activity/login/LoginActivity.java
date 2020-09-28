package com.fhx.propertyuser.activity.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.fhx.propertyuser.MainActivity;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.utils.CutToUtils;
import com.fhx.propertyuser.utils.DateAndTimeDialog;

/**
 * 登录页面
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout ll_user, ll_password;
    private ImageView image_user, image_password, image_user_del, image_password_del;
    private TextView tv_forget, tv_register, tv_code_login, tv_login;
    private EditText edit_password, edit_user;

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        ll_user = (LinearLayout) findViewById(R.id.ll_user);
        ll_password = (LinearLayout) findViewById(R.id.ll_password);
        image_user = (ImageView) findViewById(R.id.image_user);
        image_password = (ImageView) findViewById(R.id.image_password);
        image_user_del = (ImageView) findViewById(R.id.image_user_del);
        image_password_del = (ImageView) findViewById(R.id.image_password_del);
        tv_login = (TextView) findViewById(R.id.tv_login);
        tv_forget = (TextView) findViewById(R.id.tv_forget);
        tv_register = (TextView) findViewById(R.id.tv_register);
        tv_code_login = (TextView) findViewById(R.id.tv_code_login);
        edit_user = (EditText) findViewById(R.id.edit_user);
        edit_password = (EditText) findViewById(R.id.edit_password);
    }

    @Override
    protected void initData() {
        image_user_del.setOnClickListener(this);
        image_password_del.setOnClickListener(this);
        tv_login.setOnClickListener(this);
        tv_code_login.setOnClickListener(this);
        tv_register.setOnClickListener(this);
        tv_forget.setOnClickListener(this);
    }

    @Override
    protected void initListen() {
        edit_user.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    ll_user.setBackgroundResource(R.drawable.shape_user_sel_bg);
                    ll_password.setBackgroundResource(R.drawable.shape_user_unsel_bg);
                    image_user.setImageResource(R.mipmap.icon_little_phone_sel);
                    image_password.setImageResource(R.mipmap.icon_little_password_unsel);
                }
            }
        });
        edit_password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    ll_user.setBackgroundResource(R.drawable.shape_user_unsel_bg);
                    ll_password.setBackgroundResource(R.drawable.shape_user_sel_bg);
                    image_user.setImageResource(R.mipmap.icon_little_phone_unsel);
                    image_password.setImageResource(R.mipmap.icon_little_password_sel);
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
        edit_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    image_password_del.setVisibility(View.VISIBLE);
                } else {
                    image_password_del.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_login:
//                DateAndTimeDialog dateAndTimeDialog = new DateAndTimeDialog();
//                dateAndTimeDialog.show(getSupportFragmentManager(),"date");

                finish();
                CutToUtils.getInstance().JumpTo(LoginActivity.this, MainActivity.class);
                break;
            case R.id.image_user_del:
                edit_user.setText("");
                break;
            case R.id.image_password_del:
                edit_password.setText("");
                break;
            case R.id.tv_code_login:
                CutToUtils.getInstance().JumpToOne(LoginActivity.this, RegisterActivity.class, "codeLogin");
                break;
            case R.id.tv_register:
                CutToUtils.getInstance().JumpToOne(LoginActivity.this, RegisterActivity.class, "register");
                break;
            case R.id.tv_forget:
                CutToUtils.getInstance().JumpToOne(LoginActivity.this, SettingPasswordActivity.class, "找回密码");

                break;
        }
    }
}
