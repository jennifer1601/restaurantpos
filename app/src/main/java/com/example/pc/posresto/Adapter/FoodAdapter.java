package com.example.pc.posresto.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pc.posresto.Model.Food;
import com.example.pc.posresto.Model.OrderDetail;
import com.example.pc.posresto.R;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    private List<OrderDetail> mDataset;
    private Activity mActivity;

    public static class ViewHolder extends RecyclerView.ViewHolder{
         public TextView foodQty;
         public TextView foodName;
         public TextView foodPrice;
         public TextView priceQty;
         public ViewHolder (View v){
             super(v);
             foodQty = (TextView)v.findViewById(R.id.food_qty);
             foodName = (TextView) v.findViewById(R.id.food_name);
             foodPrice = (TextView) v.findViewById(R.id.food_price);
             priceQty = (TextView) v.findViewById(R.id.total_per_qty);
         }

    }

    public FoodAdapter(List<OrderDetail> myDataset, Activity myActivity){
        mDataset = myDataset;
        mActivity = myActivity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_list_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.foodQty.setText(mDataset.get(position).getQty() + "");
        holder.foodName.setText(mDataset.get(position).getName());
        holder.foodPrice.setText(mDataset.get(position).getPrice()+ "");
        int a = mDataset.get(position).getQty() * mDataset.get(position).getPrice();
        holder.priceQty.setText(a + "");
    }

    public int getItemCount() {return mDataset.size(); }

    public void addItem(int position, List<OrderDetail> list){
        mDataset.addAll(mDataset.size(), list);
        this.notifyDataSetChanged();
    }
}
