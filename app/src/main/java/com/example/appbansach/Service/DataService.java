package com.example.appbansach.Service;

import com.example.appbansach.Model.ChuDe;
import com.example.appbansach.Model.DealHot;
import com.example.appbansach.Model.GioHang;
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

    @GET("getallsach.php")
    Call<List<Sach>> GetAllSach();

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
    Call<List<Sach>> Tim(@Field("tukhoa") String tukhoa);

    @FormUrlEncoded
    @POST("dssach.php")
    Call<List<Sach>> TimTheoNXS(@Field("tukhoa") String tukhoa,@Field("idNhaSanXuat") int idNhaSanXuat);

    @FormUrlEncoded
    @POST("dssachtheloai.php")
    Call<List<Sach>> TimTheoTheLoai(@Field("tukhoa") String tukhoa,@Field("idTheLoai") int idTheLoai);

    @FormUrlEncoded
    @POST("dssach.php")
    Call<List<Sach>> TimTheoChuDe(@Field("tukhoa") String tukhoa,@Field("idChuDe") int idChuDe);

    @FormUrlEncoded
    @POST("usergiohang.php")
    Call<List<GioHang>> GetGioHangTheoUser(@Field("idUser") int idUser);

    @FormUrlEncoded
    @POST("deletegiohang.php")
    Call<String> DeleteGioHang(@Field("idUser") int idUser,@Field("idSach") int idSach);

    @FormUrlEncoded
    @POST("updateslgiohang.php")
    Call<String> UpdateGioHang(@Field("idUser") int idUser,@Field("idSach") int idSach,@Field("soLuong") int soLuong);

    @FormUrlEncoded
    @POST("updategiohang.php")
    Call<String> UpdateSPGioHang(@Field("idUser") int idUser,@Field("idSach") int idSach);

    @FormUrlEncoded
    @POST("updategia.php")
    Call<String> UpdateTongTien(@Field("idUser") int idUser);


}
