package com.movieapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.movieapp.R;
import com.movieapp.model.CastModel;
import com.movieapp.utils.CastUtils;
import com.movieapp.view.CastAdapter;

import java.util.ArrayList;

public class MovieDetailsActivity extends AppCompatActivity
{
    private ImageView image_view_film , image_view_cover;
    private TextView textViewTitle;
    private Intent intent;
    private FloatingActionButton floating_action_button;
    private RecyclerView recyclerView;
    private CastAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);


        initViews();
        clickFloatingActionButton();
        initIntent();
        animationViews();
        getAdapter();
    }

    private void initViews()
    {
        image_view_film = findViewById(R.id.img_view_movie_details_film);
        image_view_cover = findViewById(R.id.img_view_movie_details_cover);
        textViewTitle = findViewById(R.id.txt_view_title_movie_details);
        floating_action_button = findViewById(R.id.fab_play_movie_details);
        recyclerView = findViewById(R.id.r_v_horizontal_movie_details);
    }

    private void clickFloatingActionButton()
    {
        floating_action_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(getApplicationContext() , MoviePlayerActivity.class));
            }
        });
    }

    private void initIntent()
    {
        intent = getIntent();
        String title_intent = intent.getExtras().getString("title_movie");
        int image_intent = intent.getExtras().getInt("thumbnail");
        int cover_image = intent.getExtras().getInt("coverPhoto");

        textViewTitle.setText(title_intent);
        Glide.with(MovieDetailsActivity.this)
                .load(image_intent)
                .into(image_view_film);
        Glide.with(MovieDetailsActivity.this)
                .load(cover_image)
                .into(image_view_cover);

        getSupportActionBar().setTitle(title_intent);
    }

    private void animationViews()
    {
        image_view_cover.setAnimation(AnimationUtils.loadAnimation(MovieDetailsActivity.this , R.anim.animation));
        floating_action_button.setAnimation(AnimationUtils.loadAnimation(MovieDetailsActivity.this , R.anim.animation));
    }

    private void getAdapter()
    {
        adapter = new CastAdapter(MovieDetailsActivity.this , CastUtils.getCastFilm());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext() , RecyclerView.HORIZONTAL , false));
    }
}