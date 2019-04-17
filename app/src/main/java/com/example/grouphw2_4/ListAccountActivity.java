package com.example.grouphw2_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import javaapplication1.Account;

public class ListAccountActivity extends AppCompatActivity implements ListAccountRecylerViewAdapter.ItemClickListener {
    List<Account> accList;
    TextView acc1;
    TextView acc2;
    TextView acc3;
    ListAccountRecylerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_account_activity);
        Intent intent = getIntent();
        accList = (List<Account>) intent.getSerializableExtra("accountList");

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvAnimals);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListAccountRecylerViewAdapter(this, accList);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(this, AccountSubOptionActivity.class);


        intent.putExtra("accPosition",(int) position);
        intent.putExtra("accountList", (Serializable) accList);
        startActivityForResult(intent,3);

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 3) {
            if(resultCode == RESULT_OK) {
                accList = (List<Account>) data.getSerializableExtra("accList");
                Intent intent = new Intent(this,ListAccountActivity.class);
                intent.putExtra("accList",(Serializable) accList);
                setResult(RESULT_OK,intent);
                finish();
            }
        }
    }
}
