package com.example.pc.posresto;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pc.posresto.fragments.FirstFragment;
import com.example.pc.posresto.fragments.SecondFragment;

import org.w3c.dom.Text;

import java.util.List;

public class OrderActivity extends AppCompatActivity implements Communicate {

    private Toolbar toolbar;
    public TextView tableNo;
    public Button confirmBtn, payBtn;
    public static String tableNum;
    public List<OrderActivity> food;

    //fragments
    FirstFragment f1;
    SecondFragment f2;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);

        tableNo = (TextView) findViewById(R.id.table_number);
        confirmBtn = (Button) findViewById(R.id.confirm_order);
        payBtn = (Button) findViewById(R.id.payment_order);
        toolbar = (Toolbar) findViewById(R.id.toolbar_1);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        f1 = new FirstFragment();
        f2 = new SecondFragment();

        //intent
        Intent intent = getIntent();
        tableNum = intent.getStringExtra("Table No");

        tableNo.setText(tableNum);

        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.first_container, f1, "Fg_1");
        transaction.add(R.id.second_container, f2, "Fg_2");

        transaction.commit();

        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // pay activity
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void sendData() {
        //to pass data between fragments
    }
}
