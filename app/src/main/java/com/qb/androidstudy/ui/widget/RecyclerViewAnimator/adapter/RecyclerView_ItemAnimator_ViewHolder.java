package com.qb.androidstudy.ui.widget.RecyclerViewAnimator.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.qb.androidstudy.R;

/**
 * 项目名称：AndroidStudy
 * 类描述：
 * 创建人：qubo
 * 创建时间：2015/11/6 0006 下午 4:09
 */
public class RecyclerView_ItemAnimator_ViewHolder extends RecyclerView.ViewHolder{

    public TextView recyclerView_Item_TV_ID;

    public RecyclerView_ItemAnimator_ViewHolder(View itemView) {
        super(itemView);

        recyclerView_Item_TV_ID = (TextView)itemView.findViewById(R.id.recyclerView_Item_TV_ID);

    }


}
