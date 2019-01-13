package com.iu.finaltest.Util;

import android.content.Context;
import android.telecom.Call;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ConnectServer {

    private final static String serverURL = "http://13.124.249.254/";

    public interface  JsonResponseHandler {
        void onResponse(JSONObject json);
    }



    public static void getRequestBanks(Context context, final JsonResponseHandler handler) {

        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(serverURL+"info/bank").newBuilder();


        String requestUrl = urlBuilder.build().toString();
        Log.d("요청URL", requestUrl);

        Request request = new Request.Builder()
                .url(requestUrl)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
            }
            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                String body = response.body().string();
                try {
                    JSONObject json = new JSONObject(body);
                    if (handler != null) {
                        handler.onResponse(json);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
