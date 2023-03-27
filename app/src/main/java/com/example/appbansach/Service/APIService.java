package com.example.appbansach.Service;

public class APIService {
    private static String base_url = "https://xuanngoc2k2.000webhostapp.com/Server/";

    public static DataService getService(){
        return APIRetrofitClient.getClient(base_url).create(DataService.class);
    }
}
