package com.example.model;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    public int id;

    private String songName;

    private String singer;

    private String typeSong;

    private String linkSong;

    public Song() {
    }

    public Song(String songName, String singer, String typeSong, String linkSong) {
        this.songName = songName;
        this.singer = singer;
        this.typeSong = typeSong;
        this.linkSong = linkSong;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTypeSong() {
        return typeSong;
    }

    public void setTypeSong(String typeSong) {
        this.typeSong = typeSong;
    }

    public String getLinkSong() {
        return linkSong;
    }

    public void setLinkSong(String linkSong) {
        this.linkSong = linkSong;
    }
}
