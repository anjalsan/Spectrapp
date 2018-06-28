package com.spectrosmart.NanoScan.RetrofitSupport;

import com.google.gson.JsonObject;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
//all the interface calls to the apis are defined here


public interface ApiInterface {
    //store admin

    @Multipart
    @POST("/experiments/")
    Call<LoginResponse> createMultiMediaSpark(@Part MultipartBody.Part csv);

}
