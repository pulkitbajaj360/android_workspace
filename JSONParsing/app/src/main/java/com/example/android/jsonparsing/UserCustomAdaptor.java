package com.example.android.jsonparsing;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UserCustomAdaptor extends RecyclerView.Adapter<UserCustomAdaptor.MyViewHolder> {

    private List<User> list;
    private Context context;
    private LayoutInflater inflater;


    public UserCustomAdaptor(List<User> list, Context context) {
        this.list = list;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        Log.i("Total Record: ",""+list.size());
    }

    @NonNull
    @Override
    public UserCustomAdaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.user_cart_layout,viewGroup,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        User u = list.get(i);

        Picasso.with(context).load(u.getImgUrl()).networkPolicy(NetworkPolicy.NO_CACHE).into(holder.img);
        holder.name.setText(u.getName());
        holder.email.setText(u.getEmail());
        holder.type.setText(u.getServiceType());
        holder.detail.setText(u.getServiceDetail());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView name,email,type,detail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img  =itemView.findViewById(R.id.userImage);
            name = itemView.findViewById(R.id.userName);
            email  =itemView.findViewById(R.id.userEmail);
            type = itemView.findViewById(R.id.userServiceType);
            detail = itemView.findViewById(R.id.userServiceDetail);
        }
    }

}
