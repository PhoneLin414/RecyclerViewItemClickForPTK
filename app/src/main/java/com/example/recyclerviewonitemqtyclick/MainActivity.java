package com.example.recyclerviewonitemqtyclick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClick{

    TextView txtTotalQty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTotalQty = findViewById(R.id.txtTotalQty);

        Data data = new Data();
        data.id = "1";
        data.qty = 1;

        List<Data> dataList = new ArrayList<>();
        dataList.add(data);

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this,dataList,this);

        RecyclerView recyclerView = findViewById(R.id.rv);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(recyclerAdapter);

    }

    @Override
    public void btnPlusClick(String totalQty) {
        txtTotalQty.setText(totalQty);
    }

    @Override
    public void btnMinusClick(String totalQty) {
        txtTotalQty.setText(totalQty);
    }
}
