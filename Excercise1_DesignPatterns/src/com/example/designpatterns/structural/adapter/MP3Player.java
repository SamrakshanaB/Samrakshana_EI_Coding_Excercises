package com.example.designpatterns.structural.adapter;

public class MP3Player implements MediaPlayer {
    @Override
    public void play(String filename, String filetype) {
        if(filetype.equalsIgnoreCase("mp3")) {
            System.out.println("Playing MP3 file: " + filename);
        } else {
            System.out.println("MP3Player cannot play " + filetype + " file.");
        }
    }
}
