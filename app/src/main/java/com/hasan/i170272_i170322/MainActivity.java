package com.hasan.i170272_i170322;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth authentication;
    FirebaseUser usr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        authentication= FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        usr=authentication.getCurrentUser();

        if (usr==null){
            Intent intent=new Intent(this, RegOrLoginActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(
                    this,
                    "User Available: "+usr.getUid()+" "+usr.getEmail(),
                    Toast.LENGTH_LONG
                    ).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        authentication.signOut();
    }
}