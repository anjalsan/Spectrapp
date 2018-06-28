package com.spectrosmart.NanoScan;

import com.spectrosmart.NanoScan.RetrofitSupport.LoginResponse;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by anjal on 12/20/17.
 */

public interface FileUploadService {
    @Multipart
    @POST("/experiments/")
    Call<LoginResponse> upload(@Part MultipartBody.Part csv);
}