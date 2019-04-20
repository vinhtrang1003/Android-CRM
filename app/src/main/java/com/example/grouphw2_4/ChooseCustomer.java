package com.example.grouphw2_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.io.Serializable;
import java.util.List;

import javaapplication1.Account;
import javaapplication1.Contact;

public class ChooseCustomer extends AppCompatActivity implements ListContactRecylerViewAdapter.ItemClickListener {
    ListContactRecylerViewAdapter adapter;
    List<Account> accList;
    int accPosition;
    List<Contact> contList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_customer);

        Intent intent = getIntent();
        accList = (List<Account>) intent.getSerializableExtra("accountList");
        accPosition = getIntent().getExtras().getInt("accPosition");;

        contList = accList.get(accPosition).getContactLst();

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvCustomerList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListContactRecylerViewAdapter(this, accList, accPosition);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position)
    {
        Intent intent2 = new Intent(this, NewTransaction.class);
        intent2.putExtra("accPos",(int) accPosition);
        intent2.putExtra("accList", (Serializable) accList);
        setResult(RESULT_OK,intent2);
        finish();

    }
}

