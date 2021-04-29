package com.movieapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.movieapp.R;
import com.movieapp.model.CastModel;
import java.util.ArrayList;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastViewHolder>
{
    Context context;
    ArrayList<CastModel> castModels;

    public CastAdapter(Context context, ArrayList<CastModel> castModels)
    {
        this.context = context;
        this.castModels = castModels;
    }

    @NonNull
    @Override
    public CastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cast , parent , false);
        return new CastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CastViewHolder holder, int position)
    {
       CastModel model =  castModels.get(position);
       holder.imageView.setImageResource(model.getImage_cast());
    }

    @Override
    public int getItemCount()
    {
        return castModels.size();
    }

    class CastViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;

        public CastViewHolder(@NonNull View itemView)
        {
            super(itemView);

            imageView = itemView.findViewById(R.id.img_view_item_cast);
        }
    }
}
