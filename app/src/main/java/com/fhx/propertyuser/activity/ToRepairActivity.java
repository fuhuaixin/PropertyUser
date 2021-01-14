package com.fhx.propertyuser.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.propertyuser.R;
import com.fhx.propertyuser.adapter.ImageChooseAdapter;
import com.fhx.propertyuser.base.AppUrl;
import com.fhx.propertyuser.base.BaseActivity;
import com.fhx.propertyuser.bean.RepairTypeListBean;
import com.fhx.propertyuser.bean.SuccessBean;
import com.fhx.propertyuser.bean.UpLoadImageBean;
import com.fhx.propertyuser.utils.ListDialog;
import com.scrat.app.selectorlibrary.ImageSelector;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.body.UIProgressResponseCallBack;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.request.PostRequest;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

/**
 * 我要报修
 */
public class ToRepairActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageBack;
    private TextView tvTitle;
    private LinearLayout ll_event_type, ll_reserveTime;
    private TextView tv_eventType, tv_reserveTime, tv_toPay;
    private ListDialog listDialog;
    private EditText et_user_number, et_user_name, et_content, et_notes;
    private RecyclerView recycle_image;

    private List<String> mEventTypeList = new ArrayList<>();
    private List<String> mEventTypeIdList = new ArrayList<>();
    private Calendar c;//获取当前时间
    private String eventTypeId;
    private ImageChooseAdapter imageChooseAdapter;
    private List<String> mImageList = new ArrayList<>(); //上传图列表
    private ListDialog chooseImageDialog; //相机 和选择图片弹窗
    private List<String> chooseImageList = new ArrayList<>(); //相机和选择图片list
    private List<String> UpImageList = new ArrayList<>(); //压缩上传图片列表

    private static final int REQUEST_CODE_SELECT_IMG = 1;
    private static final int REQUEST_CAMERA = 2;
    private static final int MAX_SELECT_COUNT = 3;


    @Override
    protected int initLayout() {
        return R.layout.activity_ro_repair;
    }

    @Override
    protected void initView() {
        imageBack = (ImageView) findViewById(R.id.image_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_eventType = (TextView) findViewById(R.id.tv_eventType);
        tv_reserveTime = (TextView) findViewById(R.id.tv_reserveTime);
        tv_toPay = (TextView) findViewById(R.id.tv_toPay);
        ll_event_type = (LinearLayout) findViewById(R.id.ll_event_type);
        ll_reserveTime = (LinearLayout) findViewById(R.id.ll_reserveTime);
        et_user_number = (EditText) findViewById(R.id.et_user_number);
        et_user_name = (EditText) findViewById(R.id.et_user_name);
        et_content = (EditText) findViewById(R.id.et_content);
        et_notes = (EditText) findViewById(R.id.et_notes);
        recycle_image = (RecyclerView) findViewById(R.id.recycle_image);

    }

    @Override
    protected void initData() {
        c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        tvTitle.setText("我要报修");


        getEventType();
//        mImageList.add(new ImageChooseBean(""));
//        mImageList.add("https://pic2.zhimg.com/80/v2-e110c4ec6cbc6b51f1bac346d4d85ab1_720w.jpg?source=1940ef5c");
//        mImageList.add("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1607051127&di=f92c2a09c2c59fd1babe4b08d33db909&src=http://guaihaha.com/upload/article/201610/23/162019580c72c3cee44SlMgRP.jpg");
        recycle_image.setLayoutManager(new GridLayoutManager(this, 3));
        imageChooseAdapter = new ImageChooseAdapter(this, mImageList);
        recycle_image.setAdapter(imageChooseAdapter);


        chooseImageList.add("相机");
        chooseImageList.add("图片选择");
        chooseImageDialog = new ListDialog(ToRepairActivity.this, chooseImageList, new ListDialog.LeaveMyDialogListener() {
            @Override
            public void onClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 0:
                        useCamera();
                        break;
                    case 1:
                        ImageSelector.show(ToRepairActivity.this, REQUEST_CODE_SELECT_IMG, MAX_SELECT_COUNT - mImageList.size());
                        break;
                }
                chooseImageDialog.dismiss();
            }
        });
    }

    @Override
    protected void initListen() {
        imageBack.setOnClickListener(this);
        ll_event_type.setOnClickListener(this);
        ll_reserveTime.setOnClickListener(this);
        tv_toPay.setOnClickListener(this);
        imageChooseAdapter.setClickListener(new ImageChooseAdapter.OnItemClickListener() {

            @Override
            public void onAdd(View view, int position) {
                chooseImageDialog.show();
            }

            @Override
            public void onDel(View view, int position) {
//                ToastShort("点击了del" + position);
                mImageList.remove(position);
                UpImageList.remove(position);
                chooseSize();
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
            case R.id.ll_event_type:
                listDialog = new ListDialog(this, mEventTypeList, new ListDialog.LeaveMyDialogListener() {
                    @Override
                    public void onClick(BaseQuickAdapter adapter, View view, int position) {
                        tv_eventType.setText(mEventTypeList.get(position));
                        eventTypeId = mEventTypeIdList.get(position);
                        listDialog.dismiss();
                    }
                });
                listDialog.show();
                break;
            case R.id.ll_reserveTime:
                int year = c.get(Calendar.YEAR);
                int mouth = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                new DatePickerDialog(ToRepairActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                String mMonth = null;
                                String day = null;
                                if (month < 9) {
                                    mMonth = "0" + (month + 1);
                                } else {
                                    mMonth = String.valueOf((month + 1));
                                }
                                if (dayOfMonth < 10) {
                                    day = "0" + dayOfMonth;
                                } else {
                                    day = String.valueOf(dayOfMonth);
                                }
                                tv_reserveTime.setText(year + "-" + mMonth + "-" + day);
                            }
                        }, year, mouth, day).show();
                break;
            case R.id.tv_toPay:
                if (et_user_name.getText().toString().equals("")) {
                    ToastShort("请输入报修人姓名");
                    return;
                }
                if (et_user_number.getText().toString().equals("")) {
                    ToastShort("请输入报修人电话");
                    return;
                }
                if (tv_eventType.getText().toString().equals("请输入")) {
                    ToastShort("请选择事件类型");
                    return;
                }
                if (et_notes.getText().toString().equals("")) {
                    ToastShort("请选择事件地址");
                    return;
                }
                if (et_content.getText().toString().equals("")) {
                    ToastShort("请输入问题描述");
                    return;
                }
                if (tv_reserveTime.getText().toString().equals("请选择")) {
                    ToastShort("请选择预约时间");
                    return;
                }
                postRepair();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CAMERA && resultCode == RESULT_OK) {
            Log.e("TAG", "拍照---------" + FileProvider.getUriForFile(this, "com.fhx.propertyuser.provider", file));
            Log.e("TAG", "拍照---------" + file);
//            imageView.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
            Luban(file);

        } else if (requestCode == REQUEST_CODE_SELECT_IMG) {
            showContent(data);
            return;
        }

    }

    /**
     * 初始化相机相关权限
     * 适配6.0+手机的运行时权限
     */
    private File file;

    private void useCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()
                + "/images/" + System.currentTimeMillis() + ".jpg");
        file.getParentFile().mkdirs();
        //改变Uri com.fhx.property.provider注意和xml中的一致
        Uri uri = FileProvider.getUriForFile(this, "com.fhx.propertyuser.provider", file);
        //添加权限
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    /**
     * 选择图片回调
     *
     * @param data
     */
    private void showContent(Intent data) {
        List<String> paths = ImageSelector.getImagePaths(data);

        if (paths.isEmpty()) {
            for (int i = 0; i < paths.size(); i++) {
                mImageList.add(paths.get(i));
            }
            return;
        }

        for (int i = 0; i < paths.size(); i++) {
            File file = new File(paths.get(i));
            Luban(file);
        }

    }

    private void chooseSize() {
        imageChooseAdapter.notifyDataSetChanged();
    }

    /**
     * 鲁班图片压缩
     *
     * @param file
     */
    private void Luban(File file) {
        Luban.with(ToRepairActivity.this)
                .load(file)
                .ignoreBy(100)
                .setCompressListener(new OnCompressListener() {
                    @Override
                    public void onStart() {
                        Log.e("luban", "onStart");
                    }

                    @Override
                    public void onSuccess(File file) {
                        Log.e("luban", file.getAbsolutePath());
                        upImage(file);
                        mImageList.add(file.getAbsolutePath());
                        chooseSize();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("luban", e.getMessage());

                    }
                })
                .launch();
    }

    /**
     * 获取时间类型
     */
    private void getEventType() {
        EasyHttp.get(AppUrl.RepairType)
                .syncRequest(false)
                .params("pageNum", "1")
                .params("pageSize", "50")
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        RepairTypeListBean repairTypeListBean = JSON.parseObject(s, RepairTypeListBean.class);
                        if (repairTypeListBean.isSuccess()) {
                            List<RepairTypeListBean.DataBean.RecordsBean> records = repairTypeListBean.getData().getRecords();
                            for (int i = 0; i < records.size(); i++) {
                                mEventTypeList.add(records.get(i).getRepairTypeName());
                                mEventTypeIdList.add(records.get(i).getRepairTypeId());
                            }

                        } else {
                            ToastShort(repairTypeListBean.getMsg());
                        }
                    }
                });
    }

    /**
     * 提交报修表单
     */
    private void postRepair() {
        String images = "";
        if (UpImageList.size() > 0) {
            for (int i = 0; i < UpImageList.size(); i++) {
                switch (i) {
                    case 0:
                        images = UpImageList.get(0);
                        break;
                    case 1:
                        images = UpImageList.get(0) + "," + UpImageList.get(1);
                        break;
                    case 2:
                        images = UpImageList.get(0) + "," + UpImageList.get(1) + "," + UpImageList.get(2);
                        break;
                }
            }
        }

        PostRequest post = EasyHttp.post(AppUrl.RepairAdd);

        post.syncRequest(false)
//                .headers("Admin-Token",mmkv.decodeString("token"))
                .params("originType", "1")//区分用户端还是物业端 0物业  1用户
                .params("repairTypeId", eventTypeId)
                .params("repairTypeName", tv_eventType.getText().toString())
                .params("customerPhone", et_user_number.getText().toString())
                .params("customerName", et_user_name.getText().toString())
                .params("content", et_content.getText().toString())//描述
                .params("notes", et_notes.getText().toString())//地址
                .params("customerId", mmkv.decodeString("customerId")) //用户id
                .params("reserveTime", tv_reserveTime.getText().toString()) //预约事件
                .params("imgs",images)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        SuccessBean successBean = JSON.parseObject(s, SuccessBean.class);
                        if (successBean.isSuccess()) {
                            ToastShort("提交成功");
                            finish();
                            overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                        } else {
                            ToastShort(successBean.getMsg());
                        }
                    }
                });

    }

    /**
     * 图片上传
     */
    private void upImage(File file) {
        UIProgressResponseCallBack uiProgressResponseCallBack = new UIProgressResponseCallBack() {
            @Override
            public void onUIResponseProgress(long bytesRead, long contentLength, boolean done) {
                int progress = (int) (bytesRead * 100 / contentLength);
                Log.e("fhxx", "上传" + progress);
                if (done) {
                    ToastShort("上传成功");
                }
            }
        };
        EasyHttp.post(AppUrl.ImageUpLoad)
                .syncRequest(false)
                .timeStamp(true)
                .params("file", file, uiProgressResponseCallBack)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("imageError", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        UpLoadImageBean successBean = JSON.parseObject(s, UpLoadImageBean.class);
                        if (successBean.isSuccess()) {
                            UpImageList.add(successBean.getData().getUrl());
                        }
                    }
                });
    }
}
