package com.example.grouphw2_4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javaapplication1.Account;
import javaapplication1.Products;



public class NewProduct extends AppCompatActivity
{
    Button CreateProductButton;
    EditText ProductNameET;
    EditText ProductIDET;
    EditText ProductPriceET;
    List<String> ProductInfo;
    List<Account> accList;
    int accPosition;


    Products ProductAdded;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product);

        Intent intent = getIntent();
        accList = (List<Account>) intent.getSerializableExtra("accountList");
        accPosition = getIntent().getExtras().getInt("accPosition");


        CreateProductButton = (Button) findViewById(R.id.CreateProductButton);
        CreateProductButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openAccMenuActivity();
            }
        });


    }


    // Finish adding product going back to AccountMenu
    private void openAccMenuActivity()
    {

        ProductNameET = (EditText) findViewById(R.id.ProductName);
        ProductIDET = (EditText) findViewById(R.id.ProductID);
        ProductPriceET = (EditText) findViewById(R.id.PPrice);

        String dp= ProductPriceET.getText().toString();
        Double Price = Double.parseDouble(dp);
        String ProductName = ProductNameET.getText().toString();
        String ProductID = ProductIDET.getText().toString();

        Products p = new Products(ProductName,ProductID,Price);
        accList.get(accPosition).getProductsList().add(p);


        // Passing ProductAdded back to AccountMenu

        Intent intent = new Intent(this, AccountSubOptionActivity.class);

        intent.putExtra("accList",(Serializable) accList);
        intent.putExtra("accPos",(Serializable) accPosition);

        setResult(RESULT_OK,intent);
        finish();


    }


}

