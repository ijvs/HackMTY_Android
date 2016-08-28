package com.hackmty.experience.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.hackmty.experience.R;
import com.hackmty.experience.controller.RequestManager;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MenuActivity extends AppCompatActivity {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    RequestManager requestManager;
    GenericAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        requestManager = new RequestManager();


    }

}
