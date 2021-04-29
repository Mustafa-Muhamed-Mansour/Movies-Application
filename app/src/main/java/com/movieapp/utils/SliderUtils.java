package com.movieapp.utils;

import com.movieapp.R;
import com.movieapp.model.SliderModel;

import java.util.ArrayList;

public class SliderUtils
{
    public static ArrayList<SliderModel> getSliderMovies()
    {
        ArrayList<SliderModel> sliderModels = new ArrayList<>();
        /* title & image msh 3aref lsa */ sliderModels.add(new SliderModel(R.drawable.slider1 , "Jhon Wick 3 \nOfficial Trailer"));
        /* title & image msh 3aref lsa */ sliderModels.add(new SliderModel(R.drawable.slider1 , "Detective Pikachu \nOfficial Trailer"));
        sliderModels.add(new SliderModel(R.drawable.slider2 , "Fantastic Beasts \nOfficial Review"));
        sliderModels.add(new SliderModel(R.drawable.slider1 , "The Wolverine 2013 \nOfficial Review"));
        /* title & image msh 3aref lsa */ sliderModels.add(new SliderModel(R.drawable.slider1 , "The Wolverine 2013 \nOfficial Review"));
        return sliderModels;
    }
}
