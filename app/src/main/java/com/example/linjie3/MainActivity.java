package com.example.linjie3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.framework.utils.LogUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LogUtils.info("start");
    }
}