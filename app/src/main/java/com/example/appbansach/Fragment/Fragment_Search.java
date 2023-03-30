package com.example.appbansach.Fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbansach.Activity.DSSachActivity;
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

public class Fragment_Search extends Fragment {
    View view;
    EditText txtSearch;
    RecyclerView recyclerViewDSSach;
    SachAdapter sachAdapter;
    TextView txtNotF;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search,container,false);
        anhxa();
        getData();
        event();
        return view;
    }

    private void event() {
        txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String txtTim = txtSearch.getText().toString().trim();
                if(!txtTim.equals("")){
                    DataService db = APIService.getService();
                    Call<List<Sach>> cb= db.Tim(txtTim);
                    cb.enqueue(new Callback<List<Sach>>() {
                        @Override
                        public void onResponse(Call<List<Sach>> call, Response<List<Sach>> response) {
                            ArrayList<Sach> sachArrayList = (ArrayList<Sach>) response.body();
                            recyclerViewDSSach.setLayoutManager(new GridLayoutManager(getActivity(),2));
                            sachAdapter = new SachAdapter(getActivity(),sachArrayList);
                            if(sachArrayList.size()>0){
                                txtNotF.setVisibility(View.INVISIBLE);
                            }
                            else{
                                txtNotF.setText("Không tìm thấy "+txtTim.trim());
                                txtNotF.setVisibility(View.VISIBLE);
                            }
                            recyclerViewDSSach.setAdapter(sachAdapter);
                        }

                        @Override
                        public void onFailure(Call<List<Sach>> call, Throwable t) {

                        }
                    });
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void getData() {
        DataService db = APIService.getService();
        Call<List<Sach>> cb = db.GetAllSach();
        cb.enqueue(new Callback<List<Sach>>() {
            @Override
            public void onResponse(Call<List<Sach>> call, Response<List<Sach>> response) {
                ArrayList<Sach> sachArrayList = (ArrayList<Sach>) response.body();
                recyclerViewDSSach.setLayoutManager(new GridLayoutManager(getActivity(),2));
                sachAdapter = new SachAdapter(getActivity(),sachArrayList);
                recyclerViewDSSach.setAdapter(sachAdapter);
            }

            @Override
            public void onFailure(Call<List<Sach>> call, Throwable t) {

            }
        });
    }

    private void anhxa() {
        txtSearch = view.findViewById(R.id.txt_Seach);
        recyclerViewDSSach = view.findViewById(R.id.recyclerview_dssach_tim);
        txtNotF = view.findViewById(R.id.txt_notf);
    }
}
