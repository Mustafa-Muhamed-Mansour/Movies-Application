package com.movieapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.movieapp.R;
import com.movieapp.model.SliderModel;
import com.smarteist.autoimageslider.SliderViewAdapter;
import java.util.ArrayList;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderViewHolder>
{

    Context context;
    ArrayList<SliderModel> sliderModels;

    public SliderAdapter(Context context, ArrayList<SliderModel> sliderModels)
    {
        this.context = context;
        this.sliderModels = sliderModels;
    }

    @Override
    public SliderViewHolder onCreateViewHolder(ViewGroup parent)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slider , parent , false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderViewHolder viewHolder, int position)
    {
       SliderModel model = sliderModels.get(position);
       viewHolder.imageView.setImageResource(model.getImage());
       viewHolder.textView.setText(model.getTitle());
    }

    @Override
    public int getCount()
    {
        return sliderModels.size();
    }

    public class SliderViewHolder extends SliderViewAdapter.ViewHolder
    {
        ImageView imageView;
        TextView textView;

        public SliderViewHolder(View itemView)
        {
            super(itemView);

            imageView = itemView.findViewById(R.id.img_view_item_slider);
            textView = itemView.findViewById(R.id.txt_view_title_item_slider);
        }
    }
}
