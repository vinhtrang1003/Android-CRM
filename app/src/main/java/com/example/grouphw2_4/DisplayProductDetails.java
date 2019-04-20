package com.example.grouphw2_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import javaapplication1.Account;

public class DisplayProductDetails extends AppCompatActivity
{
    List<Account> accountList;
    int productPosition;
    int accPos;
    TextView Name,ID,Price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_product_details);

        Intent intent = getIntent();
        accountList = (List<Account>) intent.getSerializableExtra("accList");
        accPos = getIntent().getExtras().getInt("accPos");
        productPosition = getIntent().getExtras().getInt("productPosition");

        Name = (TextView) findViewById(R.id.tvProductName);
        ID = (TextView) findViewById(R.id.tvProductID);

        Name.setText(accountList.get(accPos).getProductsList().get(productPosition).getpname());
        ID.setText(accountList.get(accPos).getProductsList().get(productPosition).getpid());
    }
}
