package com.example.appbansach.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbansach.Activity.MainActivity;
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

public class Fragment_SachBanChay extends Fragment {
    private View view;
    RecyclerView recyclerViewSachBC;
    SachAdapter sachAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sachbanchay,container,false);
        recyclerViewSachBC = view.findViewById(R.id.recyclerview_sachbanchay);
        getData();
        return view;
    }

    private void getData() {
        DataService db = APIService.getService();
        Call<List<Sach>> cb = db.GetSachBanChay();
        cb.enqueue(new Callback<List<Sach>>() {
            @Override
            public void onResponse(Call<List<Sach>> call, Response<List<Sach>> response) {
                ArrayList<Sach> sachArrayList = (ArrayList<Sach>) response.body();
                sachAdapter = new SachAdapter(getActivity(),sachArrayList);
                recyclerViewSachBC.setLayoutManager(new GridLayoutManager(getActivity(),2));
                recyclerViewSachBC.setAdapter(sachAdapter);
            }

            @Override
            public void onFailure(Call<List<Sach>> call, Throwable t) {

            }
        });
    }
}
