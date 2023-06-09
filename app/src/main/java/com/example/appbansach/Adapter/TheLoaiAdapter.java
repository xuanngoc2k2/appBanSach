package com.example.appbansach.Adapter;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.example.appbansach.Activity.DSSachActivity;
import com.example.appbansach.Model.TheLoai;
import com.example.appbansach.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TheLoaiAdapter extends RecyclerView.Adapter<TheLoaiAdapter.ViewHolder>{
    Context context;
    ArrayList<TheLoai> arrTheLoai;

    public TheLoaiAdapter(Context context, ArrayList<TheLoai> arrTheLoai) {
        this.context = context;
        this.arrTheLoai = arrTheLoai;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_theloai,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TheLoai theLoai = arrTheLoai.get(position);
        holder.txtTenTL.setText(theLoai.getTenTheLoai());
        Picasso.with(context).load(theLoai.getHinhTheLoai()).into(holder.imgTL);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(context, DSSachActivity.class);
                Bundle d = new Bundle();
                d.putString("idTL",theLoai.getIdTheLoai());
                t.putExtra("idTheLoai",d);
                context.startActivity(t);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrTheLoai.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtTenTL;
        ImageView imgTL;
        RelativeLayout relativeLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTenTL = itemView.findViewById(R.id.txtTentheloai);
            imgTL = itemView.findViewById(R.id.imgTheloai);
            relativeLayout = itemView.findViewById(R.id.relative_theloai);
        }
    }
}
