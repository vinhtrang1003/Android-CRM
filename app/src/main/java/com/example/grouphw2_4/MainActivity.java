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
import javaapplication1.Contact;
import javaapplication1.Products;
import javaapplication1.Transaction;

public class MainActivity extends AppCompatActivity  {
    Button accountButton;
    Button fileButton;
    List<Account> accountList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accountList = new ArrayList<Account>();


        Contact a = new Contact("a","mr","5101234587","a@gmail.com");
        Contact b = new Contact("b","mr","5101236542","b@gmail.com");
        Products p = new Products("PC1","01", 599.99);
        Products d = new Products("PC2","02", 699.99);
        Products e = new Products("PC3","03", 799.99);

        Account acc = new Account("Tung Account", "tech", "Hayward", "CA", "510-543-4354","Tung Nguyen" );
        acc.getContactLst().add(a);
        acc.getContactLst().add(b);
        acc.getProductsList().add(p);
        acc.getProductsList().add(d);
        acc.getProductsList().add(e);

        Account acc2 = new Account("Vinh Account", "CS", "Hayward", "CA", "510-600-9094","Vinh Trang" );
        acc2.getContactLst().add(a);
        acc2.getContactLst().add(b);
        acc2.getProductsList().add(p);
        acc2.getProductsList().add(d);
        acc2.getProductsList().add(e);

        accountList.add(acc);
        accountList.add(acc2);

        accountButton = (Button) findViewById(R.id.AccountButton);
        accountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAccOptionActivity();
            }
        });

        fileButton = (Button) findViewById(R.id.fileButton);
        fileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileOptionActivity();
            }
        });


    }

    public void openAccOptionActivity(){
        Intent intent = new Intent(this, AccountOptionActivity.class);

        intent.putExtra("accountList", (Serializable) accountList);
        startActivityForResult(intent,6);
    }

    public void openFileOptionActivity(){
        Intent intent = new Intent(this, FileActivity.class);

        intent.putExtra("accountList", (Serializable) accountList);
        startActivityForResult(intent,9);
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(requestCode == 6){
            if(resultCode == RESULT_OK)
            {
                accountList = (List<Account>) data.getSerializableExtra("accList");

                Intent intent = new Intent(this,MainActivity.class);
                intent.putExtra("accList",(Serializable) accountList);
                setResult(RESULT_OK,intent);

            }
        }
        if(requestCode == 9){
            if(resultCode == RESULT_OK)
            {
                accountList = (List<Account>) data.getSerializableExtra("result");

            }
        }
    }


}
