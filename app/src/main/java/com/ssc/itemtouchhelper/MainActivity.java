package com.ssc.itemtouchhelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onSwipeDeleteListener(View view) {
        Intent intent = new Intent(MainActivity.this, SwipeDeleteActivity.class);
        startActivity(intent);
    }

    public void onLongDragListener(View view) {
        Intent intent = new Intent(MainActivity.this, LongDragActivity.class);
        startActivity(intent);
    }
}
