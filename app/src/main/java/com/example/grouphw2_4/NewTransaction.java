package com.example.grouphw2_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.Serializable;
import java.util.List;

import javaapplication1.Account;
import javaapplication1.Contact;
import javaapplication1.Products;
import javaapplication1.Transaction;

public class NewTransaction extends AppCompatActivity {

    EditText TID;
    EditText p;
    EditText c;
    EditText q;


    List<Account> accList;
    int accPosition;
    Button ChooseCustomer;
    Button ChooseProduct;
    Button CreateTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_transaction);

        Intent intent = getIntent();
        accList = (List<Account>) intent.getSerializableExtra("accountList");
        accPosition = getIntent().getExtras().getInt("accPosition");

        // Choose Customer button called ChooseCustomerActivity
        ChooseCustomer = (Button) findViewById(R.id.ChooseCustomer);
        ChooseCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChooseCustomerActivity();
            }
        });

        // Choose Product button called ChooseProductActivity
        ChooseProduct = (Button) findViewById(R.id.ChooseProduct);
        ChooseProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChooseProductActivity();
            }
        });

        CreateTransaction = (Button) findViewById(R.id.CreateTransactionButton);
        CreateTransaction.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openCreateTransactionActivity();
            }
        });

    }

    public void openChooseCustomerActivity() {
        Intent intent = new Intent(this, ChooseCustomer.class);
        intent.putExtra("accPosition", (int) accPosition);
        intent.putExtra("accountList", (Serializable) accList);
        startActivityForResult(intent, 15);
    }

    public void openChooseProductActivity() {
        Intent intent = new Intent(this, ListProduct.class);
        intent.putExtra("accPosition", (int) accPosition);
        intent.putExtra("accountList", (Serializable) accList);
        startActivityForResult(intent, 16);
    }

    public void openCreateTransactionActivity()
    {


        TID = (EditText) findViewById(R.id.TID);
        p = (EditText) findViewById(R.id.ProductNumber);
        c = (EditText) findViewById(R.id.CustomerNumber);
        q = (EditText) findViewById(R.id.TQ);

        String pn= p.getText().toString();
        int productnum=Integer.parseInt(pn);

        String cn= c.getText().toString();
        int customernum=Integer.parseInt(cn);

        String qn= q.getText().toString();
        int quality=Integer.parseInt(qn);


        String tid = TID.getText().toString();

        Contact Customer = accList.get(accPosition).getContact(customernum);
        Products P = accList.get(accPosition).getProduct(productnum);

        Transaction T = new Transaction("Null");
        T.CreateTransaction(Customer, P, tid, quality);
        accList.get(accPosition).getTransactionList().add(T);



        Intent intent = new Intent(this, AccountSubOptionActivity.class);
        intent.putExtra("accList",(Serializable) accList);
        intent.putExtra("accPos",(Serializable) accPosition);
        setResult(RESULT_OK,intent);
        finish();
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 15) {
            if (resultCode == RESULT_OK) {
                accList = (List<Account>) data.getSerializableExtra("accList");
                accPosition = getIntent().getExtras().getInt("accPos");

                Intent intent = new Intent(this, NewTransaction.class);
                intent.putExtra("accList", (Serializable) accList);
                setResult(RESULT_OK, intent);
                //finish();
            }
        }
        if (requestCode == 16) {
            if (resultCode == RESULT_OK) {
                accList = (List<Account>) data.getSerializableExtra("accList");
                accPosition = getIntent().getExtras().getInt("accPos");

                Intent intent = new Intent(this, NewTransaction.class);
                intent.putExtra("accList", (Serializable) accList);

                setResult(RESULT_OK, intent);
                //finish();
            }
        }


    }
}
