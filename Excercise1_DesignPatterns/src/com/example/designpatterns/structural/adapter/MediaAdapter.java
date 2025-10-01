package com.example.designpatterns.structural.adapter;

public class MediaAdapter implements MediaPlayer {
    private AdvancedPlayer advancedPlayer;

    public MediaAdapter() {
        advancedPlayer = new AdvancedPlayer();
    }

    @Override
    public void play(String filename, String filetype) {
        switch(filetype.toLowerCase()) {
            case "mp4" -> advancedPlayer.playMp4(filename);
            case "vlc" -> advancedPlayer.playVlc(filename);
            default -> System.out.println("Unsupported file type: " + filetype);
        }
    }
}
