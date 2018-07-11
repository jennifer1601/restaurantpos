package com.example.pc.posresto.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Debug;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.posresto.MainActivity;
import com.example.pc.posresto.Model.Food;
import com.example.pc.posresto.Model.Menu;
import com.example.pc.posresto.Model.OrderDetail;
import com.example.pc.posresto.OrderActivity;
import com.example.pc.posresto.R;
import com.example.pc.posresto.fragments.FirstFragment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private static List<OrderDetail> food = new ArrayList<>();
    private List<Menu> mDataset;
    private Activity mActivity;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView menuImg;
        public TextView menuTitle, menuPrice;
        public CardView cardView;

        public ViewHolder (View v){
            super(v);
//            menuImg = (ImageView)v.findViewById(R.id.menu_img_id);
            menuTitle = (TextView) v.findViewById(R.id.menu_title_id);
            menuPrice = (TextView) v.findViewById(R.id.menu_price_id);
            cardView = (CardView) v.findViewById(R.id.cardview_id);
        }
    }

    public MenuAdapter(List<Menu> myDataset, Activity myActivity){
        mDataset = myDataset;
        mActivity = myActivity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_item_menu, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
//        holder.menuImg.setImageResource(R.drawable.ic_launcher_background);
        holder.menuTitle.setText(mDataset.get(position).getName());
        holder.menuPrice.setText(mDataset.get(position).getPrice() + "");
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(mActivity);
                View mView = (View) LayoutInflater.from(mActivity).inflate(R.layout.dialog_quantity, null);

                final EditText dialogQty = (EditText) mView.findViewById(R.id.dialog_qty);
                final EditText dialogCom = (EditText) mView.findViewById(R.id.dialog_com);
                Button dialogBtnConfirm = (Button) mView.findViewById(R.id.dialog_btn_confirm);

                //dialog btn listener
                dialogBtnConfirm.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
//                        OrderDetail o = new OrderDetail(Integer.parseInt(OrderActivity.tableNum),mDataset.get(position).getRecord_id(),
//                                mDataset.get(position).getRecord_id(),Integer.parseInt(dialogQty.getText().toString()),mDataset.get(position).getVoid_status(),
//                                mDataset.get(position).getDelete_status(),mDataset.get(position).getPrice(),dialogCom.getText().toString(),
//                                mDataset.get(position).getName());
                        food.clear();
                        food.add(new OrderDetail(Integer.parseInt(OrderActivity.tableNum),mDataset.get(position).getRecord_id(),
                                mDataset.get(position).getRecord_id(),Integer.parseInt(dialogQty.getText().toString()),mDataset.get(position).getVoid_status(),
                                mDataset.get(position).getDelete_status(),mDataset.get(position).getPrice(),dialogCom.getText().toString(),
                                mDataset.get(position).getName()));
                        boolean same = true;
                        for (int i = 0 ; i < FirstFragment.food.size() ; i ++){
                            if(FirstFragment.food.get(i).getMenu_id() == food.get(0).getMenu_id()){
                                Log.d("menu id first frag food", FirstFragment.food.get(i).getMenu_id() + "");
                                Log.d("menu id id", food.get(0).getMenu_id() + "");
                                int addQty = FirstFragment.food.get(i).getQty() + Integer.parseInt(dialogQty.getText().toString());
                                FirstFragment.food.get(i).setQty(addQty);
                                same = true;
                                break;
                            }else same = false;
                        }
                        if(same == false){FirstFragment.food.addAll(food);}

                        FirstFragment.recreate();
                        Log.d("size",FirstFragment.food.size()+"");
                        Toast.makeText(mActivity, "Test", Toast.LENGTH_SHORT).show();
                        mBuilder.create().dismiss();
                    }
                });

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });
    }

    public int getItemCount() {return mDataset.size(); }
}



