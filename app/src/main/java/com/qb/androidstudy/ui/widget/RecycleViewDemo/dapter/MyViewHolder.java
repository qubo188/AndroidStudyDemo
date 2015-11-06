package com.qb.androidstudy.ui.widget.RecycleViewDemo.dapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.qb.androidstudy.R;

/**
 * 项目名称：AndroidStudy
 * 类描述：这个 ViewHodler 模拟老板的ListView的ViewHolder
 *        所以这个的主要功能。就是 获取 你 自定义的View布局 中的 要显示所有的 控件的对象
 * 创建人：qubo
 * 创建时间：2015/11/3 0003 下午 3:44
 */
public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView recyclerView_Item_TV_ID;

    public MyViewHolder(View itemView) {
        super(itemView);

        recyclerView_Item_TV_ID = (TextView)itemView.findViewById(R.id.recyclerView_Item_TV_ID);
    }

}
