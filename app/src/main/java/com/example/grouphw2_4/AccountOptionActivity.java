package com.example.grouphw2_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javaapplication1.Account;

public class AccountOptionActivity extends AppCompatActivity {
    Button newAccButton;
    Button listAccButton;
    List<String> accInfo;
    List<Account> accountList;
    List<String> accountNames;
    int numOfActivity = 0;
    TextView test;
    Account acc;
    Account acc2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_option);

        Intent intent = getIntent();
        accountList = (List<Account>) intent.getSerializableExtra("accountList");

        test = (TextView) findViewById(R.id.textView);


        //accInfo.get(0),accInfo.get(1),accInfo.get(2),accInfo.get(3),accInfo.get(4),accInfo.get(5)
        listAccButton = (Button) findViewById(R.id.ListAccountButton);
        listAccButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListAccountActivity();
            }
        });
        newAccButton = (Button) findViewById(R.id.CreateAccountButton);
        newAccButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test.setText(Integer.toString(numOfActivity));

                openNewAccActivity();
            }
        });
    }
    public void openNewAccActivity(){
        Intent intent = new Intent(this, NewAccountActivity.class);
        startActivityForResult(intent,1);

        numOfActivity++;

    }
    public void openListAccountActivity(){
        Intent intent2 = new Intent(this, ListAccountActivity.class);

        intent2.putExtra("accountList", (Serializable) accountList);

        startActivityForResult(intent2,5);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                accInfo = data.getStringArrayListExtra("accountInfo");
                accountList.add(new Account(accInfo.get(0),accInfo.get(1),accInfo.get(2),accInfo.get(3),accInfo.get(4),accInfo.get(5)));

                Intent intent = new Intent(this,AccountOptionActivity.class);
                intent.putExtra("accList",(Serializable) accountList);
                setResult(RESULT_OK,intent);

            }
        }
        if(requestCode == 5){
            if(resultCode == RESULT_OK){
                accountList = (List<Account>) data.getSerializableExtra("accList");

                Intent intent = new Intent(this,AccountOptionActivity.class);
                intent.putExtra("accList",(Serializable) accountList);
                setResult(RESULT_OK,intent);

            }
        }
    }
}
