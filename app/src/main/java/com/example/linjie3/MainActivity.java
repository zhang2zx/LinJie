package com.example.linjie3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.framework.u.base.BaseUIActivity;
import com.example.framework.u.utils.LogUtils;
import com.example.framework.u.utils.SystemUI;
import com.example.framework.u.utils.TimeUtils;

public class MainActivity extends BaseUIActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        LogUtils.info("start");
//        LogUtils.info(TimeUtils.formatDuring(System.currentTimeMillis()));
//        SystemUI.fixUI(this);
    }
}