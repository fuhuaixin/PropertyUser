package com.fhx.propertyuser.fragment.home;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.activity.login.LoginActivity;
import com.fhx.propertyuser.activity.mine.CarManageActivity;
import com.fhx.propertyuser.activity.mine.ChangePasswordActivity;
import com.fhx.propertyuser.activity.mine.MineInformationActivity;
import com.fhx.propertyuser.activity.mine.OrderListActivity;
import com.fhx.propertyuser.activity.mine.PersonalAttestationActivity;
import com.fhx.propertyuser.base.AppUrl;
import com.fhx.propertyuser.base.BaseFragment;
import com.fhx.propertyuser.bean.AuditListBean;
import com.fhx.propertyuser.utils.CommonDialog;
import com.fhx.propertyuser.utils.CutToUtils;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

/**
 * 我的
 */
public class MineFragment extends BaseFragment implements View.OnClickListener {
    private ImageView imageBack;
    private TextView tvTitle;
    private RelativeLayout rl_mine_information;
    private LinearLayout ll_change_password, ll_grrz, ll_car_manage, ll_order_list, ll_logout;
    private TextView tv_name, tv_phone;
    private int ifAudit = 0;

    @Override
    public int setLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void findViewById(View view) {
        super.findViewById(view);
        imageBack = view.findViewById(R.id.image_back);
        tvTitle = view.findViewById(R.id.tv_title);
        rl_mine_information = view.findViewById(R.id.rl_mine_information);
        ll_change_password = view.findViewById(R.id.ll_change_password);
        ll_grrz = view.findViewById(R.id.ll_grrz);
        ll_car_manage = view.findViewById(R.id.ll_car_manage);
        ll_order_list = view.findViewById(R.id.ll_order_list);
        ll_logout = view.findViewById(R.id.ll_logout);
        tv_name = view.findViewById(R.id.tv_name);
        tv_phone = view.findViewById(R.id.tv_phone);

    }

    @Override
    public void setViewData(View view) {
        super.setViewData(view);
        imageBack.setVisibility(View.GONE);
        tvTitle.setText("我的");
    }

    @Override
    public void onResume() {
        super.onResume();

        getInfo();
    }

    @Override
    public void setClickEvent(View view) {
        super.setClickEvent(view);
        rl_mine_information.setOnClickListener(this);
        ll_change_password.setOnClickListener(this);
        ll_grrz.setOnClickListener(this);
        ll_car_manage.setOnClickListener(this);
        ll_order_list.setOnClickListener(this);
        ll_logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_mine_information://个人信息编辑
                CutToUtils.getInstance().JumpTo(getActivity(), MineInformationActivity.class);
                break;
            case R.id.ll_change_password://修改密码
                CutToUtils.getInstance().JumpTo(getActivity(), ChangePasswordActivity.class);
                break;
            case R.id.ll_grrz://个人认证
                Intent intent = new Intent(getActivity(), PersonalAttestationActivity.class);
                intent.putExtra("ifAudit", ifAudit);
                getActivity().startActivity(intent);
                getActivity().overridePendingTransition(R.anim.activity_in_from_anim, R.anim.activity_in_to_anim);
//                CutToUtils.getInstance().JumpTo(getActivity(), PersonalAttestationActivity.class);
                break;
            case R.id.ll_car_manage://车辆管理
                CutToUtils.getInstance().JumpTo(getActivity(), CarManageActivity.class);
                break;
            case R.id.ll_order_list://账单服务
                CutToUtils.getInstance().JumpTo(getActivity(), OrderListActivity.class);
                break;
            case R.id.ll_logout://退出登录
                initDialog();
                break;
        }
    }

    /**
     * 请求个人信息
     */
    private void getInfo() {
        EasyHttp.get(AppUrl.AuditList)
                .syncRequest(false)
                .params("pageNum", "1")
                .params("pageSize", "1")
                .params("info", mmkv.decodeString("userPhone"))
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        AuditListBean bean = JSON.parseObject(s, AuditListBean.class);
                        if (bean.isSuccess()) {
                            if (bean.getData().getRecords() != null && bean.getData().getRecords().size() > 0) {
                                AuditListBean.DataBean.RecordsBean recordsBean = bean.getData().getRecords().get(0);
                                if (recordsBean.getResult().equals("3")) {
                                    tv_name.setText(mmkv.decodeString("userPhone"));
                                    tv_phone.setVisibility(View.GONE);
                                    ifAudit = 3;//审核中
                                } else if (recordsBean.getResult().equals("1")) {
                                    ifAudit = 1;//通过
                                    tv_name.setText(recordsBean.getName());
                                    tv_phone.setVisibility(View.VISIBLE);
                                    tv_phone.setText(recordsBean.getPhone());
                                } else if (recordsBean.getResult().equals("2")) {
                                    ifAudit = 2;//不通过
                                    tv_name.setText(mmkv.decodeString("userPhone"));
                                    tv_phone.setVisibility(View.GONE);
                                }
                            } else {
                                tv_name.setText(mmkv.decodeString("userPhone"));
                                tv_phone.setVisibility(View.GONE);
                                ifAudit = 0;
                            }
                        } else {
                            Toast.makeText(mActivity, bean.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    /**
     * 单双按钮弹窗
     */
    private void initDialog() {
        final CommonDialog dialog = new CommonDialog(getActivity());
        dialog.setMessage("确定退出登录么？")
                .setImageResId(-1)
                .setTitle("系统提示")
                .setSingle(false).setOnClickBottomListener(new CommonDialog.OnClickBottomListener() {
            @Override
            public void onPositiveClick() {
                dialog.dismiss();
                mmkv.removeValueForKey("token");
                mmkv.removeValueForKey("customerId");
                mmkv.removeValueForKey("userPhone");
                mmkv.removeValueForKey("password");
                CutToUtils.getInstance().JumpTo(getActivity(), LoginActivity.class);
                getActivity().finish();
            }

            @Override
            public void onNegtiveClick() {
                dialog.dismiss();
                Toast.makeText(getContext(), "取消", Toast.LENGTH_SHORT).show();
            }
        }).show();
    }
}
