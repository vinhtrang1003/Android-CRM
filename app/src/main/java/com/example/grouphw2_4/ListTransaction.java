package com.example.grouphw2_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import javaapplication1.Account;
import javaapplication1.Products;
import javaapplication1.Transaction;

public class ListTransaction extends AppCompatActivity implements ListTransactionRecylerViewAdapter.ItemClickListener {
    int accPosition;
    List<Account> accList;
    ListTransactionRecylerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_transaction);

        Intent intent = getIntent();
        accList = (List<Account>) intent.getSerializableExtra("accountList");
        accPosition = getIntent().getExtras().getInt("accPosition");;

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.ListTran);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListTransactionRecylerViewAdapter(this, accList, accPosition);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(View view, int position) {

    }
}
