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

public class MainActivity extends AppCompatActivity  {
    Button accountButton;
    List<Account> accountList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accountList = new ArrayList<Account>();

        Account acc = new Account("Tung Account", "tech", "Hayward", "CA", "510-543-4354","Tung Nguyen" );
        Account acc2 = new Account("Vinh Account", "CS", "Hayward", "CA", "510-600-9094","Vinh Trang" );

        accountList.add(acc);
        accountList.add(acc2);

        accountButton = (Button) findViewById(R.id.AccountButton);
        accountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAccOptionActivity();
            }
        });


    }

    public void openAccOptionActivity(){
        Intent intent = new Intent(this, AccountOptionActivity.class);

        intent.putExtra("accountList", (Serializable) accountList);
        startActivityForResult(intent,6);
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
    }


}
