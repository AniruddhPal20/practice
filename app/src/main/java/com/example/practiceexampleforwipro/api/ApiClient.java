package com.example.practiceexampleforwipro.api;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

  private static OkHttpClient okHttpClient;
  private static Retrofit retrofit = null;

  public static Retrofit getClient() {

    initOkHttp();

    if (retrofit == null) {
      retrofit = new Retrofit.Builder()
          .baseUrl(WebApisConstants.BASE_URL)
          .client(okHttpClient)
          .addConverterFactory(GsonConverterFactory.create())
          .build();
    }
    return retrofit;
  }

  private static void initOkHttp() {
    int REQUEST_TIMEOUT = 60;
    OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder()
        .connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS);

    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

    httpClient.addInterceptor(interceptor);

    httpClient.addInterceptor(chain -> {
      Request original = chain.request();
      Request.Builder requestBuilder = original.newBuilder()
          .addHeader("Accept", "application/json")
          .addHeader("Content-Type", "application/json");

      Request request = requestBuilder.build();
      return chain.proceed(request);
    });

    okHttpClient = httpClient.build();
  }
}
