package com.example.andrijakolacek2018202186;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class StockDataService {

    public static final String QUERY_FOR_SYMBOL = "https://fcsapi.com/api-v3/stock/latest?symbol=";
    public static final String API_KEY = "&access_key=ccQPj2aMvpoN7kTK5C8b";

    Context context;
    String stockInfo;

    public StockDataService(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener {
        void onError(String message);

        void onResponse(List<StockModel> stockModels);
    }

    public interface StockByTickResponse {
        void onError(String message);

        void onResponse(List<StockModel> stockModels);
    }

    public void getStockByTick(String tickName, StockByTickResponse stockByTickResponse) {

        List<StockModel> report = new ArrayList<>();

        String url = QUERY_FOR_SYMBOL + tickName + API_KEY;

        // get object
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
               // Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show();
                try {
                    JSONArray responseList = response.getJSONArray("response");
                   // Toast.makeText(context, responseList.toString(), Toast.LENGTH_SHORT).show();
                            // get first item

                        for(int i = 0; i < responseList.length(); i++) {
                            StockModel nasdaq = new StockModel();
                            JSONObject nasdaqAPI = (JSONObject) responseList.get(i);
                            nasdaq.setC(nasdaqAPI.getString("c"));
                            nasdaq.setH(nasdaqAPI.getString("h"));
                            nasdaq.setL(nasdaqAPI.getString("l"));
                            nasdaq.setCh(nasdaqAPI.getString("ch"));
                            nasdaq.setCp(nasdaqAPI.getString("cp"));
                            nasdaq.setT(nasdaqAPI.getString("t"));
                            nasdaq.setS(nasdaqAPI.getString("s"));
                            nasdaq.setCty(nasdaqAPI.getString("cty"));
                            nasdaq.setCcy(nasdaqAPI.getString("ccy"));
                            nasdaq.setExch(nasdaqAPI.getString("exch"));
                            nasdaq.setId(nasdaqAPI.getString("id"));
                            nasdaq.setTm(nasdaqAPI.getString("tm"));
                            report.add(nasdaq);
                        }


                            stockByTickResponse.onResponse(report);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               // Toast.makeText(context, "something wrong", Toast.LENGTH_SHORT).show();
            }
        });



        // get property

        // get each item in array
        MySingleton.getInstance(context).addToRequestQueue(request);
    }

}
