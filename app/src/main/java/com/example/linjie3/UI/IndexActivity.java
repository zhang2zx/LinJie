package com.example.linjie3.UI;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.linjie3.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//启动页

public class IndexActivity extends AppCompatActivity {
    private static final int SKIP_MAIN = 1000;
    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            switch (message.what){
                case SKIP_MAIN:
                    startMain();
                    break;
            }
            return false;
        }
    });


    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_index);

        mHandler.sendEmptyMessageDelayed(SKIP_MAIN,2*1000);
    }
//进入主页
    private void startMain() {
        //判断app是否第一次启动
        
    }
}
