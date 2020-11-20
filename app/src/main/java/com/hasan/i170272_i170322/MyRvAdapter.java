package com.hasan.i170272_i170322;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.MyViewHolder> {
    List<Contact> ls;
    Context c;
    public MyRvAdapter(List<Contact> ls, Context c) {
        this.c=c;
        this.ls=ls;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemrow= LayoutInflater.from(c).inflate(R.layout.row,parent,false);
        return new  MyViewHolder(itemrow);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.name.setText(ls.get(position).getName());
        holder.phno.setText(ls.get(position).getPhno());
        holder.email.setText(ls.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return ls.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,phno,email;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.namee);
            phno=itemView.findViewById(R.id.phno);
            email=itemView.findViewById(R.id.email);
        }
    }
}
