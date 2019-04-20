package com.example.grouphw2_4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

import javaapplication1.Account;

public class FileActivity extends AppCompatActivity {
    Button saveButton;
    Button loadButton;
    List<Account> accountList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        Intent intent = getIntent();
        accountList = (List<Account>) intent.getSerializableExtra("accountList");


        saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSaveActivity();
            }
        });

        loadButton = (Button) findViewById(R.id.loadButton);
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoadActivity();
            }
        });
    }
    public void openSaveActivity(){
        String filename = "myfile";
        FileOutputStream outputStream;
        ObjectOutputStream objectOutPutString;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            objectOutPutString = new ObjectOutputStream(outputStream);
            objectOutPutString.writeObject(accountList);
            outputStream.close();
            objectOutPutString.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openLoadActivity(){

        try {
            Context context = this;
            FileInputStream fis = context.openFileInput("myfile");
            ObjectInputStream is = new ObjectInputStream(fis);
            accountList = (List<Account>) is.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result",(Serializable)accountList);
        setResult(MainActivity.RESULT_OK,returnIntent);
        finish();
    }



}
