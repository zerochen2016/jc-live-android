package jc.live.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import jc.live.R;

public class HomeActivity extends AppCompatActivity {

    public static void forward(Context context) {
        Intent it = new Intent(context, HomeActivity.class);
        context.startActivity(it);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
