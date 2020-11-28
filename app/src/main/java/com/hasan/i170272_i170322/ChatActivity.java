package com.hasan.i170272_i170322;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class ChatActivity extends AppCompatActivity {

//    TextView uname;
    EditText chatText;
    ImageView chatSend;
    RecyclerView chatRv;

    FirebaseUser fuser;
    DatabaseReference dbref;

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        setContentView(R.layout.activity_chat);

        i=getIntent();
        final String myCname=i.getStringExtra("rname");

        fuser= FirebaseAuth.getInstance().getCurrentUser();
        final String uname=i.getStringExtra("uname");
        dbref= FirebaseDatabase.getInstance().getReference("chats").child(myCname);

//        dbref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                Contact user=dataSnapshot.getValue(Contact.class);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        })

        chatRv=findViewById(R.id.chatRv);
        chatText=findViewById(R.id.chatText);
        chatSend=findViewById(R.id.chatSend);
        chatSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg=chatText.getText().toString();

                if(uname==null) {
                    Toast.makeText(
                            ChatActivity.this,
                            "OOOOOO",
                            Toast.LENGTH_LONG
                    ).show();
                }
                else{
                    Toast.makeText(
                            ChatActivity.this,
                            uname,
                            Toast.LENGTH_LONG
                    ).show();
                }
                sendMessage(uname, msg, myCname);
            }
        });


    }

    private void sendMessage(String sender, String msg, String rcvr){
        HashMap<String, Object> hmap=new HashMap<>();
        hmap.put("sender",sender);
        hmap.put("message",msg);
        hmap.put("receiver",rcvr);

        DatabaseReference dbref=FirebaseDatabase.getInstance().getReference();
        dbref.child("chats").push().setValue(hmap);

    }
}