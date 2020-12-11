package com.fhx.propertyuser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.fhx.propertyuser.fragment.home.HomeFragment;
import com.fhx.propertyuser.fragment.home.MineFragment;
import com.fhx.propertyuser.fragment.home.ScanFragment;
import com.fhx.propertyuser.utils.ActivityControl;
import com.fhx.propertyuser.utils.JWebSocketClient;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rg_home;
    private List<Fragment> fragments =new ArrayList<>();

    @Override
    protected void onResume() {
        super.onResume();
        //其他权限
        applyWritePermission();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListener();

    }

    /**
     * 所有绑定
     */

    private void initView() {
        rg_home =findViewById(R.id.rg_home);

    }


    /**
     * 所有数据处理
     */
    private void initData() {
        ActivityControl.getInstance().add(MainActivity.this);
        fragments.add(new HomeFragment());
        fragments.add(new ScanFragment());
        fragments.add(new MineFragment());

        SwitchFragment(0);
    }


    /**
     * 申请权限
     */
    public void applyWritePermission() {
        String[] permissions = new String[]{Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.VIBRATE};
        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(this, permissions[0]) != PackageManager.PERMISSION_GRANTED ||
                    ContextCompat.checkSelfPermission(this, permissions[1]) != PackageManager.PERMISSION_GRANTED||
                    ContextCompat.checkSelfPermission(this, permissions[2]) != PackageManager.PERMISSION_GRANTED||
                    ContextCompat.checkSelfPermission(this, permissions[3]) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, permissions, 1);
            }
        }

    }


    /**
     * 所有监听
     */
    private void initListener() {

        rg_home.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_home:
                        SwitchFragment(0);

                        break;
                    case R.id.rb_scan:
                        SwitchFragment(1);

                        break;
                    case R.id.rb_mine:
                        SwitchFragment(2);

                        break;
                }
            }
        });


    }


    public void SwitchFragment(int i){
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragments.get(i));
        fragmentTransaction.commit();
    }



    /**
     * 两次点击退出
     */
    private static final int TIME_EXIT = 2000;
    private long mBackPressed;
    @Override
    public void onBackPressed() {
        if (mBackPressed + TIME_EXIT > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(this, "再点击一次返回退出程序", Toast.LENGTH_SHORT).show();
            mBackPressed = System.currentTimeMillis();
        }
    }
}
