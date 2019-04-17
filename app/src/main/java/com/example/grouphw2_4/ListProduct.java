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

public class ListProduct extends AppCompatActivity implements ListProductRecylerViewAdapter.ItemClickListener {
    int accPosition;
    List<Account> accList;
    List<Products> ProductsList;

    ListProductRecylerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);
        Intent intent = getIntent();

        // Try to hard code and display item 1 2 3
        accList = (List<Account>) intent.getSerializableExtra("accountList");
        accPosition = getIntent().getExtras().getInt("accPosition");;

        Products p = new Products("PC","01", 599.99);
        Products d = new Products("PC2","02", 599.99);
        Products e = new Products("PC3","03", 599.99);

        accList.get(accPosition).getProductsList().add(p);
        accList.get(accPosition).getProductsList().add(d);
        accList.get(accPosition).getProductsList().add(e);


        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvAnimals);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListProductRecylerViewAdapter(this, accList, accPosition);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onItemClick(View view, int position)
    {

    }
}