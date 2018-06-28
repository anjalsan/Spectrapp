package com.spectrosmart.NanoScan.RetrofitSupport;

/**
 * Created by anjal on 18/6/16.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
    Retrofit retroWeather;
    Retrofit retroThirdUberDetails;
    Retrofit retro;
    Retrofit retroSearch;
    Retrofit retroMultipart;
    Retrofit retroThirdParty;
    Retrofit retroOla;
    Retrofit retroThirdUber;
    Retrofit retroThirdUberLogin;
    Retrofit retroThirdAllEvent;

    public RetrofitConfig(final Context context) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS);

        OkHttpClient.Builder httpClient2 = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS);


        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                SharedPreferences preferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);

                Request request = original.newBuilder()
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });

        OkHttpClient client2 = httpClient2.build();
        OkHttpClient client = httpClient.build();

        this.retro = new Retrofit.Builder()
                .baseUrl("https://spectrosmart-backend.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();


        this.retroMultipart = new Retrofit.Builder()
                .baseUrl("https://spectrosmart-backend.herokuapp.com/")
                .addConverterFactory(StringConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

    }

    public Retrofit getRetroThirdAllEvent() {
        return retroThirdAllEvent;
    }

    public void setRetroThirdAllEvent(Retrofit retroThirdAllEvent) {
        this.retroThirdAllEvent = retroThirdAllEvent;
    }

    public Retrofit getRetroThirdUberDetails() {
        return retroThirdUberDetails;
    }

    public void setRetroThirdUberDetails(Retrofit retroThirdUberDetails) {
        this.retroThirdUberDetails = retroThirdUberDetails;
    }

    public Retrofit getRetroThirdUberLogin() {
        return retroThirdUberLogin;
    }

    public void setRetroThirdUberLogin(Retrofit retroThirdUberLogin) {
        this.retroThirdUberLogin = retroThirdUberLogin;
    }

    public Retrofit getRetro() {
        return retro;
    }

    public void setRetro(Retrofit retro) {
        this.retro = retro;
    }

    public Retrofit getRetroMultipart() {
        return retroMultipart;
    }

    public void setRetroMultipart(Retrofit retroMultipart) {
        this.retroMultipart = retroMultipart;
    }

    public Retrofit getRetroThirdParty() {
        return retroThirdParty;
    }

    public void setRetroThirdParty(Retrofit retroThirdParty) {
        this.retroThirdParty = retroThirdParty;
    }

    public Retrofit getRetroSearch() {
        return retroSearch;
    }

    public void setRetroSearch(Retrofit retroSearch) {
        this.retroSearch = retroSearch;
    }

    public Retrofit getRetroOla() {
        return retroOla;
    }

    public void setRetroOla(Retrofit retroOla) {
        this.retroOla = retroOla;
    }

    public Retrofit getRetroThirdUber() {
        return retroThirdUber;
    }

    public void setRetroThirdUber(Retrofit retroThirdUber) {
        this.retroThirdUber = retroThirdUber;
    }

    public Retrofit getRetroWeather() {
        return retroWeather;
    }

    public void setRetroWeather(Retrofit retroWeather) {
        this.retroWeather = retroWeather;
    }
}
