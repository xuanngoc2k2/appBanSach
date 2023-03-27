package com.example.appbansach.Service;

import com.example.appbansach.Model.DealHot;
import com.example.appbansach.Model.NxbNsx;
import com.example.appbansach.Model.TheLoai;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {

    @GET("dealhot.php")
    Call<List<DealHot>> GetDealHot();

    @GET("theloai.php")
    Call<List<TheLoai>> GetAllTheLoai();

    @GET("NSX_NXB.php")
    Call<List<NxbNsx>> GetNSX_NXB();
}
