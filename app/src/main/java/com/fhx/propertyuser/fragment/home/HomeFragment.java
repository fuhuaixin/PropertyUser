package com.fhx.propertyuser.fragment.home;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.activity.BuildingInformActivity;
import com.fhx.propertyuser.activity.ComplainListActivity;
import com.fhx.propertyuser.activity.ContactsActivity;
import com.fhx.propertyuser.activity.InformListActivity;
import com.fhx.propertyuser.activity.InviteListActivity;
import com.fhx.propertyuser.activity.RechargeListActivity;
import com.fhx.propertyuser.activity.RepairListActivity;
import com.fhx.propertyuser.activity.VisitorInviteActivity;
import com.fhx.propertyuser.activity.WebActivity;
import com.fhx.propertyuser.activity.mine.OrderListActivity;
import com.fhx.propertyuser.adapter.BuildInformAdapter;
import com.fhx.propertyuser.adapter.HomeCenterAdapter;
import com.fhx.propertyuser.adapter.HomeInformAdapter;
import com.fhx.propertyuser.base.BaseFragment;
import com.fhx.propertyuser.bean.HomeCenterBean;
import com.fhx.propertyuser.bean.HomeInformBean;
import com.fhx.propertyuser.utils.CutToUtils;
import com.to.aboomy.banner.Banner;
import com.to.aboomy.banner.HolderCreator;
import com.to.aboomy.banner.IndicatorView;
import com.to.aboomy.banner.ScaleInTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener{
    private TextView tv_home;
    private Banner home_banner;
    private RecyclerView recycle_center,recycle_inform;
    private LinearLayout ll_inform_list;
    private List<Integer> bannerList =new ArrayList<>();

    private HomeCenterAdapter centerAdapter;
    private List<HomeCenterBean> centerBeanList = new ArrayList<>();

    private HomeInformAdapter informAdapter;
    private List<HomeInformBean> informBeanList = new ArrayList<>();

    @Override
    public int setLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void findViewById(View view) {
        super.findViewById(view);
        home_banner =view.findViewById(R.id.home_banner);
        recycle_center = view.findViewById(R.id.recycle_center);
        recycle_inform = view.findViewById(R.id.recycle_inform);
        ll_inform_list = view.findViewById(R.id.ll_inform_list);

    }

    @Override
    public void setViewData(View view) {
        super.setViewData(view);

        setBanner();
        centerBeanList.clear();
        centerBeanList.add(new HomeCenterBean("维护报修",R.mipmap.icon_home_repairs,0));
        centerBeanList.add(new HomeCenterBean("访客邀约",R.mipmap.icon_home_invite,0));
        centerBeanList.add(new HomeCenterBean("账单服务",R.mipmap.icon_home_order,1));
        centerBeanList.add(new HomeCenterBean("楼宇资讯",R.mipmap.icon_home_message,0));
        centerBeanList.add(new HomeCenterBean("物业团队",R.mipmap.icon_home_team,0));
        centerBeanList.add(new HomeCenterBean("邀约列表",R.mipmap.icon_home_invite_list,0));
        centerBeanList.add(new HomeCenterBean("投诉建议",R.mipmap.icon_home_suggest,0));
        centerBeanList.add(new HomeCenterBean("预充值",R.mipmap.icon_home_charge,0));
        centerAdapter =new HomeCenterAdapter(centerBeanList);
        recycle_center.setLayoutManager(new GridLayoutManager(getContext(),4));
        recycle_center.setAdapter(centerAdapter);

        informBeanList.clear();
        informBeanList.add(new HomeInformBean("通知","这是通知标题哈哈哈1111","8.19","这是详情XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX这是详情XXXXX"));
        informBeanList.add(new HomeInformBean("公告","这是公告标题哈哈哈1111","7.19","X这是详情XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX这是详情XX"));
        informBeanList.add(new HomeInformBean("通知","这是通知标题哈哈哈2222","7.9","XXXXXX这是详情XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX这是详情XX"));
        informBeanList.add(new HomeInformBean("公告","这是公告标题哈哈哈2222","7.1","XXX这是详情XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX这是详情XXX"));
        informAdapter =new HomeInformAdapter(informBeanList);
        recycle_inform.setLayoutManager(new LinearLayoutManager(getContext()));
        recycle_inform.setAdapter(informAdapter);

    }

    @Override
    public void setClickEvent(View view) {
        super.setClickEvent(view);

        ll_inform_list.setOnClickListener(this);

        centerAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (centerBeanList.get(position).getTitle()){
                    case "维护报修":
                        CutToUtils.getInstance().JumpTo(getActivity(), RepairListActivity.class);
                        break;
                    case "预充值":
                        CutToUtils.getInstance().JumpTo(getActivity(),RechargeListActivity.class);
                        break;
                    case "邀约列表":
                        CutToUtils.getInstance().JumpTo(getActivity(), InviteListActivity.class);
                        break;
                    case "访客邀约":
                        CutToUtils.getInstance().JumpTo(getActivity(), VisitorInviteActivity.class);
                        break;
                    case "账单服务":
                        CutToUtils.getInstance().JumpTo(getActivity(), OrderListActivity.class);
                        break;
                    case "楼宇资讯":
                        CutToUtils.getInstance().JumpTo(getActivity(), BuildingInformActivity.class);
                        break;
                    case "投诉建议":
                        CutToUtils.getInstance().JumpTo(getActivity(), ComplainListActivity.class);
                        break;
                    case "物业团队":
                        CutToUtils.getInstance().JumpTo(getActivity(), ContactsActivity.class);
                        break;
                }
            }
        });

        informAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                CutToUtils.getInstance().JumpToTwo(getActivity(), WebActivity.class,"通知公告","https://www.baidu.com/");
            }
        });
    }

    /**
     * 设置banner 以及点击事件
     */
    private void  setBanner(){
        bannerList.add(R.mipmap.image_banner);
        bannerList.add(R.mipmap.image_banner);
        IndicatorView indicatorView = new IndicatorView(getContext())
                .setIndicatorColor(Color.parseColor("#dad6ff"))
                .setIndicatorSelectorColor(Color.parseColor("#Ffffff"))
                .setIndicatorRatio(1f)
                .setIndicatorSpacing(3f)
                .setIndicatorSelectedRatio(2f);
        home_banner.setIndicator(indicatorView)
                .setAutoPlay(true)
                .setAutoTurningTime(2000)
                .setHolderCreator(new HolderCreator() {
                    @Override
                    public View createView(Context context, final int index, Object o) {
                        ImageView iv = new ImageView(context);
                        iv.setScaleType(ImageView.ScaleType.FIT_XY);
                        Glide.with(context).load(o).into(iv);
                        iv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getContext(), "点击了"+index, Toast.LENGTH_SHORT).show();
                            }
                        });
                        return iv;
                    }
                })
                .setPageTransformer(true,new ScaleInTransformer())
                .setRoundCorners(10f)
                .setPages(bannerList);

        /**
         * banner自动轮播监听
         */
        home_banner.setOuterPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                Log.e("fhxx","轮播到了"+position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_inform_list:
                CutToUtils.getInstance().JumpTo(getActivity(),InformListActivity.class);
                break;
        }
    }
}
