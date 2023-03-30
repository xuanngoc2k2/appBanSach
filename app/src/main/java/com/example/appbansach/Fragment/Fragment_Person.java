package com.example.appbansach.Fragment;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbansach.Activity.MainActivity;
import com.example.appbansach.Activity.User;
import com.example.appbansach.Adapter.GioHangAdaper;
import com.example.appbansach.Model.GioHang;
import com.example.appbansach.R;
import com.example.appbansach.Service.APIService;
import com.example.appbansach.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Person extends Fragment{
    private View view;
    RecyclerView dsGioHang;
    TextView txtGia,txtCanhan;
    ImageView imguser;
    GioHangAdaper gioHangAdaper;
    int idUser;
    public static String Username = MainActivity.Username;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_person,container,false);
        anhxa();
        Bundle d = getArguments();
        if(d!=null){
            txtCanhan.setText(d.getString("username"));
            Fragment_Person.this.getData();
            DataService db = APIService.getService();
            Call<String> iduser = db.GetidUser(Username);
            iduser.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    idUser = Integer.parseInt(response.body());
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                }
            });
        }
        return view;
    }
//    public void onResume() {
//        super.onResume();
//        if(idUser!=""){
//            getData();
//        }
//    }
    private void getData() {
        DataService db = APIService.getService();
        Call<String> cbb = db.UpdateTongTien(idUser);
        cbb.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(!response.body().equals("")){
                    txtGia.setText(response.body().toString()+"đ");

                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
        Call<List<GioHang>> cb = db.GetGioHangTheoUser(idUser);
        cb.enqueue(new Callback<List<GioHang>>() {
            @Override
            public void onResponse(Call<List<GioHang>> call, Response<List<GioHang>> response) {
                ArrayList<GioHang> gioHangArrayList = (ArrayList<GioHang>) response.body();
                gioHangAdaper = new GioHangAdaper(getActivity(),gioHangArrayList,idUser);
                dsGioHang.setLayoutManager(new LinearLayoutManager(getActivity()));
                dsGioHang.setAdapter(gioHangAdaper);
                gioHangAdaper.setOnItemClickListener(new GioHangAdaper.OnItemClickListener() {
                    @Override
                    public void onImgDelClick() {
                        Log.d("CCC", String.valueOf(111));
                        Fragment_Person.this.getData();
                    }
                });
            }

            @Override
            public void onFailure(Call<List<GioHang>> call, Throwable t) {

            }
        });
    }

    private void anhxa() {
        txtCanhan = view.findViewById(R.id.txtCanhan);
        dsGioHang = view.findViewById(R.id.dsGiohang);
        txtGia = view.findViewById(R.id.txtGia);
        imguser = view.findViewById(R.id.imguser);
    }

    private void event() {
    }
}
