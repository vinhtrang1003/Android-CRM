package com.example.grouphw2_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javaapplication1.Account;
import javaapplication1.Products;

public class AccountSubOptionActivity extends AppCompatActivity {
    Account acc;
    Account acc2;
    List<Account> accList;
    List<String> ProductInfo;
    List<Products> ProductList;
    Button contactButton;
    Button NewProductButton;
    Button ListProductsButton;
    Button NewTransactionButton;
    Button ListTransactionButton;

    int accPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_sub_option);

        Intent intent = getIntent();
        accPosition = getIntent().getExtras().getInt("accPosition");
        accList = (List<Account>) intent.getSerializableExtra("accountList");
        ProductList = accList.get(accPosition).getProductsList();

        contactButton = (Button) findViewById(R.id.contactButton);
        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContactActivity();
            }
        });

        // New Product button called NewProductActivity
        NewProductButton = (Button) findViewById(R.id.NewProductButton);
        NewProductButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openNewProductActivity();
            }
        });

        // List Product button called LissProductActivity
        ListProductsButton = (Button) findViewById(R.id.ListProductsButton);
        ListProductsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openListProductActivity();
            }
        });

        // New Transaction button called openNewTransactionActivity
        NewTransactionButton = (Button) findViewById(R.id.NewTransactionButton);
        NewTransactionButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openNewTransactionActivity();
            }
        });


        // List Transaction button called openListTransactionActivity
        ListTransactionButton = (Button) findViewById(R.id.ListTransactionButton);
        ListTransactionButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openListTransactionActivity();
            }
        });



    }
    public void openContactActivity(){
        Intent intent = new Intent(this, ContactOptionActivity.class);
        intent.putExtra("accPosition",(int) accPosition);
        intent.putExtra("accountList", (Serializable) accList);
        startActivityForResult(intent,4);
    }

    public void openNewProductActivity(){
        Intent intent = new Intent(this, NewProduct.class);
        intent.putExtra("accPosition",(int) accPosition);
        intent.putExtra("accountList", (Serializable) accList);
        startActivityForResult(intent,9);
    }

    public void openListProductActivity()
    {
        Intent intent = new Intent(this, ListProduct.class);
        intent.putExtra("accPosition",(int) accPosition);
        intent.putExtra("accountList", (Serializable) accList);
        startActivity(intent);
    }

    public void openNewTransactionActivity(){
        Intent intent = new Intent(this, NewTransaction.class);
        intent.putExtra("accPosition",(int) accPosition);
        intent.putExtra("accountList", (Serializable) accList);
        startActivityForResult(intent,10);
    }

    public void openListTransactionActivity()
    {
        Intent intent = new Intent(this, ListTransaction.class);
        intent.putExtra("accPosition",(int) accPosition);
        intent.putExtra("accountList", (Serializable) accList);
        startActivity(intent);
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 4) {
            if(resultCode == RESULT_OK) {
                accList = (List<Account>) data.getSerializableExtra("accList");
                Intent intent = new Intent(this,AccountSubOptionActivity.class);
                intent.putExtra("accList",(Serializable) accList);
                setResult(RESULT_OK,intent);
                //finish();
            }
        }
        //new product result
        if (requestCode == 9) {
            if(resultCode == RESULT_OK) {
                accList = (List<Account>) data.getSerializableExtra("accList");
                Intent intent = new Intent(this,AccountSubOptionActivity.class);
                intent.putExtra("accList",(Serializable) accList);
                setResult(RESULT_OK,intent);
                //finish();
            }
        }
        //new Transaction result
        if (requestCode == 10) {
            if(resultCode == RESULT_OK) {
                accList = (List<Account>) data.getSerializableExtra("accList");
                Intent intent = new Intent(this,AccountSubOptionActivity.class);
                intent.putExtra("accList",(Serializable) accList);
                setResult(RESULT_OK,intent);
                //finish();
            }
        }


    }
}
