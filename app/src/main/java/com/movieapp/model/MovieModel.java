package com.movieapp.model;

public class MovieModel
{
    private String title_movie;
    private String description_movie;
    private String studio;
    private String rating;
    private String streamingLink;
    private int thumbnail;
    private int coverPhoto;

    public MovieModel()
    {
    }

    public MovieModel(String title_movie, int thumbnail)
    {
        this.title_movie = title_movie;
        this.thumbnail = thumbnail;
    }

    public MovieModel(String title_movie, int thumbnail, int coverPhoto)
    {
        this.title_movie = title_movie;
        this.thumbnail = thumbnail;
        this.coverPhoto = coverPhoto;
    }

    public MovieModel(String title_movie, String description_movie, String studio, String rating, String streamingLink, int thumbnail, int coverPhoto)
    {
        this.title_movie = title_movie;
        this.description_movie = description_movie;
        this.studio = studio;
        this.rating = rating;
        this.streamingLink = streamingLink;
        this.thumbnail = thumbnail;
        this.coverPhoto = coverPhoto;
    }

    public String getTitle_movie() {
        return title_movie;
    }

    public void setTitle_movie(String title_movie) {
        this.title_movie = title_movie;
    }

    public String getDescription_movie() {
        return description_movie;
    }

    public void setDescription_movie(String description_movie) {
        this.description_movie = description_movie;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStreamingLink() {
        return streamingLink;
    }

    public void setStreamingLink(String streamingLink) {
        this.streamingLink = streamingLink;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(int coverPhoto) {
        this.coverPhoto = coverPhoto;
    }
}
