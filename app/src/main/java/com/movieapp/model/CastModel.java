package com.movieapp.model;

public class CastModel
{
    private String name_cast;
    private int image_cast;

    public CastModel()
    {
    }

    public CastModel(int image_cast /* ,  String name_cast */)
    {
        this.image_cast = image_cast;
        //this.name_cast = name_cast;
    }

    public int getImage_cast() {
        return image_cast;
    }

   /* public String getName_cast() {
        return name_cast;
    } */

    public void setImage_cast(int image_cast) {
        this.image_cast = image_cast;
    }

   /* public void setName_cast(String name_cast) {
        this.name_cast = name_cast;
    } */
}
