package jc.live.home;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import jc.live.R;
import jc.live.base.BaseActivity;
import jc.live.util.HttpUtil;

/**
 * 启动广告
 * @Author JC
 * @Date 2019-12-17
 * @Since 1.0.0
 */
public class AdvertismentStartActivity extends BaseActivity{

    private ImageView mAdvertismentStartPhoto;
    private String mAdvertismentStartUrl;
    private CountDownTimer mTimer;
    private TextView mSkip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdvertismentStartPhoto = findViewById(R.id.ad_start);
//        mAdvertismentStartPhoto.setOnClickListener(this);
        mSkip = findViewById(R.id.ad_start_skip);
//        mSkip.setOnClickListener(this);
        getAdvertismentStart();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_advertisment_start;
    }

    private void getAdvertismentStart(){

    }
}
