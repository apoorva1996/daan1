package com.example.poonam.daan1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class user extends AppCompatActivity {
DatabaseHelper helper=new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void onSignUp(View v) {
        if (v.getId() == R.id.signup) {
            EditText name = (EditText) findViewById(R.id.name1);
            EditText email = (EditText) findViewById(R.id.email1);
            EditText aadhar = (EditText) findViewById(R.id.aadhar1);
            EditText address = (EditText) findViewById(R.id.address1);
            EditText password = (EditText) findViewById(R.id.pass1);
            EditText confirm_pass = (EditText) findViewById(R.id.pass2);

            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String aadharstr = aadhar.getText().toString();
            String addressstr = address.getText().toString();
            String passwordstr = password.getText().toString();
            String confirmstr = confirm_pass.getText().toString();

            if (!passwordstr.equals(confirmstr)) {
                Toast pass = Toast.makeText(user.this, "passwords don't match", Toast.LENGTH_SHORT);
                pass.show();
            }
            else
            {
                user_database userdb=new user_database();

                userdb.setName(namestr);
                userdb.setEmail(emailstr);
                userdb.setAadhar(aadharstr);
                userdb.setAddress(addressstr);
                userdb.setPassword(passwordstr);

                helper.insertContact(userdb);


            }

        }

    }}
