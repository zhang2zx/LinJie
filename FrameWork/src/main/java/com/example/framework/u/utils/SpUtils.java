package com.example.framework.u.utils;

import android.content.SharedPreferences;

public class SpUtils {

    private SharedPreferences sp;

    private SharedPreferences.Editor editor;

    private static volatile SpUtils mInstance = null;

    private SpUtils(){

    };

    public static SpUtils getInstance(){
        if(mInstance == null){
            synchronized (SpUtils.class) {
                if (mInstance == null) {
                    mInstance= new SpUtils();
                }
            }
        }
        return mInstance;
    }


    public boolean getBoolean(String key,boolean defValues){
        LogUtils.i("defValues: "+ String.valueOf(defValues));
        if(sp == null){
            LogUtils.e("sp null");
        }else{
            LogUtils.e("sp not null");
        }
        return sp.getBoolean(key , defValues);
    }

    public String getString(String key,String defValues){
        return sp.getString(key,defValues);
    }

    public void putBoolean(String key,boolean values){
        editor.putBoolean(key,values);
        editor.commit();
    }
}
