package jc.live.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import jc.live.R;
import jc.live.util.ActivityUtil;

/**
 * 启动图
 * @Author JC
 * @Date 2019-12-17
 * @Since 1.0.0
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);//隐藏状态栏
        getSupportActionBar().hide();//隐藏标题栏
        setContentView(R.layout.activity_splash);
        Thread myThread = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(3000);//休眠3秒
                    ActivityUtil.startActivity(getApplicationContext(),HomeActivity.class);
                    finish();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }

}
