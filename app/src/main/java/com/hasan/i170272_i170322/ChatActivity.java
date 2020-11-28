package com.hasan.i170272_i170322;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

//    TextView uname;
    EditText chatText;
    ImageView chatSend;

    FirebaseUser fuser;
    DatabaseReference dbref;

    Intent i;

    MyMessageAdapter msgAda;
    List<Msg> mChat;
    RecyclerView chatRv;

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

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Contact user=dataSnapshot.getValue(Contact.class);

//                readMessages(fuser.getUid(),/*userid,*/ user.getDpUri());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        chatRv=findViewById(R.id.chatRv);
        chatRv.setHasFixedSize(true);
        LinearLayoutManager linlyman=new LinearLayoutManager(getApplicationContext());
        linlyman.setStackFromEnd(true);
        chatRv.setLayoutManager(linlyman);
        chatRv.setAdapter(msgAda);


        chatText=findViewById(R.id.chatText);
        chatSend=findViewById(R.id.chatSend);
        chatSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg=chatText.getText().toString();

//                if(uname==null) {
//                    Toast.makeText(
//                            ChatActivity.this,
//                            "OOOOOO",
//                            Toast.LENGTH_LONG
//                    ).show();
//                }
//                else{
//                    Toast.makeText(
//                            ChatActivity.this,
//                            uname,
//                            Toast.LENGTH_LONG
//                    ).show();
//                }
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

    private void readMessages(final String myId,/* final String userID,*/ final String imageUrl){
        mChat=new ArrayList<>();

        dbref=FirebaseDatabase.getInstance().getReference("chats");

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mChat.clear();

                for (DataSnapshot s: dataSnapshot.getChildren()){
                    Msg newMsg=s.getValue(Msg.class);
//                    if (newMsg.getReceiver().equals(myId) && newMsg.getSender().equals(userID))
                    mChat.add(newMsg);
                }

                msgAda=new MyMessageAdapter(mChat, ChatActivity.this, imageUrl);
                chatRv.setAdapter(msgAda);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
    }
}