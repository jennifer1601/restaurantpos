package com.example.pc.posresto.api.Service;


import com.example.pc.posresto.Model.Menu;
import com.example.pc.posresto.Model.Order;
import com.example.pc.posresto.Model.OrderDetail;
import com.example.pc.posresto.Model.Table;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Services {
    @GET("/table")
    Call<List<Table>> listTable();

    @GET("/table/{status}")
    Call<List<Table>> listTableStatus(@Path("status") int status);

    @POST("/table")
    Call<List<Table>> addTable(@Body Table t);

    @GET("/menu")
    Call<List<Menu>> listMenu();

    @GET("/menu/{category}")
    Call<List<Menu>> listMenuCategory(@Path("category") String category);

    @GET("/order/{table_id}")
    Call<List<OrderDetail>> listOrderTable(@Path("table_id") int table_id);

    @GET("/order-detail/{order_id}")
    Call<List<OrderDetail>> listOrderDetail(@Path("order_id") int order_id);
}
