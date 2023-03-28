package com.example.appbansach.Service;

import com.example.appbansach.Model.ChuDe;
import com.example.appbansach.Model.DealHot;
import com.example.appbansach.Model.NxbNsx;
import com.example.appbansach.Model.Sach;
import com.example.appbansach.Model.TheLoai;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataService {

    @GET("dealhot.php")
    Call<List<DealHot>> GetDealHot();

    @GET("theloai.php")
    Call<List<TheLoai>> GetAllTheLoai();

    @GET("NSX_NXB.php")
    Call<List<NxbNsx>> GetNSX_NXB();

    @GET("chude.php")
    Call<List<ChuDe>> GetChuDe();

    @GET("sachmoi.php")
    Call<List<Sach>> GetSachBanChay();

    @FormUrlEncoded
    @POST("dssach.php")
    Call<List<Sach>> GetSachTheoTL(@Field("idTheLoai") int idTheLoai);

    @FormUrlEncoded
    @POST("dssach.php")
    Call<List<Sach>> GetSPTheoNSX(@Field("idNhaSanXuat") int idNhaSanXuat);

    @FormUrlEncoded
    @POST("dssach.php")
    Call<List<Sach>> GetSPTheoChuDe(@Field("idChuDe") int idChuDe);

    @FormUrlEncoded
    @POST("dssach.php")
    Call<List<Sach>> Tim(@Field("txtTim") String txtTim);
}
