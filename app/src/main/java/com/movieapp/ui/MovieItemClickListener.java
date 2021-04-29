package com.movieapp.ui;

import android.widget.ImageView;

import com.movieapp.model.MovieModel;

public interface MovieItemClickListener
{
    void onMovieClick(MovieModel movieModel , ImageView imageView);
}
