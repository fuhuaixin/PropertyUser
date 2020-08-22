package com.fhx.propertyuser.activity.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.fhx.propertyuser.R;
import com.fhx.propertyuser.base.BaseActivity;

/**
 * 个人认证
 */
public class PersonalAttestationActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageBack;
    private TextView tvTitle;
    private RadioGroup rg_house,rg_person;

    private int chooseHouse =1; //判断那个房屋类型被选中 1   2
    private int choosePerson =1; //判断那个 个人类型被选中 1  2  3
    @Override
    protected int initLayout() {
        return R.layout.activity_personal_attestation;
    }

    @Override
    protected void initView() {
        imageBack = (ImageView) findViewById(R.id.image_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);

        rg_house = (RadioGroup) findViewById(R.id.rg_house);
        rg_person = (RadioGroup) findViewById(R.id.rg_person);

    }

    @Override
    protected void initData() {
        tvTitle.setText("个人认证");
    }

    @Override
    protected void initListen() {
        imageBack.setOnClickListener(this);
        rg_house.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_house_one:
                        chooseHouse=1;
                    break;
                    case R.id.rb_house_two:
                        chooseHouse=2;
                    break;
                }
            }
        });
        rg_person.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_person_one:
                        choosePerson=1;
                    break;
                    case R.id.rb_person_two:
                        choosePerson=2;
                    break;
                    case R.id.rb_person_three:
                        choosePerson=3;
                    break;
                }
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
        }
    }
}
