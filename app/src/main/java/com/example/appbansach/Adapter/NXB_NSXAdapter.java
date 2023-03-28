package com.example.appbansach.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbansach.Activity.DSSachActivity;
import com.example.appbansach.R;

import com.example.appbansach.Model.NxbNsx;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NXB_NSXAdapter extends RecyclerView.Adapter<NXB_NSXAdapter.ViewHoler>{
    Context context;
    ArrayList<NxbNsx> nsxArrayList;

    public NXB_NSXAdapter(Context context, ArrayList<NxbNsx> nsxArrayList) {
        this.context = context;
        this.nsxArrayList = nsxArrayList;
    }

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dongnxb_nsx,parent,false);
        return new ViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, int position) {
        NxbNsx nxbNsx = nsxArrayList.get(position);
        holder.txtNSX.setText(nxbNsx.getTenNXBNXB());
        Picasso.with(context).load(nxbNsx.getHinhNSXNXB()).into(holder.imgNSX);
        holder.cardViewNSX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(context, DSSachActivity.class);
                Bundle d = new Bundle();
                d.putString("idNXBNSX",nxbNsx.getIdNSXNXB());
                t.putExtra("idNXBNSX",d);
                context.startActivity(t);
            }
        });
    }

    @Override
    public int getItemCount() {
        return nsxArrayList.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder{
        ImageView imgNSX;
        TextView txtNSX;
        CardView cardViewNSX;
        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            cardViewNSX = itemView.findViewById(R.id.cardviewNSX);
            imgNSX = itemView.findViewById(R.id.imgNXB_NSX);
            txtNSX = itemView.findViewById(R.id.txtTenNSX);
        }
    }
}
