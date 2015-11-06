package com.qb.androidstudy.ui;

import android.content.Intent;
import android.widget.Button;

import com.qb.androidstudy.R;
import com.qb.androidstudy.ui.widget.RecycleViewDemo.RecycleViewActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * �基础 ���  ����
 */
public class MainActivity extends BaseActivity {


    @Bind(R.id.RecycleViewBtnId)
    Button  RecycleViewId;

    @Override
    public int setLayoutId(){
        return R.layout.activity_main;
    }

    @OnClick(R.id.RecycleViewBtnId)
    public void open_RecycleView(){
        Intent intent = new Intent(this, RecycleViewActivity.class);
        startActivity(intent);
    }





}
