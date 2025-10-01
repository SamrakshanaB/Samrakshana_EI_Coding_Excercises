package com.example.designpatterns.structural.adapter;

public class AdvancedPlayer {
    public void playMp4(String filename) {
        System.out.println("Playing MP4 file: " + filename);
    }

    public void playVlc(String filename) {
        System.out.println("Playing VLC file: " + filename);
    }
}
