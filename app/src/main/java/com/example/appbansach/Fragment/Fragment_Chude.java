package com.example.appbansach.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbansach.Adapter.ChuDeAdapter;
import com.example.appbansach.Adapter.TheLoaiAdapter;
import com.example.appbansach.Model.ChuDe;
import com.example.appbansach.Model.TheLoai;
import com.example.appbansach.R;
import com.example.appbansach.Service.APIService;
import com.example.appbansach.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Chude extends Fragment {
    private View view;
    RecyclerView recyclerViewCD;
    ChuDeAdapter chuDeAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chude,container,false);
        recyclerViewCD = view.findViewById(R.id.recyclerview_chude);
        getData();
        return view;
    }

    private void getData() {
        DataService db = APIService.getService();
        Call<List<ChuDe>> cb = db.GetChuDe();
        cb.enqueue(new Callback<List<ChuDe>>() {
            @Override
            public void onResponse(Call<List<ChuDe>> call, Response<List<ChuDe>> response) {
                ArrayList<ChuDe> arrcd = (ArrayList<ChuDe>) response.body();
                chuDeAdapter = new ChuDeAdapter(getActivity(),arrcd);
                recyclerViewCD.setLayoutManager(new GridLayoutManager(getActivity(),1));
                recyclerViewCD.setAdapter(chuDeAdapter);
            }

            @Override
            public void onFailure(Call<List<ChuDe>> call, Throwable t) {

            }
        });
    }
}
