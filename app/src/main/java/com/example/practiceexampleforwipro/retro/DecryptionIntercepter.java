package com.example.practiceexampleforwipro.retro;
import com.example.practiceexampleforwipro.utils.Helper;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class DecryptionIntercepter implements Interceptor {
    public DecryptionIntercepter() {

    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        String responseStr="";
        //String contentType = response.header("Content-Type");
        Response.Builder resposneBuilder = response.newBuilder();
        MediaType contentType = response.body().contentType();
        if (response.isSuccessful()) {
            responseStr = response.body().string();
            Helper.v("Decrypter", "Wipro [" + responseStr + "]");
            responseStr = responseStr.replaceAll("^\"|\"$","").replace("\\\"", "\"");
            Helper.v("Decrypter", "Wipro [" + responseStr + "]");
        }

        return resposneBuilder.body(ResponseBody.create(contentType,responseStr)).build();
    }
}
