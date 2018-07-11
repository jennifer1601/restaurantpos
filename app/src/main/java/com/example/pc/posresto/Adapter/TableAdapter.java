package com.example.pc.posresto.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pc.posresto.MainActivity;
import com.example.pc.posresto.Model.Table;
import com.example.pc.posresto.OrderActivity;
import com.example.pc.posresto.R;

import java.util.List;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.ViewHolder> {

    private List<Table> mDataset;
    private Activity mActivity;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tableNo;
        public TextView tableStatus;
        public CardView cardView_table;
        public ViewHolder (View v){
            super(v);
            tableNo = (TextView)v.findViewById(R.id.table_no_id);
            tableStatus = (TextView) v.findViewById(R.id.table_status);
            cardView_table = (CardView) v.findViewById(R.id.cardview_table_id);
        }
    }

    public TableAdapter(List<Table> myDataset, Activity myActivity){
        mDataset = myDataset;
        mActivity = myActivity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_table_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull TableAdapter.ViewHolder holder, final int position) {
        String status = "";
        switch (mDataset.get(position).getStatus()){
            case 0 :
                status = "open";
                holder.tableNo.setBackgroundResource(R.color.open);
                break;
            case 1 :
                status = "filled";
                holder.tableNo.setBackgroundResource(R.color.filled);
                break;
            case 2 :
                status = "reserved";
                holder.tableNo.setBackgroundResource(R.color.reserved);
                break;
        }
        holder.tableNo.setText(mDataset.get(position).getName());
        holder.tableStatus.setText(status);
        holder.cardView_table.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity, OrderActivity.class);
                intent.putExtra("Table No", mDataset.get(position).getName());
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                mActivity.startActivity(intent);

            }
        });
    }

    public int getItemCount() {return mDataset.size(); }

}
