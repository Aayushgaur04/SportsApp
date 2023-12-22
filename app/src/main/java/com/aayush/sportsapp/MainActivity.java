package com.aayush.sportsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener{

    private RecyclerView recyclerView;
    private List<Sport> sportList;
    private CustomAdaptor adaptor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        sportList = new ArrayList<>();

        Sport s1 = new Sport("FootBall",R.drawable.football);
        Sport s2 = new Sport("BasketBall",R.drawable.basketball);
        Sport s3 = new Sport("Ping Pong",R.drawable.ping);
        Sport s4 = new Sport("Tennis",R.drawable.tennis);
        Sport s5 = new Sport("VolleyBall",R.drawable.volley);

        sportList.add(s1);
        sportList.add(s2);
        sportList.add(s3);
        sportList.add(s4);
        sportList.add(s5);

        adaptor = new CustomAdaptor(sportList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptor);

        adaptor.setClickListener(this);
    }

    @Override
    public void onClick(View v, int pos) {
        Toast.makeText(this, "You choose: " + sportList.get(pos).getSportName(), Toast.LENGTH_SHORT).show();
    }
}