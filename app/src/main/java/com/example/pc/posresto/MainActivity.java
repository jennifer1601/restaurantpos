package com.example.pc.posresto;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.pc.posresto.Adapter.TableAdapter;
import com.example.pc.posresto.Model.Table;
import com.example.pc.posresto.api.API;
import com.example.pc.posresto.api.Service.Services;
import com.example.pc.posresto.fragments.FirstFragment;
import com.example.pc.posresto.fragments.SecondFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  {

    private Toolbar toolbar;
    private RecyclerView tableStatusRview;

    private TextView reserved, open, filled, all;

    private Services service;

//    private Table[] table = new Table[]{
//            new Table(1, "asd",0,0,0),
//            new Table(1, "asd",0,0,0),
//            new Table(1, "asd",0,0,0),
//            new Table(1, "asd",0,0,0),
//            new Table(1, "asd",0,0,0),
//            new Table(1, "asd",0,0,0),
//            new Table(1, "asd",0,0,0),
//            new Table(1, "asd",0,0,0),
//            new Table(1, "asd",0,0,0),
//    };
    private List<Table> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);

        service = API.getClient().create(Services.class);

        reserved = findViewById(R.id.reserved);
        open = findViewById(R.id.open);
        filled = findViewById(R.id.filled);
        all = findViewById(R.id.all);



        toolbar = (Toolbar) findViewById(R.id.toolbar_1);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        tableStatusRview = (RecyclerView)findViewById(R.id.table_status_rView);
        tableStatusRview.setHasFixedSize(true);

        tableStatusRview.setLayoutManager(new GridLayoutManager(this,4));

        listTable();


        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listTableStatus(0);
            }
        });
        filled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listTableStatus(1);
            }
        });
        reserved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listTableStatus(2);
            }
        });
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listTable();
            }
        });
    }

    private void showTable(){
        TableAdapter tableAdapter = new TableAdapter(list, this);
        tableStatusRview.setAdapter(tableAdapter);
    }

    private void listTable(){
        Call<List<Table>> callRepo = service.listTable();
        callRepo.enqueue(new Callback<List<Table>>() {
            @Override
            public void onResponse(Call<List<Table>> call, Response<List<Table>> response) {
                list = response.body();
                showTable();
            }

            @Override
            public void onFailure(Call<List<Table>> call, Throwable t) {

            }
        });
    }

    private void listTableStatus(int status){
        Call<List<Table>> callRepo = service.listTableStatus(status);
        callRepo.enqueue(new Callback<List<Table>>() {
            @Override
            public void onResponse(Call<List<Table>> call, Response<List<Table>> response) {
                list = response.body();
                showTable();
            }

            @Override
            public void onFailure(Call<List<Table>> call, Throwable t) {

            }
        });
    }
}
