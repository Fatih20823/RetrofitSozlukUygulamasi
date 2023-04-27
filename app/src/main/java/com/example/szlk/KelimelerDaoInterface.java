package com.example.szlk;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface KelimelerDaoInterface {

    @GET("bayrakquiz/tum_kelimeler.php")
    Call<KelimelerCevap> tumKelimelerDıf();

    @POST("bayrakquiz/tum_kelimeler_arama.php")
    @FormUrlEncoded
    Call<KelimelerCevap> kelimeAra(@Field("ingilizce") String ingilizce);
}
