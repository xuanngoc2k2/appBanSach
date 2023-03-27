package com.example.appbansach.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbansach.Adapter.NXB_NSXAdapter;
import com.example.appbansach.Model.NxbNsx;
import com.example.appbansach.R;
import com.example.appbansach.Service.APIService;
import com.example.appbansach.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_NXB_NSX extends Fragment {
    private View view;
    RecyclerView recyclerViewNSX;
    NXB_NSXAdapter nxb_nsxAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_nxb_nsx,container,false);
        recyclerViewNSX = view.findViewById(R.id.recyclerview_nxb);
        getData();
        return view;
    }

    private void getData() {
        DataService dataService = APIService.getService();
        Call<List<NxbNsx>>  cb = dataService.GetNSX_NXB();
        cb.enqueue(new Callback<List<NxbNsx>>() {
            @Override
            public void onResponse(Call<List<NxbNsx>> call, Response<List<NxbNsx>> response) {
                ArrayList<NxbNsx> arrNxb = (ArrayList<NxbNsx>) response.body();
                nxb_nsxAdapter = new NXB_NSXAdapter(getActivity(),arrNxb);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
                recyclerViewNSX.setLayoutManager(linearLayoutManager);
                recyclerViewNSX.setAdapter(nxb_nsxAdapter);
            }

            @Override
            public void onFailure(Call<List<NxbNsx>> call, Throwable t) {

            }
        });
    }
}
