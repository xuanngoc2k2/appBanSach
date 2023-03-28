package com.example.appbansach.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbansach.Model.Sach;
import com.example.appbansach.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SachAdapter extends RecyclerView.Adapter<SachAdapter.ViewHolder>{
    Context context;
    ArrayList<Sach> arrayListSach;

    public SachAdapter(Context context, ArrayList<Sach> arrayListSach) {
        this.context = context;
        this.arrayListSach = arrayListSach;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view  = inflater.inflate(R.layout.dong_sach,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Sach sach = arrayListSach.get(position);
        Picasso.with(context).load(sach.getHinhSach()).into(holder.imgSach);
        holder.txtTensach.setText(sach.getTenSach());
        holder.txtGia.setText(sach.getGiaBan()+"đ");
    }

    @Override
    public int getItemCount() {
        return arrayListSach.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtTensach,txtGia;
        ImageView imgSach;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTensach = itemView.findViewById(R.id.txtTenSach);
            txtGia = itemView.findViewById(R.id.txtGiaSach);
            imgSach =itemView.findViewById(R.id.imgSach);
        }
    }
}
