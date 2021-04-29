package com.movieapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.movieapp.R;
import com.movieapp.model.MovieModel;
import com.movieapp.ui.MovieItemClickListener;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>
{

    Context context;
    ArrayList<MovieModel> movieModels;
    MovieItemClickListener movieItemClickListener;

    public MovieAdapter(Context context, ArrayList<MovieModel> movieModels, MovieItemClickListener movieItemClickListener)
    {
        this.context = context;
        this.movieModels = movieModels;
        this.movieItemClickListener = movieItemClickListener;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie , parent , false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position)
    {
       MovieModel model = movieModels.get(position);
       holder.imageView.setImageResource(model.getThumbnail());
       holder.text_view_title.setText(model.getTitle_movie());
     //  holder.text_view_description.setText(model.getDescription_movie());
    }

    @Override
    public int getItemCount()
    {
        return movieModels.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
       TextView text_view_title; //  text_view_description;

        public MovieViewHolder(@NonNull View itemView)
        {
            super(itemView);

            imageView = itemView.findViewById(R.id.img_view_item_movie);
            text_view_title = itemView.findViewById(R.id.txt_view_item_movie);
            //text_view_description = itemView.findViewById(R.id.txt_view_description_item_movie);

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    movieItemClickListener.onMovieClick(movieModels.get(getAdapterPosition()) , imageView);
                }
            });
        }
    }
}
