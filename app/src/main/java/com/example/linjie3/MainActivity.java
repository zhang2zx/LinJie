package com.example.linjie3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.os.Bundle;

import com.example.framework.u.base.BaseUIActivity;
import com.example.framework.u.manager.MediaPlayerManager;
import com.example.framework.u.utils.LogUtils;
import com.example.framework.u.utils.SystemUI;
import com.example.framework.u.utils.TimeUtils;

public class MainActivity extends BaseUIActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //logtest
//        LogUtils.info("start");
//        LogUtils.info(TimeUtils.formatDuring(System.currentTimeMillis()));
//        SystemUI.fixUI(this);

        //misuc test
//        MediaPlayerManager mediaPlayerManager = new MediaPlayerManager();
//        AssetFileDescriptor fileDescriptor = getResources().openRawResourceFd(R.raw.music);
//        mediaPlayerManager.startPlay(fileDescriptor);
//
//        mediaPlayerManager.setOnProgressListener(new MediaPlayerManager.OnMusicProgressListener() {
//            @Override
//            public void OnProgress(int progress,int pos) {
//                LogUtils.e("p:"+pos);
//            }
//        });
    }
}