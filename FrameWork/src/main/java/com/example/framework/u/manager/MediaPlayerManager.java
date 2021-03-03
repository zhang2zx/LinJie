package com.example.framework.u.manager;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.wifi.aware.PublishConfig;

import com.example.framework.u.utils.LogUtils;

import java.io.IOException;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

public class MediaPlayerManager
{
    //播放
    public static final int MEDIA_STATUS_PLAY = 0;
    //暂停
    public static final int MEDIA_STATUS_PAUSE = 1;
    //停止
    public static final int MEDIA_STATUS_STOP = 2;

    public static int MEDIA_STATUS = MEDIA_STATUS_STOP;

    private MediaPlayer mMediaPlayer;

    private static final int H_PROGRESS = 1000;

    private OnMusicProgressListener musicProgressListener;

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            switch (message.what){
                case H_PROGRESS:
                    if(musicProgressListener != null){
                        int currentPosition = getCurrentPosition();
                        int pos =(int) (((float)currentPosition / (float)getDuration()) *100);
                        musicProgressListener.OnProgress(currentPosition,pos);
                        mHandler.sendEmptyMessageDelayed(H_PROGRESS,1000);
                    }
                    break;
            }
            return false;
        }
    });

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
            mHandler.sendEmptyMessage(H_PROGRESS);
        } catch (IOException e) {
            LogUtils.e(e.toString());
            e.printStackTrace();
        }
    }

    public void pausePlay(){
        if(isPlaying()){
            mMediaPlayer.pause();
            MEDIA_STATUS = MEDIA_STATUS_STOP;
            mHandler.removeMessages(H_PROGRESS);
        }
    }
    public void continuePlay(){
        mMediaPlayer.start();
        MEDIA_STATUS = MEDIA_STATUS_PLAY;
        mHandler.sendEmptyMessage(H_PROGRESS);
    }

    public void stopPlay(){
        mMediaPlayer.stop();
        MEDIA_STATUS = MEDIA_STATUS_STOP;
        mHandler.removeMessages(H_PROGRESS);
    }

    public int getCurrentPosition(){
        return mMediaPlayer.getCurrentPosition();
    }

    public int getDuration(){
        return mMediaPlayer.getDuration();
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener listener){
        mMediaPlayer.setOnCompletionListener(listener);
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener listener){
        mMediaPlayer.setOnErrorListener(listener);

    }

    public void setOnProgressListener(OnMusicProgressListener listener){
        musicProgressListener = listener;
    }

    public interface OnMusicProgressListener{
        void OnProgress(int progress, int pos);
    }
}
