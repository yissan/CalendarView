# CalendarView
This is a view implemented with ViewPager and GridView,You can use it to display a normal calendar or show other info on the calendar(example price ..)


#simple show calendar view
![这里写图片描述](http://img.blog.csdn.net/20161118102720492)

#more info calendar view
![这里写图片描述](http://img.blog.csdn.net/20161118102803039)

#gif
![这里写图片描述](http://img.blog.csdn.net/20161118102857863)

#simple usage

1、declare view in .xml
```
 <com.qiangyu.test.commoncalendarview.view.CommonCalendarView
        android:id="@+id/calendarView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
    </com.qiangyu.test.commoncalendarview.view.CommonCalendarView>
```
2、get CalendarView and init it
```
public class SimpleCalendarActivity extends AppCompatActivity {

    private  CommonCalendarView calendarView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calendar);
        this.calendarView = (CommonCalendarView) findViewById(R.id.calendarView);
        this.calendarView.setMinDate(DateUtils.stringtoDate("1937-01-01","yyyy-MM-dd"));//minimum date for calendarview to show;
        this.calendarView.setMaxDate(DateUtils.stringtoDate("2100-01-22","yyyy-MM-dd"));//max date for calendarview to show;
        this.calendarView.init(null);
    }
}

```
