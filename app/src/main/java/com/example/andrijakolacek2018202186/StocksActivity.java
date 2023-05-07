package com.example.andrijakolacek2018202186;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class StocksActivity extends AppCompatActivity {

    Button buttonStockName;
    EditText searchStock;
    ListView listViewStocks;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stocks);

        checkConnectivity();
        searchStock = findViewById(R.id.searchStock);
        listViewStocks = findViewById(R.id.listViewStocks);
        buttonStockName = findViewById(R.id.buttonStockName);

        final StockDataService stockDataService = new StockDataService(StocksActivity.this);

        buttonStockName.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                checkConnectivity();
                stockDataService.getStockByTick(searchStock.getText().toString(), new StockDataService.StockByTickResponse() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(StocksActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(List<StockModel> stockModels) {
                        ArrayAdapter arrayAdapter = new ArrayAdapter(StocksActivity.this, android.R.layout.simple_list_item_1, stockModels);
                        listViewStocks.setAdapter(arrayAdapter);
                    }
                });

            }
        });


    }
    private void checkConnectivity() {

        ConnectivityManager cm =
                (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if(!isConnected) {
            Toast.makeText(this, "No internet connection", Toast.LENGTH_LONG).show();
        }
    }

}