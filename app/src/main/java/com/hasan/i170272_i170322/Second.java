package com.hasan.i170272_i170322;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Second extends AppCompatActivity {
    EditText name,phno,email;
    Button ok;

//    FirebaseDatabase db;
    DatabaseReference dbref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        dbref=FirebaseDatabase.getInstance()
                .getReference("contacts");
        name=findViewById(R.id.name);
        phno=findViewById(R.id.phno);
        email=findViewById(R.id.email);
        ok=findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbref.push().setValue(
                        new Contact(
                        name.getText().toString(),
                        phno.getText().toString(),
                        email.getText().toString()
                        )
                );
                finish();
            }
        });
    }
}