package com.fhx.propertyuser.fragment.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fhx.propertyuser.R;
import com.fhx.propertyuser.activity.mine.CarManageActivity;
import com.fhx.propertyuser.activity.mine.ChangePasswordActivity;
import com.fhx.propertyuser.activity.mine.MineInformationActivity;
import com.fhx.propertyuser.activity.mine.OrderListActivity;
import com.fhx.propertyuser.activity.mine.PersonalAttestationActivity;
import com.fhx.propertyuser.base.BaseFragment;
import com.fhx.propertyuser.utils.CutToUtils;

/**
 * 我的
 */
public class MineFragment extends BaseFragment implements View.OnClickListener{
    private ImageView imageBack;
    private TextView tvTitle;
    private RelativeLayout rl_mine_information;
    private LinearLayout ll_change_password,ll_grrz,ll_car_manage,ll_order_list;

    @Override
    public int setLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void findViewById(View view) {
        super.findViewById(view);
        imageBack =view.findViewById(R.id.image_back);
        tvTitle =view.findViewById(R.id.tv_title);
        rl_mine_information =view.findViewById(R.id.rl_mine_information);
        ll_change_password =view.findViewById(R.id.ll_change_password);
        ll_grrz =view.findViewById(R.id.ll_grrz);
        ll_car_manage =view.findViewById(R.id.ll_car_manage);
        ll_order_list =view.findViewById(R.id.ll_order_list);

    }

    @Override
    public void setViewData(View view) {
        super.setViewData(view);
        imageBack.setVisibility(View.GONE);
        tvTitle.setText("我的");
    }

    @Override
    public void setClickEvent(View view) {
        super.setClickEvent(view);
        rl_mine_information.setOnClickListener(this);
        ll_change_password.setOnClickListener(this);
        ll_grrz.setOnClickListener(this);
        ll_car_manage.setOnClickListener(this);
        ll_order_list.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_mine_information://个人信息编辑
                CutToUtils.getInstance().JumpTo(getActivity(), MineInformationActivity.class);
                break;
            case R.id.ll_change_password://修改密码
                CutToUtils.getInstance().JumpTo(getActivity(), ChangePasswordActivity.class);
                break;
            case R.id.ll_grrz://个人认证
                CutToUtils.getInstance().JumpTo(getActivity(), PersonalAttestationActivity.class);
                break;
            case R.id.ll_car_manage://车辆管理
                CutToUtils.getInstance().JumpTo(getActivity(), CarManageActivity.class);
                break;
            case R.id.ll_order_list://账单服务
                CutToUtils.getInstance().JumpTo(getActivity(), OrderListActivity.class);
                break;
        }
    }
}
