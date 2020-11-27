package com.hasan.i170272_i170322;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    AppCompatEditText email, pwd;
    AppCompatButton loginBtn;
    FirebaseUser usr;
    FirebaseAuth authentication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email=findViewById(R.id.loginUsername);
        pwd=findViewById(R.id.loginPassword);
        loginBtn=findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                authentication.signInWithEmailAndPassword(
                        email.getText().toString(),
                        pwd.getText().toString()
                        );
                usr=authentication.getCurrentUser();
//                Intent intent=new Intent(Login.this, )
            }
        });
    }
}