package com.example.beautywithin.services;
import com.example.beautywithin.Constants;
import com.example.beautywithin.models.Makeup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Call;
import okhttp3.Response;

public class MakeupService {

    public static ArrayList<Makeup> processResults(Response response) {
        ArrayList<Makeup> makeups = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            JSONArray makeupJSON = new JSONArray(jsonData);
            //JSONArray resultsJSON =  makeupJSON.getJSONArray();
            if (response.isSuccessful()) {
                for (int i = 0; i < 100; i++) {
                    JSONObject makeupsJSON = makeupJSON.getJSONObject(i);
                    String name = makeupsJSON.getString("name");
                    String product = makeupsJSON.getString("product_type");
                    String brand = makeupsJSON.getString("brand");
                    String category = makeupsJSON.getString("category");
                    String description = makeupsJSON.getString("description");
                    String price = makeupsJSON.getString("price");
                    String imageUrl = makeupsJSON.getString("image_link");
                   String websiteLink = makeupsJSON.getString("website_link");



                    Makeup makeup = new Makeup(name,product, brand, category, description, price, imageUrl,websiteLink);
                    makeups.add(makeup);
                }

            }

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
//

        }
        return makeups;
    }



    public static void makeups( Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder().readTimeout(5, TimeUnit.MINUTES)
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
