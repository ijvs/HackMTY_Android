package com.hackmty.experience.ui;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.hackmty.experience.R;
import com.hackmty.experience.controller.RequestManager;
import com.hackmty.experience.controller.api.Experience;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MenuActivity extends AppCompatActivity {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.label)
    TextView label;

    @Bind(R.id.add)
    ImageView add;

    RequestManager requestManager;
    GenericAdapter adapter;
    ArrayList<Experience> experiences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        label.setText("Mis Experiencias");
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, AddExperienceActivity.class);
                startActivityForResult(intent, 500);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        requestManager = new RequestManager();
        experiences = new ArrayList<>();

        experiences.add(new Experience("Estadio", "",1200.0, R.drawable.cover1));
        experiences.add(new Experience("La Huasteca", "",1200.0, R.drawable.cover2));
        experiences.add(new Experience("Paseo Santa Lucía", "",1200.0, R.drawable.cover3));

        adapter = new GenericAdapter(this, experiences);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(MenuActivity.this, recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Experience experience = adapter.experiences.get(position);
                Intent intent = new Intent(MenuActivity.this, ExperienceDetailsActivity.class);
                if (experience.filePath == null || experience.filePath.equals(""))
                    intent.putExtra("resource_id", experience.image);
                else
                    intent.putExtra("resource_url", experience.filePath);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 500){
            Experience experience = new Gson().fromJson(data.getExtras().getString("experience"), Experience.class);
            experiences.add(experience);
            adapter.notifyItemInserted(experiences.size() - 1);
        }
    }
}
