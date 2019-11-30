package com.devendra_saroj.finduser.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
//import android.telecom.Call;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.devendra_saroj.finduser.ItemAdapter;
import com.devendra_saroj.finduser.R;
import com.devendra_saroj.finduser.api.Client;
import com.devendra_saroj.finduser.api.Server;
import com.devendra_saroj.finduser.model.Item;
import com.devendra_saroj.finduser.model.ItemResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    TextView disconnected;
    private Item item;
    private SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadJSON();
                Toast.makeText(MainActivity.this, "Github Users Refreshed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.smoothScrollToPosition(0);
        loadJSON();
    }

    private void loadJSON(){
        disconnected = (TextView) findViewById(R.id.disconnected);
        try {
            Client client = new Client();
            Server apiServer =Client.getClient().create(Server.class);
            Call<ItemResponse> call = apiServer.getItems();
            call.enqueue(new Callback<ItemResponse>() {
                @Override
                public void onResponse(Call<ItemResponse> call, Response<ItemResponse> response) {
                    List<Item> items = response.body().getItems();
                    ItemAdapter adapter = new ItemAdapter(getApplicationContext(), items);
                    recyclerView.setAdapter(adapter);
                    swipeRefreshLayout.setRefreshing(false);

                }

                @Override
                public void onFailure(Call<ItemResponse> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Error fetching data", Toast.LENGTH_SHORT).show();
                    disconnected.setVisibility(View.VISIBLE);

                }
            });
        }
        catch (Exception e) {
            Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
