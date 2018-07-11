package com.example.pc.posresto.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pc.posresto.Adapter.FoodAdapter;
import com.example.pc.posresto.Adapter.MenuAdapter;
import com.example.pc.posresto.MainActivity;
import com.example.pc.posresto.Model.Food;
import com.example.pc.posresto.Model.Menu;
import com.example.pc.posresto.Model.OrderDetail;
import com.example.pc.posresto.OrderActivity;
import com.example.pc.posresto.R;
import com.example.pc.posresto.api.API;
import com.example.pc.posresto.api.Service.Services;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FirstFragment extends Fragment{

    TextView tes1;

    //recyclerview
    private RecyclerView orderDetail_rView;
    private LinearLayoutManager mLayoutManager;

    static FoodAdapter foodAdapter;
    private Services service;
//    private Food[] food = new Food[]{
//      new Food("1", "asd"),
//      new Food("2", "asd"),
//    };

    public static List<OrderDetail> food;
    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        service = API.getClient().create(Services.class);
//        tes1 = (TextView) view.findViewById(R.id.tes1);

        orderDetail_rView = (RecyclerView)view.findViewById(R.id.order_list_rView);
        orderDetail_rView.setHasFixedSize(true);

        //use a lienar layout
        mLayoutManager = new LinearLayoutManager(getContext());
        orderDetail_rView.setLayoutManager(mLayoutManager);
        orderDetail_rView.addItemDecoration(new DividerItemDecoration(getActivity(),LinearLayoutManager.VERTICAL));

        listMenuCategory(Integer.parseInt(OrderActivity.tableNum));
        return  view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        //add what u wannt display

    }

    public void listOrder(){
        //specify an adapter
        foodAdapter = new FoodAdapter(food, getActivity());
        orderDetail_rView.setAdapter(foodAdapter);
    }

    public void listMenuCategory(int table){
        Call<List<OrderDetail>> callRepo = service.listOrderTable(table);
        callRepo.enqueue(new Callback<List<OrderDetail>>() {
            @Override
            public void onResponse(Call<List<OrderDetail>> call, Response<List<OrderDetail>> response) {
                food = response.body();
                if(food.size() > 0){
                    listOrder();
                }
            }
            @Override
            public void onFailure(Call<List<OrderDetail>> call, Throwable t) {

            }
        });
    }

    public static void recreate(){
        foodAdapter.notifyDataSetChanged();
    }
}
