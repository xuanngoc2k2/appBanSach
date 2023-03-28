package com.example.appbansach.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sach {

@SerializedName("idSach")
@Expose
private String idSach;
@SerializedName("tenSach")
@Expose
private String tenSach;
@SerializedName("hinhSach")
@Expose
private String hinhSach;
@SerializedName("gioiThieu")
@Expose
private String gioiThieu;
@SerializedName("tenTacGia")
@Expose
private String tenTacGia;
@SerializedName("giaBan")
@Expose
private String giaBan;
@SerializedName("soLuong")
@Expose
private String soLuong;
@SerializedName("idTheLoai")
@Expose
private Object idTheLoai;
@SerializedName("idNhaSanXuat")
@Expose
private Object idNhaSanXuat;

public String getIdSach() {
return idSach;
}

public void setIdSach(String idSach) {
this.idSach = idSach;
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

public String getGioiThieu() {
return gioiThieu;
}

public void setGioiThieu(String gioiThieu) {
this.gioiThieu = gioiThieu;
}

public String getTenTacGia() {
return tenTacGia;
}

public void setTenTacGia(String tenTacGia) {
this.tenTacGia = tenTacGia;
}

public String getGiaBan() {
return giaBan;
}

public void setGiaBan(String giaBan) {
this.giaBan = giaBan;
}

public String getSoLuong() {
return soLuong;
}

public void setSoLuong(String soLuong) {
this.soLuong = soLuong;
}

public Object getIdTheLoai() {
return idTheLoai;
}

public void setIdTheLoai(Object idTheLoai) {
this.idTheLoai = idTheLoai;
}

public Object getIdNhaSanXuat() {
return idNhaSanXuat;
}

public void setIdNhaSanXuat(Object idNhaSanXuat) {
this.idNhaSanXuat = idNhaSanXuat;
}

}