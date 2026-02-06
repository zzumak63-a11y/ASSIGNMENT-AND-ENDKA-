package com.example.proj.entity;

public class Song {
    private int id;
    private String title;
    private int duration;
    private int artistId; // Внешний ключ, чтобы знать, чья песня

    public Song() {}

    public Song(int id, String title, int duration, int artistId) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.artistId = artistId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public int getArtistId() { return artistId; }
    public void setArtistId(int artistId) { this.artistId = artistId; }
}