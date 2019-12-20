package jc.live.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import jc.live.R;
import jc.live.base.BaseActivity;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }
}
