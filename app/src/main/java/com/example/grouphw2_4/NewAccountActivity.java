package com.example.grouphw2_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class NewAccountActivity extends AppCompatActivity {
    Button createAccButton;
    EditText accNameET;
    EditText indusET;
    EditText cityET;
    EditText stateET;
    EditText phoneET;
    EditText ownerNameET;
    List<String> accountInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);

        createAccButton = (Button) findViewById(R.id.newAccInfoButton);
        createAccButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openAccOptionActivity();
            }
        });

    }


    public void openAccOptionActivity(){
        accNameET = (EditText) findViewById(R.id.accNameEditText);
        indusET = (EditText) findViewById(R.id.indusEditText);
        cityET = (EditText) findViewById(R.id.cityEditText);
        stateET = (EditText) findViewById(R.id.stateEditText);
        phoneET = (EditText) findViewById(R.id.phoneEditText);
        ownerNameET = (EditText) findViewById(R.id.nameEditText);
        String accName = accNameET.getText().toString();
        String indus = indusET.getText().toString();
        String city = cityET.getText().toString();
        String state = stateET.getText().toString();
        String phone = phoneET.getText().toString();
        String ownerName = ownerNameET.getText().toString();
        accountInfo = new ArrayList<String>();
        accountInfo.add(accName);
        accountInfo.add(indus);
        accountInfo.add(city);
        accountInfo.add(state);
        accountInfo.add(phone);
        accountInfo.add(ownerName);
        Intent intent = new Intent(this, AccountOptionActivity.class);
        intent.putStringArrayListExtra("accountInfo",(ArrayList<String>) accountInfo);
        setResult(RESULT_OK, intent);
        finish();
    }

}
