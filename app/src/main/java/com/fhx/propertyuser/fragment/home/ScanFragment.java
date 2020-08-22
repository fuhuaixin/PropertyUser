package com.fhx.propertyuser.fragment.home;

import android.os.Vibrator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fhx.propertyuser.R;
import com.fhx.propertyuser.base.BaseFragment;

import cn.bingoogolapple.qrcode.core.QRCodeView;

import static android.content.Context.VIBRATOR_SERVICE;

/**
 * 扫一扫
 */
public class ScanFragment extends BaseFragment implements QRCodeView.Delegate {
    private ImageView imageBack;
    private TextView tvTitle;
    private QRCodeView qrCodeView;

    @Override
    public int setLayoutId() {
        return R.layout.fragment_scan;
    }

    @Override
    public void findViewById(View view) {
        super.findViewById(view);
        imageBack = view.findViewById(R.id.image_back);
        tvTitle = view.findViewById(R.id.tv_title);
        qrCodeView = view.findViewById(R.id.qrZBar);
        qrCodeView.setDelegate(this);
    }

    @Override
    public void setViewData(View view) {
        super.setViewData(view);
        imageBack.setVisibility(View.GONE);
        tvTitle.setText("扫一扫");

    }

    @Override
    public void setClickEvent(View view) {
        super.setClickEvent(view);
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        vibrate();//震动手机
        //扫描成功后处理事件
        qrCodeView.startSpot();//继续扫描
        Toast.makeText(mActivity, "扫描得到---》" + result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        Toast.makeText(getContext(), "错误", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onStart() {
        super.onStart();
        qrCodeView.startCamera();//打开后置摄像头开始预览，但是并未开始识别;
        qrCodeView.startSpotAndShowRect(); // 显示扫描框，并开始识别

//        mQRCodeView.showScanRect();//显示扫描框
//        qrCodeView.startSpot();//开始识别二维码
//        qrCodeView.openFlashlight();//开灯
        //mQRCodeView.closeFlashlight();//关灯
    }

    private void vibrate() {
        Vibrator vibrator = (Vibrator) getContext().getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }

    @Override
    public void onStop() {
        qrCodeView.stopCamera();// 关闭摄像头预览，并且隐藏扫描框
        super.onStop();
    }


    @Override
    public void onDestroy() {
        qrCodeView.onDestroy();
        super.onDestroy();
    }
}
