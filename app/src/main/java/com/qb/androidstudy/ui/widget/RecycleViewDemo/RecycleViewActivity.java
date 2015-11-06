package com.qb.androidstudy.ui.widget.RecycleViewDemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;

import com.qb.androidstudy.R;
import com.qb.androidstudy.config.appConfig;
import com.qb.androidstudy.ui.BaseActivity;
import com.qb.androidstudy.ui.widget.RecycleViewDemo.dapter.CustomSimpleAdapter;
import com.qb.androidstudy.ui.widget.RecyclerViewAnimator.RecyclerViewAnimatorActivity;
import com.qb.androidstudy.ui.widget.StaggeredGridLayoutManagerDemo.StaggeredGridLayoutManagerActivity;
import com.qb.androidstudy.utils.DataUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 项目名称：AndroidStudy
 * 类描述：实现 RecycleView效果
 * 创建人：qubo
 * 创建时间：2015/11/3 0003 下午 2:41
 */
public class RecycleViewActivity extends BaseActivity {

    // 绑定 RecyclerView
    @Bind(R.id.RecycleViewId)
    RecyclerView RecycleViewId;


    @Bind(R.id.menu01_id)
    Button menu01_id;

    @Bind(R.id.menu02_id)
    Button menu02_id;

    @Bind(R.id.menu03_id)
    Button menu03_id;

    @Bind(R.id.menu06_id)
    Button menu06_id;

    @Bind(R.id.menu05_id)
    Button menu05_id;


    private List<String> data;

    private CustomSimpleAdapter csa;

    private boolean open = false;


    @Override
    public int setLayoutId() {
        return R.layout.activity_recycleview;
    }

    @Override
    public void activity_show_after_operation() {

        initData();

        initRecyclerView();
    }


    /**
     * 初始化数据  Adapter 数据
     */
    private void initData() {

        data = DataUtils.generateData(50);

        csa = new CustomSimpleAdapter(this, data);
        RecycleViewId.setAdapter(csa);
    }

    /**
     * 初始化 RecyclerView
     */
    private void initRecyclerView() {


        // 使用 LinearLayout为布局

        LinearLayoutManager linear = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // 1 设置 按 哪种布局显示
        RecycleViewId.setLayoutManager(linear);

        // 2 添加 每个Item的 分割线
        //RecycleViewId.addItemDecoration(new MyDivider(this));因为我在 Item里面设置了Magrin所以这个地方注释掉了


    }

    /**
     * 最 基本的  LinearLayoutManager
     * @param view
     */
    @OnClick(R.id.menu01_id)
    public void onClickMenu01(View view) {
        Log.v(appConfig.LOG_TAG, "点击了 菜单按钮");

        RecycleViewId.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false));

        toggle();
    }

    /**
     *  是用 StaggeredGridLayoutManager  实现 水平的 Grid
     * @param view
     */
    @OnClick(R.id.menu02_id)
    public void onClickMenu02(View view) {

        // 显示的 是 5行
        RecycleViewId.setLayoutManager(new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.HORIZONTAL));

    }

    /**
     * 实现  GridLayoutManager
     * @param view
     */
    @OnClick(R.id.menu03_id)
    public void onClickMenu03(View view) {
        //显示的 是 三列
        RecycleViewId.setLayoutManager(new GridLayoutManager(this , 3));
    }

    /**
     * 演示 添加 或者 删除 一个 元素的动画
     * @param view
     */
    @OnClick(R.id.menu06_id)
    public void onClickMenu06(View view) {
        Intent intent = new Intent(this , RecyclerViewAnimatorActivity.class);
        startActivity(intent);
    }

    /**
     * 瀑布流 的方式 实现  StaggeredGridLayoutManager
     * @param view
     */
    @OnClick(R.id.menu05_id)
    public void onClickMenu05(View view) {
        Intent intent = new Intent(this , StaggeredGridLayoutManagerActivity.class);
        startActivity(intent);
    }

    public void toggle() {
        if (open) {
            Log.v(appConfig.LOG_TAG, "调取 关闭 菜单按钮");
            closeMenu();
        } else {
            Log.v(appConfig.LOG_TAG, "调取 打开 菜单按钮");
            openMenu();
        }
    }

    public void openMenu() {
        open = true;

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(menu02_id, "translationX", 200);

        ObjectAnimator animator3 = ObjectAnimator.ofFloat(menu03_id, "translationX", 400);

        ObjectAnimator animator5 = ObjectAnimator.ofFloat(menu06_id, "translationX", 600);

        ObjectAnimator animator6 = ObjectAnimator.ofFloat(menu05_id, "translationX", 800);

        animator1.setDuration(300);
        animator3.setDuration(300);
        animator5.setDuration(300);
        animator6.setDuration(300);

        animator1.setInterpolator(new BounceInterpolator());
        animator3.setInterpolator(new BounceInterpolator());
        animator5.setInterpolator(new BounceInterpolator());
        animator6.setInterpolator(new BounceInterpolator());


        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animator1).after(animator3).after(animator5).after(animator6);

        animatorSet.start();
    }

    public void closeMenu() {
        open = false;

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(menu02_id, "translationX", 0);

        ObjectAnimator animator3 = ObjectAnimator.ofFloat(menu03_id, "translationX", 0);

        ObjectAnimator animator5 = ObjectAnimator.ofFloat(menu06_id, "translationX", 0);

        ObjectAnimator animator6 = ObjectAnimator.ofFloat(menu05_id, "translationX", 0);

        animator1.setDuration(300);
        animator3.setDuration(300);
        animator5.setDuration(300);
        animator6.setDuration(300);

        animator1.setInterpolator(new BounceInterpolator());
        animator3.setInterpolator(new BounceInterpolator());
        animator5.setInterpolator(new BounceInterpolator());
        animator6.setInterpolator(new BounceInterpolator());


        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animator1).after(animator3).after(animator5).after(animator6);

        animatorSet.start();
    }
}
