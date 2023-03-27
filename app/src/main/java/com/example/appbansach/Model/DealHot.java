package com.example.appbansach.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DealHot {

@SerializedName("idDeadHot")
@Expose
private String idDeadHot;
@SerializedName("tenDealHot")
@Expose
private String tenDealHot;
@SerializedName("idSach")
@Expose
private String idSach;
@SerializedName("hinhDealHot")
@Expose
private String hinhDealHot;

public String getIdDeadHot() {
return idDeadHot;
}

public void setIdDeadHot(String idDeadHot) {
this.idDeadHot = idDeadHot;
}

public String getTenDealHot() {
return tenDealHot;
}

public void setTenDealHot(String tenDealHot) {
this.tenDealHot = tenDealHot;
}

public String getIdSach() {
return idSach;
}

public void setIdSach(String idSach) {
this.idSach = idSach;
}

public String getHinhDealHot() {
return hinhDealHot;
}

public void setHinhDealHot(String hinhDealHot) {
this.hinhDealHot = hinhDealHot;
}

}
