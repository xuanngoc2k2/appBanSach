package com.example.appbansach.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.appbansach.Model.DealHot;
import com.example.appbansach.R;
import com.squareup.picasso.Picasso;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class DealHotAdapter extends PagerAdapter {
    Context context;
    ArrayList<DealHot> arrDealhot;

    public DealHotAdapter(Context context, ArrayList<DealHot> arrDealhot) {
        this.context = context;
        this.arrDealhot = arrDealhot;
    }

    @Override
    public int getCount() {
        return arrDealhot.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_dealhot,null);
        ImageView imgbackground = view.findViewById(R.id.imgBackground);
        Picasso.with(context).load(arrDealhot.get(position).getHinhDealHot()).into(imgbackground);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
