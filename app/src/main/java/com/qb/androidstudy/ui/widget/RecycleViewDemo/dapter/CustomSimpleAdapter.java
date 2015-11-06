package com.qb.androidstudy.ui.widget.RecycleViewDemo.dapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qb.androidstudy.R;

import java.util.List;

/**
 * 项目名称：AndroidStudy
 * 类描述：
 * 创建人：qubo
 * 创建时间：2015/11/3 0003 下午 3:42
 */
public class CustomSimpleAdapter extends RecyclerView.Adapter<MyViewHolder>{

    private LayoutInflater inflater;

    private Context context ;
    private List<String> data;


    public CustomSimpleAdapter(Context context , List<String> data){
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }


    /**
     *
     * @param parent
     * @param viewType
     * @return
     *
     * Description : 创建 ViewHolder
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // 找到 你要 引用 的 那个 View
        View view = inflater.inflate(R.layout.recyclerview_item , parent , false);

        //主要 就是 创建这个 ViewHolder
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    /**
     *
     * @param holder
     * @param position
     * Description : 绑定 ViewHolder 上的数据
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.recyclerView_Item_TV_ID.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
