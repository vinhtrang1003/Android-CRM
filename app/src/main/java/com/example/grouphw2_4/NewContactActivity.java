package com.example.grouphw2_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class NewContactActivity extends AppCompatActivity {
    EditText contName;
    EditText contTitle;
    EditText contPhone;
    EditText contEmail;
    Button contCreateButton;
    List<String> contactInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        contCreateButton = (Button) findViewById(R.id.contactCreateButton);
        contCreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContactOptionActivity();
            }
        });
    }

    public void openContactOptionActivity(){

        contName = (EditText) findViewById(R.id.contactNameEditText);
        contTitle = (EditText) findViewById(R.id.contactTitleEditText);
        contPhone = (EditText) findViewById(R.id.contactPhoneEditText);
        contEmail = (EditText) findViewById(R.id.contactEmailEditText);
        String name = contName.getText().toString();
        String title = contTitle.getText().toString();
        String phone = contPhone.getText().toString();
        String email = contEmail.getText().toString();

        contactInfo = new ArrayList<String>();
        contactInfo.add(name);
        contactInfo.add(title);
        contactInfo.add(phone);
        contactInfo.add(email);

        Intent intent = new Intent(this, ContactOptionActivity.class);

        intent.putStringArrayListExtra("contactInfo",(ArrayList<String>) contactInfo);
        setResult(RESULT_OK,intent);
        finish();
    }
}
