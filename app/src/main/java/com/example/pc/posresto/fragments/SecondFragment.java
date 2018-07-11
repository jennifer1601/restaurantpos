package com.example.pc.posresto.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pc.posresto.Adapter.MenuAdapter;
import com.example.pc.posresto.MainActivity;
import com.example.pc.posresto.Model.Menu;
import com.example.pc.posresto.R;
import com.example.pc.posresto.api.API;
import com.example.pc.posresto.api.Service.Services;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondFragment extends Fragment {

    private RecyclerView menuListrView;

    private Services service;

    private TextView all, fav, food, beverages, dessert;
    private List<Menu> menu;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_second, container, false);

        View view = inflater.inflate(R.layout.fragment_second, container, false);
        service = API.getClient().create(Services.class);

        all = (TextView) getActivity().findViewById(R.id.all_menu);
        food = (TextView) getActivity().findViewById(R.id.food_menu);
        beverages = (TextView) getActivity().findViewById(R.id.beverages_menu);
        fav = (TextView) getActivity().findViewById(R.id.favorite_menu);
        dessert = (TextView) getActivity().findViewById(R.id.dessert_menu);

        menuListrView = (RecyclerView) view.findViewById(R.id.menu_list_rView);
        menuListrView.setHasFixedSize(true);

        menuListrView.setLayoutManager(new GridLayoutManager(getContext(),3));


        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listMenu();
            }
        });
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listMenuCategory("fav");
            }
        });
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listMenuCategory("1");
            }
        });
        beverages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listMenuCategory("2");
            }
        });
        dessert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listMenuCategory("3");
            }
        });

        listMenu();
        return  view;
    }
    private void showMenu(){
        MenuAdapter menuAdapter = new MenuAdapter(menu, getActivity());
        menuListrView.setAdapter(menuAdapter);
        menuAdapter.notifyDataSetChanged();
    }

    private void listMenu(){
        Call<List<Menu>> callRepo = service.listMenu();
        callRepo.enqueue(new Callback<List<Menu>>() {
            @Override
            public void onResponse(Call<List<Menu>> call, Response<List<Menu>> response) {
                menu = response.body();
                showMenu();
            }

            @Override
            public void onFailure(Call<List<Menu>> call, Throwable t) {

            }
        });
    }

    private void listMenuCategory(String category){
        Call<List<Menu>> callRepo = service.listMenuCategory(category);
        callRepo.enqueue(new Callback<List<Menu>>() {
            @Override
            public void onResponse(Call<List<Menu>> call, Response<List<Menu>> response) {
                menu = response.body();
                showMenu();
            }

            @Override
            public void onFailure(Call<List<Menu>> call, Throwable t) {

            }
        });
    }
}
