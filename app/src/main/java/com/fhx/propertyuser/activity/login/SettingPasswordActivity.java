package com.fhx.propertyuser.activity.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fhx.propertyuser.R;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.utils.CutToUtils;

/**
 * 设置密码 找回密码  重新设置密码
 */
public class SettingPasswordActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv_code_title, tv_number, tv_get_code;
    private ImageView image_user, imageBack, image_user_del;
    private EditText edit_user;
    private LinearLayout ll_user;

    private String type;

    @Override
    protected int initLayout() {
        return R.layout.activity_setting_password;
    }



    @Override
    protected void initView() {
        tv_code_title = (TextView) findViewById(R.id.tv_code_title);
        tv_number = (TextView) findViewById(R.id.tv_number);
        tv_get_code = (TextView) findViewById(R.id.tv_get_code);
        image_user = (ImageView) findViewById(R.id.image_user);
        imageBack = (ImageView) findViewById(R.id.image_back);
        image_user_del = (ImageView) findViewById(R.id.image_user_del);
        edit_user = (EditText) findViewById(R.id.edit_user);
        ll_user = (LinearLayout) findViewById(R.id.ll_user);

    }

    @Override
    protected void initData() {
        type = getIntent().getStringExtra("jumpOne");
        Log.e("fhxx",type+"---"+type.equals("找回密码")+"----"+type.equals("login")+"----------"+type.equals("find"));
        if (type.equals("找回密码")){
            tv_code_title.setText("找回密码");
            tv_number.setText("为了保障您的账户安全，1天只能操作1次，否则账户将会被锁定无法登录");
            tv_get_code.setText("下一步");
            image_user.setImageResource(R.mipmap.icon_little_phone_unsel);
            edit_user.setHint("请输入手机号码");
        }else if (type.equals("login")){
            tv_code_title.setText("请设置密码");
            tv_number.setText("8-20个字符，不可是纯数字");
            tv_get_code.setText("完成");
            edit_user.setHint("请输入密码");
            image_user.setImageResource(R.mipmap.icon_little_password_unsel);
        }else if (type.equals("find")){
            tv_code_title.setText("请设置新密码");
            tv_number.setText("8-20个字符，不可是纯数字");
            tv_get_code.setText("完成");
            edit_user.setHint("请输入密码");
            image_user.setImageResource(R.mipmap.icon_little_password_unsel);
        }

    }

    @Override
    protected void initListen() {
        tv_get_code.setOnClickListener(this);
        image_user_del.setOnClickListener(this);
        imageBack.setOnClickListener(this);

        edit_user.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                switch (type) {
                    case "找回密码":
                        if (hasFocus) {
                            ll_user.setBackgroundResource(R.drawable.shape_user_sel_bg);
                            image_user.setImageResource(R.mipmap.icon_little_phone_sel);
                        } else {
                            ll_user.setBackgroundResource(R.drawable.shape_password_unsel);
                            image_user.setImageResource(R.mipmap.icon_little_phone_unsel);
                        }
                        break;
                    case "login":
                    case "find":
                        if (hasFocus) {
                            ll_user.setBackgroundResource(R.drawable.shape_user_sel_bg);
                            image_user.setImageResource(R.mipmap.icon_little_password_sel);
                        } else {
                            ll_user.setBackgroundResource(R.drawable.shape_password_unsel);
                            image_user.setImageResource(R.mipmap.icon_little_password_unsel);
                        }
                        break;
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
            case R.id.tv_get_code:
                switch (type) {
                    case "找回密码":
                        CutToUtils.getInstance().JumpToTwo(SettingPasswordActivity.this, VerificationCodeActivity.class, edit_user.getText().toString(), "find");

                        break;
                    case "login":
                    case "find":
                        CutToUtils.getInstance().JumpTo(SettingPasswordActivity.this,LoginActivity.class);
                        break;
                }
                break;
            case R.id.image_user_del:
                edit_user.setText("");
                break;
            case R.id.image_back:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
        }
    }
}
