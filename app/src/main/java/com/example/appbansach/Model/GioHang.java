package com.example.appbansach.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GioHang {

@SerializedName("idGioHang")
@Expose
private String idGioHang;
@SerializedName("idSach")
@Expose
private String idSach;
@SerializedName("soLuong")
@Expose
private String soLuong;
@SerializedName("idUser")
@Expose
private String idUser;
@SerializedName("tenSach")
@Expose
private String tenSach;
@SerializedName("hinhSach")
@Expose
private String hinhSach;
@SerializedName("giaBan")
@Expose
private String giaBan;
@SerializedName("slCo")
@Expose
private String slCo;

public String getIdGioHang() {
return idGioHang;
}

public void setIdGioHang(String idGioHang) {
this.idGioHang = idGioHang;
}

public String getIdSach() {
return idSach;
}

public void setIdSach(String idSach) {
this.idSach = idSach;
}

public String getSoLuong() {
return soLuong;
}

public void setSoLuong(String soLuong) {
this.soLuong = soLuong;
}

public String getIdUser() {
return idUser;
}

public void setIdUser(String idUser) {
this.idUser = idUser;
}

public String getTenSach() {
return tenSach;
}

public void setTenSach(String tenSach) {
this.tenSach = tenSach;
}

public String getHinhSach() {
return hinhSach;
}

public void setHinhSach(String hinhSach) {
this.hinhSach = hinhSach;
}

public String getGiaBan() {
return giaBan;
}

public void setGiaBan(String giaBan) {
this.giaBan = giaBan;
}
public String getSlCo() {
    return slCo;
}
public void setSlCo(String slCo) {
    this.slCo = slCo;
}
}