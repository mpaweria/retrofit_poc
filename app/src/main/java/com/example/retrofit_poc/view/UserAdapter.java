package com.example.retrofit_poc.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.retrofit_poc.R;
import com.example.retrofit_poc.model.ResponseModel;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    private Context context;
    private List<ResponseModel> userList;

    public UserAdapter(Context context, List<ResponseModel> userList){
        this.context = context;
        this.userList = userList;
    }

    public void setUserList(List<ResponseModel> userList){
        this.userList = userList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.MyViewHolder holder, int position) {
        Glide.with(context).load(this.userList.get(position).getProfile_image())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.imageView);
        holder.name.setText(this.userList.get(position).getDisplay_name().toString());
        holder.link.setText(this.userList.get(position).getLink().toString());
    }

    @Override
    public int getItemCount() {
        if(this.userList != null){
            return this.userList.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        TextView link;

        public MyViewHolder(View itemView){
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            name = (TextView) itemView.findViewById(R.id.name);
            link = (TextView) itemView.findViewById(R.id.name);
        }
    }
}
