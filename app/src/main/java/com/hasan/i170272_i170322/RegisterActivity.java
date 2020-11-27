package com.hasan.i170272_i170322;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    AppCompatEditText uname, pwd;
    AppCompatButton registerButton;

    FirebaseAuth authentication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        authentication=FirebaseAuth.getInstance();

        registerButton=findViewById(R.id.registerButton);
        uname=findViewById(R.id.username);
        pwd=findViewById(R.id.password);

        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                authentication.createUserWithEmailAndPassword(
                        uname.getText().toString(),
                        pwd.getText().toString()
                )
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(
                                    RegisterActivity.this,
                                    "Registration Successfull !",
                                    Toast.LENGTH_LONG
                            ).show();
                            Toast.makeText(
                                    RegisterActivity.this,
                                    authentication.getCurrentUser().getUid(),
                                    Toast.LENGTH_LONG
                            ).show();

                            Intent intent=new Intent(RegisterActivity.this, HomeActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                })


                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(
                                RegisterActivity.this,
                                "Failed to create user: "+e.getMessage().toString(),
                                Toast.LENGTH_LONG
                        ).show();
                        Log.e("LoginActivity", "Failed Registration"+e.getMessage(), e);

                    }
                });
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user=authentication.getCurrentUser();

        if (user!=null){
            Toast.makeText(
                    RegisterActivity.this,
                    "Logged In With User: "+user.getUid(),
                    Toast.LENGTH_SHORT
            ).show();
        }

    }
}