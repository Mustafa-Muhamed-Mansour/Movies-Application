package com.movieapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.movieapp.R;

public class MoviePlayerActivity extends AppCompatActivity
{
    private PlayerView player_view;
    private SimpleExoPlayer simple_exo_player;
    private static String VIDEO_TEST = "https://i.imgur.com/7bMqysJ.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_player);

        getSupportActionBar().hide();


        initView();
        initExoPlayer();

    }


    private void initView()
    {
        player_view = findViewById(R.id.exo_player_video);
    }

    private void initExoPlayer()
    {
        simple_exo_player = ExoPlayerFactory.newSimpleInstance(MoviePlayerActivity.this);
        player_view.setPlayer(simple_exo_player);
        DataSource.Factory factory = new DefaultDataSourceFactory(MoviePlayerActivity.this ,
                Util.getUserAgent(MoviePlayerActivity.this , "name-application"));
        MediaSource source = new ExtractorMediaSource.Factory(factory)
                .createMediaSource(Uri.parse(VIDEO_TEST));
        simple_exo_player.prepare(source);
        simple_exo_player.setPlayWhenReady(true);
    }


    @Override
    public void onBackPressed()
    {
        super.onBackPressed();

        simple_exo_player.stop();
    }
}