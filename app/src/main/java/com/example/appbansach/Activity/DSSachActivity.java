package com.example.appbansach.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appbansach.Adapter.SachAdapter;
import com.example.appbansach.Model.Sach;
import com.example.appbansach.R;
import com.example.appbansach.Service.APIService;
import com.example.appbansach.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DSSachActivity extends AppCompatActivity {
    SachAdapter sachAdapter;
    RecyclerView dssach;
    String idTheLoai="";
    EditText txtSeach;
    TextView txtNotfound;
    private String idNXBNSX;
    private String idChude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dssach);
        dssach = findViewById(R.id.recyclerview_dssach);
        Intent intent = getIntent();
        txtNotfound = findViewById(R.id.txtnotf);
        if(intent.hasExtra("idTheLoai")){
            Bundle d = intent.getBundleExtra("idTheLoai");
            idTheLoai = d.getString("idTL");
            Log.d("AAA", idTheLoai);
            getDataTheLoai();
        }
        if(intent.hasExtra("idNXBNSX")){
            Bundle d = intent.getBundleExtra("idNXBNSX");
            idNXBNSX = d.getString("idNXBNSX");
            getDataNXB_NSX();
        }
        if(intent.hasExtra("idChuDe")){
            Bundle d = intent.getBundleExtra("idChuDe");
            idChude = d.getString("idCd");
            getDataChude();
        }
        ImageView imgBack = findViewById(R.id.imgback);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        txtSeach = findViewById(R.id.txtSeach);
        txtSeach.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String txtTim = txtSeach.getText().toString().trim();
                DataService db = APIService.getService();
                Call<List<Sach>> cb= db.Tim(txtTim);
                cb.enqueue(new Callback<List<Sach>>() {
                    @Override
                    public void onResponse(Call<List<Sach>> call, Response<List<Sach>> response) {
                        ArrayList<Sach> sachArrayList = (ArrayList<Sach>) response.body();
                        dssach.setLayoutManager(new GridLayoutManager(DSSachActivity.this,2));
                        sachAdapter = new SachAdapter(DSSachActivity.this,sachArrayList);
                        if(sachArrayList.size()>0){
                            dssach.setAdapter(sachAdapter);
                            txtNotfound.setVisibility(View.INVISIBLE);
                        }
                        else{
                            txtNotfound.setText("Không tìm thấy "+txtTim.trim());
                            txtNotfound.setVisibility(View.VISIBLE);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Sach>> call, Throwable t) {

                    }
                });
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void getDataChude() {
        DataService db = APIService.getService();
        Call<List<Sach>> cb= db.GetSPTheoChuDe(Integer.parseInt(idChude));
        cb.enqueue(new Callback<List<Sach>>() {
            @Override
            public void onResponse(Call<List<Sach>> call, Response<List<Sach>> response) {
                ArrayList<Sach> sachArrayList = (ArrayList<Sach>) response.body();
                dssach.setLayoutManager(new GridLayoutManager(DSSachActivity.this,2));
                sachAdapter = new SachAdapter(DSSachActivity.this,sachArrayList);
                dssach.setAdapter(sachAdapter);
            }

            @Override
            public void onFailure(Call<List<Sach>> call, Throwable t) {

            }
        });
    }

    private void getDataNXB_NSX() {
        DataService db = APIService.getService();
        Call<List<Sach>> cb= db.GetSPTheoNSX(Integer.parseInt(idNXBNSX));
        cb.enqueue(new Callback<List<Sach>>() {
            @Override
            public void onResponse(Call<List<Sach>> call, Response<List<Sach>> response) {
                ArrayList<Sach> sachArrayList = (ArrayList<Sach>) response.body();
                dssach.setLayoutManager(new GridLayoutManager(DSSachActivity.this,2));
                sachAdapter = new SachAdapter(DSSachActivity.this,sachArrayList);
                dssach.setAdapter(sachAdapter);
            }

            @Override
            public void onFailure(Call<List<Sach>> call, Throwable t) {

            }
        });
    }

    private void getDataTheLoai() {
        DataService db = APIService.getService();
        Call<List<Sach>> cb= db.GetSachTheoTL(Integer.parseInt(idTheLoai));
        cb.enqueue(new Callback<List<Sach>>() {
            @Override
            public void onResponse(Call<List<Sach>> call, Response<List<Sach>> response) {
                ArrayList<Sach> sachArrayList = (ArrayList<Sach>) response.body();
                dssach.setLayoutManager(new GridLayoutManager(DSSachActivity.this,2));
                sachAdapter = new SachAdapter(DSSachActivity.this,sachArrayList);
                dssach.setAdapter(sachAdapter);
            }

            @Override
            public void onFailure(Call<List<Sach>> call, Throwable t) {

            }
        });
    }
}