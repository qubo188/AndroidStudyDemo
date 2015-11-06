package com.qb.androidstudy.ui.widget.StaggeredGridLayoutManagerDemo;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.qb.androidstudy.R;
import com.qb.androidstudy.ui.BaseActivity;
import com.qb.androidstudy.ui.widget.StaggeredGridLayoutManagerDemo.adapter.StaggeredAdapter;
import com.qb.androidstudy.utils.DataUtils;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * 项目名称：AndroidStudy
 * 类描述：
 * 创建人：qubo
 * 创建时间：2015/11/6 0006 下午 2:25
 */
public class StaggeredGridLayoutManagerActivity extends BaseActivity {

    private ArrayList<String> data = new ArrayList<String>();

    @Bind(R.id.staggeredId)
    RecyclerView staggeredId;

    @Override
    public int setLayoutId() {
        return R.layout.activity_staggered;
    }


    @Override
    public void activity_show_after_operation() {

        // 第一步 初始化  数据
        initData();

        // 第二步 初始化 Adapter
        initAdapter();

        // 第三步 已哪种方式 显示
        showRecyclerView();
    }


    private void initData() {
        data = DataUtils.generateData(50);
    }

    private void initAdapter() {

        StaggeredAdapter staggeredAdapter = new StaggeredAdapter(this, data);

        staggeredId.setAdapter(staggeredAdapter);

    }

    private void showRecyclerView() {

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        staggeredId.setLayoutManager(staggeredGridLayoutManager);

    }
}
