package com.example.szlk;

public class ApiUtils {

    public static final String BASE_URL = "https://snowpiercer.store/";

    //bu base link ana link olmalı alt kolları interface içerisinde belirtilir.

    public static KelimelerDaoInterface getKelimelerDaoInterfeace() {
        return RetrofitClient.getClient(BASE_URL).create(KelimelerDaoInterface.class);
    }
}


