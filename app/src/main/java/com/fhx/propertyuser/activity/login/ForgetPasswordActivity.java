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
 * 忘记密码
 */
public class ForgetPasswordActivity extends BaseActivity implements View.OnClickListener {

    private TextView tvTitle;
    private ImageView imageLeft;
    private EditText edit_user;
    private TextView tv_get_code;
    private LinearLayout ll_user;
    private ImageView image_user,image_user_del;
    @Override
    protected int initLayout() {
        return R.layout.activity_forget_password;
    }

    @Override
    protected void initView() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_get_code = (TextView) findViewById(R.id.tv_get_code);
        imageLeft = (ImageView) findViewById(R.id.image_back);
        ll_user = (LinearLayout) findViewById(R.id.ll_user);
        image_user = (ImageView) findViewById(R.id.image_user);
        image_user_del = (ImageView) findViewById(R.id.image_user_del);
        edit_user = (EditText) findViewById(R.id.edit_user);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);
        image_user_del.setOnClickListener(this);
        tv_get_code.setOnClickListener(this);

        edit_user.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    ll_user.setBackgroundResource(R.drawable.shape_user_sel_bg);
                    image_user.setImageResource(R.mipmap.icon_little_password_sel);
                } else {
                    ll_user.setBackgroundResource(R.drawable.shape_password_unsel);
                    image_user.setImageResource(R.mipmap.icon_little_password_unsel);
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
        switch (v.getId()){
            case R.id.image_back:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
            case R.id.image_user_del:
                edit_user.setText("");
                break;

            case R.id.tv_get_code:
                mmkv.encode("RNumber",edit_user.getText().toString());
                CutToUtils.getInstance().JumpToOne(ForgetPasswordActivity.this,VerificationCodeActivity.class,"forget");//,edit_user.getText().toString()

                break;
        }
    }
}
