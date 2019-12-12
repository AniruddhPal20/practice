package com.example.practiceexampleforwipro.retro;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class EncryptionIntercepter implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request response = chain.request();

        return null;
    }
}
