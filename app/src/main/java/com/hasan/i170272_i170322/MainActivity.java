package com.hasan.i170272_i170322;

//<<<<<<< HEAD
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.google.firebase.database.ChildEventListener;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

//public class MainActivity extends AppCompatActivity {
//    RecyclerView rv;
//    Button add;
//    List<Contact> contacts;
//    DatabaseReference dbref;
//    MyRvAdapter adapter;
//=======
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth authentication;
    FirebaseUser usr;
//>>>>>>> b1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//<<<<<<< HEAD
//        contacts=new ArrayList<>();

//        dbref= FirebaseDatabase.getInstance()
//                .getReference("contacts");
//        add=findViewById(R.id.add);
//
//        rv=findViewById(R.id.rv);
//        RecyclerView.LayoutManager lm= new LinearLayoutManager(this);
//        rv.setLayoutManager(lm);
//        adapter=new MyRvAdapter(contacts,this);
//        rv.setAdapter(adapter);

//
//        add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this,Second.class));
//            }
//        });s

//        dbref.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                contacts.add(dataSnapshot.getValue(Contact.class));
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//=======
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
//>>>>>>> b1
    }
}