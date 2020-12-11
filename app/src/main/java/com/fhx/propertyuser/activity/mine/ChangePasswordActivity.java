package com.fhx.propertyuser.activity.mine;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.fhx.propertyuser.MainActivity;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.base.AppUrl;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.bean.SuccessBean;
import com.fhx.propertyuser.utils.ActivityControl;
import com.fhx.propertyuser.utils.ResultTipDialog;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

/**
 * 个人中心 修改密码
 */
public class ChangePasswordActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageBack;
    private TextView tvTitle,tv_old_tip,tv_new_tip,tv_update;
    private EditText et_old,et_new,et_new_again;
    private ImageView image_old_choose,image_new_choose,image_new_again_choose;
    private ResultTipDialog resultTipDialog;

    @Override
    protected int initLayout() {
        return R.layout.activity_change_password;
    }

    @Override
    protected void initView() {
        imageBack = (ImageView) findViewById(R.id.image_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_update = (TextView) findViewById(R.id.tv_update);
        tv_new_tip = (TextView) findViewById(R.id.tv_new_tip);
        tv_old_tip = (TextView) findViewById(R.id.tv_old_tip);
        et_old = (EditText) findViewById(R.id.et_old);
        et_new = (EditText) findViewById(R.id.et_new);
        et_new_again = (EditText) findViewById(R.id.et_new_again);
        image_old_choose = (ImageView) findViewById(R.id.image_old_choose);
        image_new_choose = (ImageView) findViewById(R.id.image_new_choose);
        image_new_again_choose = (ImageView) findViewById(R.id.image_new_again_choose);
    }

    @Override
    protected void initData() {
        ActivityControl.getInstance().add(ChangePasswordActivity.this);

        tvTitle.setText("修改密码");
        resultTipDialog = new ResultTipDialog(this,"login");
    }

    @Override
    protected void initListen() {
        imageBack.setOnClickListener(this);
        tv_update.setOnClickListener(this);
        et_old.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    String s = et_old.getText().toString();
                    image_old_choose.setVisibility(View.VISIBLE);
                    if (s.length()>0&&s.equals(mmkv.decodeString("password"))){
                        tv_old_tip.setVisibility(View.GONE);
                        image_old_choose.setImageResource(R.mipmap.icon_edit_true);
                    }else {
                        tv_old_tip.setVisibility(View.VISIBLE);
                        image_old_choose.setImageResource(R.mipmap.icon_edit_error);
                    }
                }else {
                    tv_old_tip.setVisibility(View.GONE);
                    image_old_choose.setVisibility(View.GONE);
                }
            }
        });

        et_new_again.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    tv_new_tip.setVisibility(View.GONE);
                    image_new_again_choose.setVisibility(View.GONE);
                }else {
                    String s = et_new.getText().toString();
                    String s1 = et_new_again.getText().toString();
                    image_new_again_choose.setVisibility(View.VISIBLE);
                    if (s.equals(s1)){
                        tv_new_tip.setVisibility(View.GONE);
                        image_new_again_choose.setImageResource(R.mipmap.icon_edit_true);
                    }else {
                        tv_new_tip.setVisibility(View.VISIBLE);
                        image_new_again_choose.setImageResource(R.mipmap.icon_edit_error);
                    }
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
            case R.id.tv_update:
                if (!et_old.getText().toString().equals(mmkv.decodeString("password"))){
                    ToastShort("旧密码不正确");
                    return;
                }
                if (!et_new.getText().toString().equals(et_new_again.getText().toString())){
                    ToastShort("两次密码输入不一致");
                    return;
                }
                changePassWord();
                break;
        }
    }

    private void changePassWord(){
        EasyHttp.put(AppUrl.ChangePassWord)
                .params("peopleId",mmkv.decodeString("customerId"))
                .params("password",et_new_again.getText().toString())
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error",e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        SuccessBean successBean = JSON.parseObject(s, SuccessBean.class);
                        if (successBean.isSuccess()){
                            resultTipDialog
                                    .setTitle("密码修改成功")
                                    .setImageHeader(R.mipmap.icon_big_true)
                                    .setMsg("立即登录")
                                    .show();
                        }else {
                            ToastShort(successBean.getMsg());
                        }
                    }
                });
    }
}
