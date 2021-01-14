package com.fhx.propertyuser.fragment.home;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.FileUtils;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.activity.BuildingInformActivity;
import com.fhx.propertyuser.activity.ComplainListActivity;
import com.fhx.propertyuser.activity.ContactsActivity;
import com.fhx.propertyuser.activity.InformListActivity;
import com.fhx.propertyuser.activity.InviteListActivity;
import com.fhx.propertyuser.activity.NotificationActivity;
import com.fhx.propertyuser.activity.RechargeListActivity;
import com.fhx.propertyuser.activity.RepairListActivity;
import com.fhx.propertyuser.activity.VisitorInviteActivity;
import com.fhx.propertyuser.activity.WebActivity;
import com.fhx.propertyuser.activity.mine.OrderListActivity;
import com.fhx.propertyuser.activity.mine.PersonalAttestationActivity;
import com.fhx.propertyuser.adapter.HomeCenterAdapter;
import com.fhx.propertyuser.adapter.HomeInformAdapter;
import com.fhx.propertyuser.base.AppUrl;
import com.fhx.propertyuser.base.BaseFragment;
import com.fhx.propertyuser.bean.AuditResultBean;
import com.fhx.propertyuser.bean.HomeCenterBean;
import com.fhx.propertyuser.bean.NewsListBean;
import com.fhx.propertyuser.bean.NotificationListBean;
import com.fhx.propertyuser.utils.CommonDialog;
import com.fhx.propertyuser.utils.CutToUtils;
import com.fhx.propertyuser.utils.NotificationUtil;
import com.fhx.propertyuser.utils.UpdatePhotoAlbumUtil;
import com.to.aboomy.banner.Banner;
import com.to.aboomy.banner.HolderCreator;
import com.to.aboomy.banner.IndicatorView;
import com.to.aboomy.banner.ScaleInTransformer;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.DownloadProgressCallBack;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;


