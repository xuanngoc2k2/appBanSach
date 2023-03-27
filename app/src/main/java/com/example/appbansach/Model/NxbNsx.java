package com.example.appbansach.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NxbNsx {

@SerializedName("idNSX_NXB")
@Expose
private String idNSXNXB;
@SerializedName("tenNXB_NXB")
@Expose
private String tenNXBNXB;
@SerializedName("hinhNSX_NXB")
@Expose
private String hinhNSXNXB;

public String getIdNSXNXB() {
return idNSXNXB;
}

public void setIdNSXNXB(String idNSXNXB) {
this.idNSXNXB = idNSXNXB;
}

public String getTenNXBNXB() {
return tenNXBNXB;
}

public void setTenNXBNXB(String tenNXBNXB) {
this.tenNXBNXB = tenNXBNXB;
}

public String getHinhNSXNXB() {
return hinhNSXNXB;
}

public void setHinhNSXNXB(String hinhNSXNXB) {
this.hinhNSXNXB = hinhNSXNXB;
}

}