package com.hasan.i170272_i170322;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class MyMessageAdapter extends RecyclerView.Adapter<MyMessageAdapter.MyViewHolder> {
    List<Msg> mChat;
    Context c;
//    String usr, email,
    String img;

    FirebaseUser fuser;

    public static final int INCOMING=0, OUTGOING=1;

    public MyMessageAdapter(List<Msg> ls, Context c, /*String email,*/ String url) {
        this.c=c;
        this.mChat=ls;
//        this.email=email;
        this.img=url;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType==OUTGOING){
            View itemrow= LayoutInflater.from(c).inflate(R.layout.rightchat,
                    parent,false);
            return new  MyViewHolder(itemrow);
        }
//        else if (viewType==INCOMING){
            View itemrow= LayoutInflater.from(c).inflate(R.layout.leftchat,
                    parent,false);
            return new  MyViewHolder(itemrow);
//        }

    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        Msg msg=mChat.get(position);
        holder.show_message.setText(msg.getMsg());

//        if (imgURL)
        Picasso.get().load(img).into(holder.profile_image);
    }

    @Override
    public int getItemCount() {
        return mChat.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView show_message;
        CircleImageView profile_image;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            show_message=itemView.findViewById(R.id.show_message);
            profile_image=itemView.findViewById(R.id.profile_image);
        }
    }

    @Override
    public int getItemViewType(int position) {

        fuser= FirebaseAuth.getInstance().getCurrentUser();

        if (mChat.get(position).getSender().equals(fuser.getUid()))
            return OUTGOING;
        return INCOMING;
//        return super.getItemViewType(position);
    }
}
