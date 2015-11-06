package com.qb.androidstudy.ui.widget.RecyclerViewAnimator.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qb.androidstudy.R;
import com.qb.androidstudy.ui.widget.RecyclerViewAnimator.inter.RecyclerViewItemClickListener;

import java.util.ArrayList;

/**
 * 项目名称：AndroidStudy
 * 类描述：
 * 创建人：qubo
 * 创建时间：2015/11/6 0006 下午 4:11
 */
public class ItemAnimatorAdapter extends RecyclerView.Adapter<RecyclerView_ItemAnimator_ViewHolder>{

    // 1 上下文
    private Context context ;
    // 2 数据
    private ArrayList<String> data;
    // ViewHolder 要绑定 哪个Xml中的数据
    private LayoutInflater li;

    // 3解决 RecyclerView不带 点击 事件
    private RecyclerViewItemClickListener rvItemListener;

    public ItemAnimatorAdapter(Context context , ArrayList<String> data) {

        this.context = context;
        this.data = data;

        li = LayoutInflater.from(context);

    }

    // 设置 每一个Item的点击事件
    public void setRecyclerViewItemClickListener(RecyclerViewItemClickListener rvItemListener){
        this.rvItemListener = rvItemListener;
    }


    @Override
    public RecyclerView_ItemAnimator_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view =  li.inflate(R.layout.recyclerview_item, parent, false);

        RecyclerView_ItemAnimator_ViewHolder riv = new RecyclerView_ItemAnimator_ViewHolder(view);

        return riv;
    }

    @Override
    public void onBindViewHolder(final RecyclerView_ItemAnimator_ViewHolder holder, final int position) {

        holder.recyclerView_Item_TV_ID.setText(data.get(position));

        // 单次点击
        holder.recyclerView_Item_TV_ID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.getLayoutPosition();
                rvItemListener.onItemClick(holder.itemView , pos);
            }
        });
        // 长安 点击
        holder.recyclerView_Item_TV_ID.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int pos = holder.getLayoutPosition();
                rvItemListener.onLongItemClick(holder.itemView , pos);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    /*--------------------自定义 方法--------------------------*/

    /**
     * @param pos  在元素 几的 位置上 添加 一个新的 元素
     */
    public void addItem(int pos){
        data.add(pos , "lalala < " + pos + " >");
        notifyItemInserted(pos);
    }

    /**
     * @param pos  在元素 几的  位置上 删除 一个 旧的元素
     */
    public void delItem(int pos){
        notifyItemRemoved(pos);
    }
}
