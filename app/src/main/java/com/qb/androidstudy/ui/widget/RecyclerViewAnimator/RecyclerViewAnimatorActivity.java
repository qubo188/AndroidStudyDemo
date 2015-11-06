package com.qb.androidstudy.ui.widget.RecyclerViewAnimator;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.qb.androidstudy.R;
import com.qb.androidstudy.ui.BaseActivity;
import com.qb.androidstudy.ui.widget.RecyclerViewAnimator.adapter.ItemAnimatorAdapter;
import com.qb.androidstudy.ui.widget.RecyclerViewAnimator.inter.RecyclerViewItemClickListener;
import com.qb.androidstudy.utils.DataUtils;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 项目名称：AndroidStudy
 * 类描述：
 * 创建人：qubo
 * 创建时间：2015/11/6 0006 下午 4:02
 */
public class RecyclerViewAnimatorActivity extends BaseActivity implements RecyclerViewItemClickListener {

    // 1  数据

    private ArrayList<String> data = new ArrayList<String>();

    // 2  绑定 RecyclerView
    @Bind(R.id.itemAnimatorId)
    RecyclerView itemAnimatorId;

    // 3 初始化 Adapter

    private ItemAnimatorAdapter riv;

    // 4 数据 的操作

    @Bind(R.id.RV_addItemId)
    Button RV_addItemId;

    @Bind(R.id.RV_delItemId)
    Button RV_delItemId;


    @Override
    public int setLayoutId() {
        return R.layout.activity_recyclerview_itemanimator;
    }

    @Override
    public void activity_show_after_operation() {

        // 初始化 数据
        initData();

        // 初始化 Adapter
        initAdapter();

        // 因为 RecyclerView不支持Item的点击事件。所有我们这个地方自定义监听
        initListener();

        // 初始化 样式

        showRecyclerView();
    }

    /**
     * 1  初始化 数据
     */
    private void initData() {
        data = DataUtils.generateData(50);
    }

    /*
     * 2 初始化 Adapter
     */
    private void initAdapter() {
        riv = new ItemAnimatorAdapter(this, data);
        itemAnimatorId.setAdapter(riv);

    }

    /*
     * 3 设置 自定义监听
     */

    public void initListener() {
        riv.setRecyclerViewItemClickListener(this);
    }

    /*
     * 设置 RecyclerView按哪种方式显示
     */
    private void showRecyclerView() {

        // 设置 垂直 显示
        itemAnimatorId.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));

        // 设置---->添加  删除 一个Item的效果

        itemAnimatorId.setItemAnimator(new DefaultItemAnimator());


    }

    /**
     * 删除 一个Item
     */
    @OnClick(R.id.RV_delItemId)
    public void delet_Item(View view) {
        riv.delItem(1);
    }

    /**
     * 添加 一个Item
     */
    @OnClick(R.id.RV_addItemId)
    public void add_Item(View view) {
        riv.addItem(1);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast t = Toast.makeText(this, "你点击了 短-->" + position, Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void onLongItemClick(View view, int position) {
        Toast t = Toast.makeText(this, "你点击了 长安-->" + position, Toast.LENGTH_LONG);
        t.show();
    }
}
