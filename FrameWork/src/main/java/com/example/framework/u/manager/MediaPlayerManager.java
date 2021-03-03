package com.example.framework.u.manager;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.wifi.aware.PublishConfig;

import com.example.framework.u.utils.LogUtils;

import java.io.IOException;

public class MediaPlayerManager
{
    //播放
    public static final int MEDIA_STATUS_PLAY = 0;
    //暂停
    public static final int MEDIA_STATUS_PAUSE = 1;
    //停止
    public static final int MEDIA_STATUS_STOP = 2;

    public static int MEDIA_STATUS = MEDIA_STATUS_STOP;

    public MediaPlayer mMediaPlayer;

    public MediaPlayerManager(){
        mMediaPlayer = new MediaPlayer();
    }

    public boolean isPlaying(){
            return mMediaPlayer.isPlaying();
    }

    public void startPlay(AssetFileDescriptor path){
        try {
            mMediaPlayer.reset();
            mMediaPlayer.setDataSource(path);
            mMediaPlayer.prepare();
            mMediaPlayer.start();
            MEDIA_STATUS = MEDIA_STATUS_PLAY;
        } catch (IOException e) {
            LogUtils.e(e.toString());
            e.printStackTrace();
        }
    }

    public void pausePlay(){
        if(isPlaying()){
            mMediaPlayer.pause();
            MEDIA_STATUS = MEDIA_STATUS_STOP;
        }
    }
    public void continuePlay(){
        mMediaPlayer.start();
        MEDIA_STATUS = MEDIA_STATUS_PLAY;
    }

    public void stopPlay(){
        mMediaPlayer.stop();
        MEDIA_STATUS = MEDIA_STATUS_STOP;
    }


}