/**
 * 首页
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener {
    private TextView tv_home, tv_inform;
    private Banner home_banner;
    private RecyclerView recycle_center, recycle_inform;
    private LinearLayout ll_inform_list;
    private List<Integer> bannerList = new ArrayList<>();

    private HomeCenterAdapter centerAdapter;
    private List<HomeCenterBean> centerBeanList = new ArrayList<>();

    private HomeInformAdapter informAdapter;
    private List<NewsListBean.DataBean.RecordsBean> informBeanList = new ArrayList<>();

    @Override
    public int setLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void findViewById(View view) {
        super.findViewById(view);
        home_banner = view.findViewById(R.id.home_banner);
        recycle_center = view.findViewById(R.id.recycle_center);
        recycle_inform = view.findViewById(R.id.recycle_inform);
        ll_inform_list = view.findViewById(R.id.ll_inform_list);
        tv_inform = view.findViewById(R.id.tv_inform);

    }

    @Override
    public void onResume() {
        super.onResume();
        //获取认证状态
        getResult();
        //通知栏权限
        if (!NotificationManagerCompat.from(getContext()).areNotificationsEnabled()) {
            notifiDialog.show();
        } else {
            notifiDialog.dismiss();
        }
    }

    @Override
    public void setViewData(View view) {
        super.setViewData(view);
        showNotification();

        setBanner();
        centerBeanList.clear();
        centerBeanList.add(new HomeCenterBean("维护报修", R.mipmap.icon_home_repairs, 0));
        centerBeanList.add(new HomeCenterBean("访客邀约", R.mipmap.icon_home_invite, 0));
        centerBeanList.add(new HomeCenterBean("账单服务", R.mipmap.icon_home_order, 1));
        centerBeanList.add(new HomeCenterBean("楼宇资讯", R.mipmap.icon_home_message, 0));
        centerBeanList.add(new HomeCenterBean("物业团队", R.mipmap.icon_home_team, 0));
        centerBeanList.add(new HomeCenterBean("邀约列表", R.mipmap.icon_home_invite_list, 0));
        centerBeanList.add(new HomeCenterBean("投诉建议", R.mipmap.icon_home_suggest, 0));
        centerBeanList.add(new HomeCenterBean("预充值", R.mipmap.icon_home_charge, 0));
        centerAdapter = new HomeCenterAdapter(centerBeanList);
        recycle_center.setLayoutManager(new GridLayoutManager(getContext(), 4));
        recycle_center.setAdapter(centerAdapter);

        informAdapter = new HomeInformAdapter(informBeanList);
        recycle_inform.setLayoutManager(new LinearLayoutManager(getContext()));
        recycle_inform.setAdapter(informAdapter);

        UserAnnounce();//首页通知公告获取
        MessageList();//首页获取推送通知一条
    }

    @Override
    public void setClickEvent(View view) {
        super.setClickEvent(view);

        ll_inform_list.setOnClickListener(this);
        tv_inform.setOnClickListener(this);

        centerAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (centerBeanList.get(position).getTitle()) {
                    case "维护报修":
                        CutToUtils.getInstance().JumpTo(getActivity(), RepairListActivity.class);
                        break;
                    case "预充值":
                        CutToUtils.getInstance().JumpTo(getActivity(), RechargeListActivity.class);
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
                CutToUtils.getInstance().JumpToTwo(getActivity(), WebActivity.class, "通知公告", AppUrl.NEWSTITLEURL+informBeanList.get(position).getNewsId());
            }
        });
    }

    /**
     * 设置banner 以及点击事件
     */
    private void setBanner() {
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
                                Toast.makeText(getContext(), "点击了" + index, Toast.LENGTH_SHORT).show();
                            }
                        });
                        return iv;
                    }
                })
                .setPageTransformer(true, new ScaleInTransformer())
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
        switch (v.getId()) {
            case R.id.ll_inform_list:
                CutToUtils.getInstance().JumpTo(getActivity(), InformListActivity.class);
                break;
            case R.id.tv_inform:

                CutToUtils.getInstance().JumpTo(getActivity(), NotificationActivity.class);

                break;
        }
    }


    /**
     * 获取认证状态接口
     */
    private void getResult() {
        EasyHttp.get(AppUrl.AuditResult)
                .params("phone", mmkv.decodeString("userPhone"))
                .syncRequest(false)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        AuditResultBean auditResultBean = JSON.parseObject(s, AuditResultBean.class);
                        if (auditResultBean.isSuccess()) {
                            if (auditResultBean.getData() != null) {
                                switch (auditResultBean.getData().getResult()) {  //[0忽略1通过2否决3未审核]
                                    case "1":
                                        if (commonDialog != null && commonDialog.isShowing()) {
                                            commonDialog.dismiss();
                                        }
                                        break;
                                    case "2":
                                        showAuthDialog("审核未通过，请认真填写后重新提交。");
                                        break;
                                    case "3":
                                        showAuthDialog("审核中，请耐心等待");
                                        break;
                                }
                            } else {
                                showAuthDialog("为了您更好的体验，请先进行个人认证。");
                            }

                        } else {
                            Toast.makeText(mActivity, auditResultBean.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    /**
     * 获取首页的通知公告
     * 首页展示五条
     */
    private void UserAnnounce() {
        EasyHttp.get(AppUrl.NewsList)
                .params("pageNum", "1")
                .params("pageSize", "5")
                .params("target", "userAnnounce")
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        NewsListBean newsListBean = JSON.parseObject(s, NewsListBean.class);
                        if (newsListBean.isSuccess()) {
                            informBeanList.clear();
                            informBeanList.addAll(newsListBean.getData().getRecords());
                            informAdapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(mActivity, newsListBean.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    /**
     * 获取推送 通知 列表
     * 首页展示一条
     */
    private void MessageList(){
        EasyHttp.get(AppUrl.MessageList)
                .params("pageNum", "1")
                .params("pageSize","1")
//                .params("accepter",mmkv.decodeString("userPhone"))
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error",e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {

                        NotificationListBean notificationListBean = JSON.parseObject(s, NotificationListBean.class);
                        if (notificationListBean.isSuccess()){
                            if (notificationListBean.getData()!=null){
                                tv_inform.setText(notificationListBean.getData().getRecords().get(0).getMessageContent());
                            }
                        }else {
                            Toast.makeText(mActivity, notificationListBean.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    /**
     * 判断是否个人认证提示弹窗，没有就去认证 0是未认证  1是已认证
     */
    CommonDialog commonDialog;

    private void showAuthDialog(String message) {
        commonDialog = new CommonDialog(getContext());
        commonDialog.setCanceledOnTouchOutside(false);
        commonDialog.setCancelable(false);
        commonDialog.setImageResId(-1)
                .setTitle("系统提示")
                .setSingle(true)
                .setMessage(message)
                .setOnClickBottomListener(new CommonDialog.OnClickBottomListener() {
                    @Override
                    public void onPositiveClick() {
                        Intent intent = new Intent(getActivity(), PersonalAttestationActivity.class);
                        intent.putExtra("ifAudit", "0");
                        getActivity().startActivity(intent);
                        getActivity().overridePendingTransition(R.anim.activity_in_from_anim, R.anim.activity_in_to_anim);
                    }

                    @Override
                    public void onNegtiveClick() {

                    }
                }).show();

    }

    /**
     * 开启通知提示弹窗
     */
    CommonDialog notifiDialog;

    private void showNotification() {
        notifiDialog = new CommonDialog(getContext());
        notifiDialog.setImageResId(-1)
                .setTitle("系统提示")
                .setSingle(false)
                .setMessage("为了您更好的体验，请允许打开通知，谢谢配合。")
                .setOnClickBottomListener(new CommonDialog.OnClickBottomListener() {
                    @Override
                    public void onPositiveClick() {
                        NotificationUtil notificationUtil = new NotificationUtil();
                        notificationUtil.goToNotificationSetting(getContext());
                    }

                    @Override
                    public void onNegtiveClick() {
                        notifiDialog.dismiss();
                    }
                });
    }
}
