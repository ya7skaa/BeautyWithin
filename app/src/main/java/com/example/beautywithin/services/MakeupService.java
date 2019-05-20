package com.example.beautywithin.services;
import com.example.beautywithin.Constants;
import com.example.beautywithin.models.Makeup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

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
                for (int i = 0; i < makeupJSON.length(); i++) {
                    JSONObject makeupsJSON = makeupJSON.getJSONObject(i);
                    String name = makeupsJSON.getString("name");
                    String product = makeupsJSON.getString("product_type");
                    String brand = makeupsJSON.getString("brand");
                    String category = makeupsJSON.getString("product_category");
                    String rating = makeupsJSON.getString("rating");
                    String description = makeupsJSON.getString("description");
                    int price = makeupsJSON.getInt("price");
                    String imageUrl = makeupsJSON.getString("image_url");


                    Makeup makeup = new Makeup(name,product, brand, category, rating, description, price, imageUrl);
                    makeups.add(makeup);
                }

            }

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        }
        return makeups;
    }



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
