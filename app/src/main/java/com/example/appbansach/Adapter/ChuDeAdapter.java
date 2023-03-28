package com.example.appbansach.Adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.appbansach.Activity.DSSachActivity;
import com.example.appbansach.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbansach.Model.ChuDe;
import com.squareup.picasso.Picasso;

import java.sql.Array;
import java.util.ArrayList;

public class ChuDeAdapter extends RecyclerView.Adapter<ChuDeAdapter.ViewHolder>{
    Context context;
    ArrayList<ChuDe> chuDeArrayList;

    public ChuDeAdapter(Context context, ArrayList<ChuDe> chuDeArrayList) {
        this.context = context;
        this.chuDeArrayList = chuDeArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_chude,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChuDe chuDe = chuDeArrayList.get(position);
        Picasso.with(context).load(chuDe.getHinhChuDe()).into(holder.imgChuDe);
        holder.txtTenChuDe.setText(chuDe.getTenChuDe());
        holder.txtGioithieucd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(context, DSSachActivity.class);
                Bundle d = new Bundle();
                d.putString("idCd",chuDe.getIdChuDe());
                t.putExtra("idChuDe",d);
                context.startActivity(t);
            }
        });
    }

    @Override
    public int getItemCount() {
        return chuDeArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtTenChuDe,txtGioithieucd;
        ImageView imgChuDe;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgChuDe = itemView.findViewById(R.id.imgChuDe);
            txtTenChuDe = itemView.findViewById(R.id.txtTenChuDe);
            txtGioithieucd = itemView.findViewById(R.id.txtGioithieucd);
        }
    }
}
