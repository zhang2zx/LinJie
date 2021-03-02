package com.example.linjie3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.example.framework.utils.LogUtils;
import com.example.framework.utils.TimeUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LogUtils.info("start");
        LogUtils.info(TimeUtils.formatDuring(System.currentTimeMillis()));
    }
}