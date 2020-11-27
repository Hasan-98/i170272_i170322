package com.hasan.i170272_i170322;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegOrLoginActivity extends AppCompatActivity {

    AppCompatButton reg, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_or_login);

        reg=findViewById(R.id.regButton);
        login=findViewById(R.id.loginButton);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(RegOrLoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RegOrLoginActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}