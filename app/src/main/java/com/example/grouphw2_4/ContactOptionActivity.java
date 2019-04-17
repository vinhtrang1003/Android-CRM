package com.example.grouphw2_4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.List;

import javaapplication1.Account;

public class ContactOptionActivity extends Activity {
    Button newContactButton;
    Button listContactButton;
    List<Account> accList;
    List<String> contInfo;
    int accPosition;
    TextView testing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_option);
        Intent intent = getIntent();
        accPosition = getIntent().getExtras().getInt("accPosition");
        accList = (List<Account>) intent.getSerializableExtra("accountList");

        testing = (TextView) findViewById(R.id.testcont);
        testing.setText(accList.get(accPosition).getAccountName());

        newContactButton = (Button) findViewById(R.id.newContactButton);
        newContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewContactActivity();
            }
        });

        listContactButton = (Button) findViewById(R.id.listContactButton);
        listContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListContactActivity();
            }
        });

    }
    public void openNewContactActivity(){
        Intent intent = new Intent(this, NewContactActivity.class);
        startActivityForResult(intent,2);

    }

    public void openListContactActivity(){
        Intent intent = new Intent(this, ListContactActivity.class);
        intent.putExtra("accPosition",(int) accPosition);
        intent.putExtra("accountList", (Serializable) accList);
        startActivity(intent);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2) {
            if(resultCode == RESULT_OK) {
                contInfo = data.getStringArrayListExtra("contactInfo");
                accList.get(accPosition).newContact(contInfo.get(0),contInfo.get(1),contInfo.get(2),contInfo.get(3));

                Intent intent = new Intent(this,ContactOptionActivity.class);
                intent.putExtra("accList",(Serializable) accList);
                setResult(RESULT_OK,intent);
                //finish();
            }
        }
    }
}
