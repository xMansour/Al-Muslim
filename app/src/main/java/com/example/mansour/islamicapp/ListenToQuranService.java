package com.example.mansour.islamicapp;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;
import java.io.IOException;


public class ListenToQuranService extends Service implements MediaPlayer.OnPreparedListener {
    private final IBinder mBinder = new LocalBinder();
    public static MediaPlayer mMediaPlayer = new MediaPlayer();
    SharedPreferences mSharedPrefrences;
    SharedPreferences.Editor mSharedPrefrencesEditor;
    // TODO:: Save The isPlaying boolean using shared preferences to prevent overlapping after closing the app.
    //Maybe it's not needed if we don't unbind the service.
    //Yes it's not.
    private String url;
    public static boolean isPlaying = false;
    // TODO:: i wanna save a time counter with the shared preferences to show the time spent playing Quran.

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        /*mSharedPrefrences = getSharedPreferences("ListeningService", MODE_PRIVATE);
        isPlaying = mSharedPrefrences.getBoolean("isPlaying", false);*/
        return mBinder;
    }

    public void handleUrl(String url) {
        if (isPlaying) {
            mMediaPlayer.reset();
            isPlaying = false;
        }

        mMediaPlayer.setOnPreparedListener(this);
        try {
            mMediaPlayer.setDataSource(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mMediaPlayer.prepareAsync();
        isPlaying = true;
        Toast.makeText(getApplicationContext(), "جارى الأتصال", Toast.LENGTH_LONG).show();
    }

    public void setUrl(String url) {
            this.url = url;
            handleUrl(url);

    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();/*
        mSharedPrefrences = getSharedPreferences("ListeningService", MODE_PRIVATE);
        mSharedPrefrencesEditor = mSharedPrefrences.edit();
        mSharedPrefrencesEditor.putBoolean("isPlaying", isPlaying);
        mSharedPrefrencesEditor.apply();*/
    }

    public class LocalBinder extends Binder {
        ListenToQuranService getService() {
            return ListenToQuranService.this;
        }
    }
}
