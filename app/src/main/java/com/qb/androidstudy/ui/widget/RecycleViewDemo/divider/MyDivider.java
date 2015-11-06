package com.qb.androidstudy.ui.widget.RecycleViewDemo.divider;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 项目名称：AndroidStudy
 * 类描述：
 * 创建人：qubo
 * 创建时间：2015/11/6 0006 上午 10:44
 */
public class MyDivider extends RecyclerView.ItemDecoration{


    //第一步  准备一个分割条的   图像
    //自定义 的 分割线 图像
    private Drawable mDrawable;
    // 系统 默认的  分割线  -->但是我 在 styles.xml中 对这个系统样式重写了。去那里查看使用的是 /drawble/listdivider.xml效果
    private static final int[] ATTRS = {android.R.attr.listDivider};



    // 第二步  添加 构造函数  初始化 分割条

    public MyDivider(Context context){
        TypedArray typedArray = context.obtainStyledAttributes(ATTRS);
        // 从 自己设置的 系统默认的 分割条 取出。 实际上取出的是 ： android.R.attr.listDivider
        mDrawable = typedArray.getDrawable(0);

        // 由于上面 已经取出了。typedArray就已经没有用了。所以应该释放一下
        typedArray.recycle();
    }



    // 第三步 ：  在 此方法中 绘制 所有 Item的 分割条
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {

        // 一个分割条。其实就是一个 矩形。
        // 想绘制 矩形 就必须 知道  矩形的 左上角坐标。 和 右下角 坐标

        // 获取 列表项  距离 左边缘的 距离
        int left = parent.getPaddingLeft();
        // 获取 列表项  距离 右边缘的 距离
        int right = parent.getWidth() - parent.getPaddingRight();

        // 获取 列表项的 总数 ----》只有知道这个了。我们才知道要绘制多少个分割线

        int childCount = parent.getChildCount();

        // 开始 绘制  所有的 分割线
        // 重点： 但是我们必须 知道  每个 Item的 高度是多少？   和  每个Item之间的距离多少？
        for (int i = 0; i < childCount; i++) {

            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams)child.getLayoutParams();

            // 计算 左上角的 坐标
            int top = child.getBottom() + params.bottomMargin;

            // 计算 右 下角的 坐标
            int bottom = top + mDrawable.getIntrinsicHeight();

            // 设置  绘制  的   范围
            // 其实就是 设置 左上角 坐标  +  右下角坐标
            mDrawable.setBounds(left , top , right , bottom);

            // 最后 一步 开始 绘制
            mDrawable.draw(c);
        }
    }
}
