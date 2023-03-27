package com.example.appbansach.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.appbansach.Adapter.DealHotAdapter;
import com.example.appbansach.Model.DealHot;
import com.example.appbansach.R;
import com.example.appbansach.Service.APIService;
import com.example.appbansach.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_DealHot extends Fragment {
    private View view;
    ViewPager viewPager;
    CircleIndicator circleIndicator;
    DealHotAdapter dealHotAdapter;
    Runnable runnable;
    Handler handler;
    int curItem;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dealhot,container,false);
        anhxa();
        getData();
        return view;
    }

    private void anhxa() {
        viewPager = view.findViewById(R.id.viewpager_dealhot);
        circleIndicator = view.findViewById(R.id.indicatiordefault);
    }

    private void getData() {
        DataService dataService = APIService.getService();
        Call<List<DealHot>> db = dataService.GetDealHot();
        db.enqueue(new Callback<List<DealHot>>() {
            @Override
            public void onResponse(Call<List<DealHot>> call, Response<List<DealHot>> response) {
                ArrayList<DealHot> dealHotArrayList = (ArrayList<DealHot>) response.body();
                dealHotAdapter = new DealHotAdapter(getActivity(),dealHotArrayList);
                viewPager.setAdapter(dealHotAdapter);
                circleIndicator.setViewPager(viewPager);
                handler = new Handler();
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        curItem = viewPager.getCurrentItem();
                        curItem++;
                        if(curItem>=viewPager.getAdapter().getCount()){
                            curItem=0;
                        }
                        viewPager.setCurrentItem(curItem,true);
                        handler.postDelayed(runnable,3000);
                    }
                };
                handler.postDelayed(runnable,3000);
            }

            @Override
            public void onFailure(Call<List<DealHot>> call, Throwable t) {

            }
        });
    }
}
