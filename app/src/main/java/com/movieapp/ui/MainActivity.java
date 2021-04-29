package com.movieapp.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.movieapp.R;
import com.movieapp.model.MovieModel;
import com.movieapp.model.SliderModel;
import com.movieapp.utils.MovieUtils;
import com.movieapp.utils.SliderUtils;
import com.movieapp.view.MovieAdapter;
import com.movieapp.view.SliderAdapter;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderView;
import java.util.ArrayList;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements MovieItemClickListener
{

    private SliderView sliderView;
    private SliderAdapter adapter;
    private MovieAdapter movieAdapter;
    private RecyclerView recycler_view_best_movie , recycler_view_week_movie;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViwes();
        getAdapter();

    }

    private void initViwes()
    {
        sliderView = findViewById(R.id.slider_view);
        recycler_view_best_movie = findViewById(R.id.r_v__best_movie);
        recycler_view_week_movie = findViewById(R.id.r_v_week_movie);
    }

    private void getAdapter()
    {
        sliderView.setIndicatorAnimation(IndicatorAnimations.DROP);
        adapter = new SliderAdapter(MainActivity.this , SliderUtils.getSliderMovies());
        sliderView.setSliderAdapter(adapter);

        movieAdapter = new MovieAdapter(MainActivity.this , MovieUtils.getMovieBest(), MainActivity.this);
        recycler_view_best_movie.setAdapter(movieAdapter);
        recycler_view_best_movie.setLayoutManager(new LinearLayoutManager(getApplicationContext() , RecyclerView.HORIZONTAL , false));

        movieAdapter = new MovieAdapter(MainActivity.this , MovieUtils.getMovieWeek() , MainActivity.this);
        recycler_view_week_movie.setAdapter(movieAdapter);
        recycler_view_week_movie.setLayoutManager(new LinearLayoutManager(getApplicationContext() , RecyclerView.HORIZONTAL , false));
    }

    @Override
    public void onMovieClick(MovieModel movieModel, ImageView imageView)
    {
        Intent intent = new Intent(getApplicationContext() , MovieDetailsActivity.class);
        intent.putExtra("title_movie" , movieModel.getTitle_movie());
        intent.putExtra("thumbnail" , movieModel.getThumbnail());
        intent.putExtra("coverPhoto" , movieModel.getCoverPhoto());

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this , imageView , "sharedElementName");
        startActivity(intent , options.toBundle());
    }
}