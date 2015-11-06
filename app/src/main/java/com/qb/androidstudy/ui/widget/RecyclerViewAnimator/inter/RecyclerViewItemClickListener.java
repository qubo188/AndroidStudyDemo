package com.qb.androidstudy.ui.widget.RecyclerViewAnimator.inter;

import android.view.View;

/**
 * 项目名称：AndroidStudy
 * 类描述：
 * 创建人：qubo
 * 创建时间：2015/11/6 0006 下午 5:28
 */
public interface RecyclerViewItemClickListener {
    void onItemClick(View view , int position);
    void onLongItemClick(View view , int position);
}
