package com.qb.androidstudy.ui.widget.StaggeredGridLayoutManagerDemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qb.androidstudy.R;
import com.qb.androidstudy.config.appConfig;
import com.qb.androidstudy.ui.widget.RecycleViewDemo.dapter.MyViewHolder;

import java.util.ArrayList;

/**
 * 项目名称：AndroidStudy
 * 类描述：
 * 创建人：qubo
 * 创建时间：2015/11/6 0006 下午 2:42
 */
public class StaggeredAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private ArrayList<String> data;
    private LayoutInflater li;

    private ArrayList<Integer> heights = new ArrayList<Integer>();

    public StaggeredAdapter(Context context, ArrayList<String> data) {
        this.context = context;
        this.data = data;
        li = LayoutInflater.from(context);

        for (int i = 0; i < data.size(); i++) {
            heights.add((int)(Math.random()*300+100));
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = li.inflate(R.layout.recyclerview_item , parent , false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();

        lp.height = heights.get(position);

        Log.v(appConfig.LOG_TAG , "高度-------> " + heights.get(position));

        holder.itemView.setLayoutParams(lp);

        holder.recyclerView_Item_TV_ID.setText(data.get(position));

    }


    @Override
    public int getItemCount() {
        return data.size();
    }
}
