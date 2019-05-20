package com.example.beautywithin;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Call;

public class MakeupService {

    public static void makeups( Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();


        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.MAKEUP_BASE_URL).newBuilder();

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

    }
}
