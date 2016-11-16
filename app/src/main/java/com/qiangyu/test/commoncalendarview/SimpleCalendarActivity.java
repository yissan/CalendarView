package com.qiangyu.test.commoncalendarview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.qiangyu.test.commoncalendarview.utils.DateUtils;
import com.qiangyu.test.commoncalendarview.view.CommonCalendarView;

public class SimpleCalendarActivity extends AppCompatActivity {

    private  CommonCalendarView calendarView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calendar);
        this.calendarView = (CommonCalendarView) findViewById(R.id.calendarView);
        this.calendarView.setMinDate(DateUtils.stringtoDate("1937-01-01","yyyy-MM-dd"));
        this.calendarView.setMaxDate(DateUtils.stringtoDate("2100-01-22","yyyy-MM-dd"));
        this.calendarView.init(null);
    }
}
