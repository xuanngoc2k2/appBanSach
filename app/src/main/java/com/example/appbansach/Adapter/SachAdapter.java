package com.example.appbansach.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbansach.Model.Sach;
import com.example.appbansach.R;
import com.example.appbansach.Service.APIService;
import com.example.appbansach.Service.DataService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SachAdapter extends RecyclerView.Adapter<SachAdapter.ViewHolder>{
    Context context;
    ArrayList<Sach> arrayListSach;
    String idUser = "1";
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
        holder.imgThemgh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataService db = APIService.getService();
                Call<String> cb = db.UpdateSPGioHang(Integer.parseInt(idUser),Integer.parseInt(sach.getIdSach()));
                cb.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
//                        Toast.makeText(context,response.body().toString(),Toast.LENGTH_SHORT).show();
                        if(response.body().equals("OK")){
                            Toast.makeText(context,"Thêm thành công",Toast.LENGTH_SHORT).show();
                        }
                        else if(response.body().equals("Qua")){
                            Toast.makeText(context,"Vượt quá số lượng",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(context,"Something wrong",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayListSach.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtTensach,txtGia;
        ImageView imgSach,imgThemgh;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTensach = itemView.findViewById(R.id.txtTenSach);
            txtGia = itemView.findViewById(R.id.txtGiaSach);
            imgSach =itemView.findViewById(R.id.imgSach);
            imgThemgh = itemView.findViewById(R.id.imgThemgh);
        }
    }
}
