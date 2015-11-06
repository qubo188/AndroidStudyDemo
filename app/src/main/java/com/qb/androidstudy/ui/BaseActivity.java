package com.qb.androidstudy.ui;

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;

/**
 * 项目名称：AndroidStudy
 * 类描述：
 * 创建人：qubo
 * 创建时间：2015/11/3 0003 下午 2:33
 */
public class BaseActivity extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activity_show_before_operation();

        setContentView(setLayoutId());

        ButterKnife.bind(this);

        activity_show_after_operation();
    }

    public int setLayoutId(){
        return 0;
    }

    public void activity_show_before_operation(){

    }

    public void activity_show_after_operation(){

    }


}
