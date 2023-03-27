package com.example.appbansach.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbansach.Adapter.TheLoaiAdapter;
import com.example.appbansach.Model.TheLoai;
import com.example.appbansach.R;
import com.example.appbansach.Service.APIService;
import com.example.appbansach.Service.DataService;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentTheLoai extends Fragment {
    private View view;
    RecyclerView recyclerViewTheLoai;
    TheLoaiAdapter theLoaiAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_theloai,container,false);
        recyclerViewTheLoai = view.findViewById(R.id.recyclerview_theloai);
        getData();
        return view;
    }


    private void getData() {
        DataService db = APIService.getService();
        Call<List<TheLoai>> cb = db.GetAllTheLoai();
        cb.enqueue(new Callback<List<TheLoai>>() {
            @Override
            public void onResponse(Call<List<TheLoai>> call, Response<List<TheLoai>> response) {
                ArrayList<TheLoai> arrTheLoai = (ArrayList<TheLoai>) response.body();
                theLoaiAdapter = new TheLoaiAdapter(getActivity(),arrTheLoai);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
                recyclerViewTheLoai.setLayoutManager(linearLayoutManager);
                recyclerViewTheLoai.setAdapter(theLoaiAdapter);
            }

            @Override
            public void onFailure(Call<List<TheLoai>> call, Throwable t) {

            }
        });
    }
}
