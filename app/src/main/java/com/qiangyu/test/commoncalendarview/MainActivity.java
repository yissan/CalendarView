package com.qiangyu.test.commoncalendarview;

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

    public void simpleView(View view) {
        Intent intent = new Intent(this,SimpleCalendarActivity.class);
        startActivity(intent);

    }

    public void showOtherInfo(View view) {
        Intent intent = new Intent(this, MoreInfoCalendarActivity.class);
        startActivity(intent);
    }
}
