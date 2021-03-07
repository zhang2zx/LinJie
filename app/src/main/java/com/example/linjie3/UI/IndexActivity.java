package com.example.linjie3.UI;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;

import com.example.framework.u.utils.LogUtils;
import com.example.framework.u.utils.SpUtils;
import com.example.linjie3.MainActivity;
import com.example.linjie3.R;
import com.example.linjie3.entity.Constants;
import androidx.appcompat.app.AppCompatActivity;

//启动页

public class IndexActivity extends AppCompatActivity {
    private static final int SKIP_MAIN = 1000;
    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            switch (message.what){
                case SKIP_MAIN:
                 //   startMain();
                    startMainActivity();
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
        boolean isFirstApp = SpUtils.getInstance().getBoolean(Constants.SP_IS_FIRST_APP,true);
        Intent intent = new Intent();
        if(isFirstApp){
            //跳转到引导页
            intent.setClass(this,GuideActivity.class);
            //调整为非第一次启动
            SpUtils.getInstance().putBoolean(Constants.SP_IS_FIRST_APP,false);
        }else{
            //did login before?
            String token = SpUtils.getInstance().getString(Constants.SP_TOKEN,"");
            if(TextUtils.isEmpty(token)){
                //to login page
                intent.setClass(this,LoginActivity.class);
            }else{
                //to main page
                intent.setClass(this, MainActivity.class);
            }
        }
        startActivity(intent);
        finish();
    }

    private void startMainActivity() {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
