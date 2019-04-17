package com.example.grouphw2_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import javaapplication1.Account;
import javaapplication1.Contact;

public class DisplayContactDetailsActivity extends AppCompatActivity {
    List<Account> accountList;
    int contactPosition;
    int accPos;
    TextView name, title,phone,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact_details);

        Intent intent = getIntent();
        accountList = (List<Account>) intent.getSerializableExtra("accList");
        accPos = getIntent().getExtras().getInt("accPos");
        contactPosition = getIntent().getExtras().getInt("contactPosition");

        name = (TextView) findViewById(R.id.tvContactName);
        title = (TextView) findViewById(R.id.tvContactTitle);
        phone = (TextView) findViewById(R.id.tvContactPhone);
        email = (TextView) findViewById(R.id.tvContactEmail);

        name.setText(accountList.get(accPos).getContactLst().get(contactPosition).getName());
        title.setText(accountList.get(accPos).getContactLst().get(contactPosition).getTitle());
        phone.setText(accountList.get(accPos).getContactLst().get(contactPosition).getPhone());
        email.setText(accountList.get(accPos).getContactLst().get(contactPosition).getEmail());
    }
}
