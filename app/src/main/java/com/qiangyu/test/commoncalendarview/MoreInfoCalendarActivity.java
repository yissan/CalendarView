package com.qiangyu.test.commoncalendarview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.qiangyu.test.commoncalendarview.bean.ProductDatePrice;
import com.qiangyu.test.commoncalendarview.utils.RandomUtils;
import com.qiangyu.test.commoncalendarview.utils.StringUtils;
import com.qiangyu.test.commoncalendarview.view.CommonCalendarView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoreInfoCalendarActivity extends AppCompatActivity {

    private  CommonCalendarView calendarView;
    private Map<String,List> mYearMonthMap = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info_calendar);

        List<ProductDatePrice> mDatePriceList = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {//构造12个月每天的价格数据
            for (int j = 1; j <= 28; j++) {
                ProductDatePrice price = new ProductDatePrice();
                price.setPriceDate(String.format("2017-%s-%s", StringUtils.leftPad(String.valueOf(i), 2, "0"), StringUtils.leftPad(String.valueOf(j), 2, "0")));
                price.setPrice(RandomUtils.nextInt(1000));
                mDatePriceList.add(price);
            }
        }

        for (ProductDatePrice productDatePrice : mDatePriceList) {//把价格数据改为同一个月的list 在一个key value里，减少渲染界面时循环判断数量
            productDatePrice.getPriceDate();
            String yearMonth = TextUtils.substring(productDatePrice.getPriceDate(), 0, TextUtils.lastIndexOf(productDatePrice.getPriceDate(), '-'));
            List list = mYearMonthMap.get(yearMonth);
            if (list == null) {
                list = new ArrayList();
                list.add(productDatePrice);
                mYearMonthMap.put(yearMonth, list);
            } else {
                list.add(productDatePrice);
            }
        }

        this.calendarView = (CommonCalendarView) findViewById(R.id.calendarView);
        this.calendarView.init(new CommonCalendarView.DatePickerController() {
            @Override
            public int getMaxYear() {
                return 2018;
            }

            @Override
            public void onDayOfMonthSelected(int year, int month, int day) {
                Toast.makeText(MoreInfoCalendarActivity.this, String.format("%s-%s-%s", year,StringUtils.leftPad(String.valueOf(month),2,"0"),
                        StringUtils.leftPad(String.valueOf(day),2,"0")), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDayOfMonthAndDataSelected(int year, int month, int day, List obj) {
                if (obj==null){
                    return;
                }
                String priceDate = String.format("%s-%s-%s", year,
                        StringUtils.leftPad(month + "", 2, "0"), StringUtils.leftPad(String.valueOf(day), 2, "0"));
                for (int i = 0; i < obj.size(); i++) {
                    ProductDatePrice datePrice = (ProductDatePrice) obj.get(i);
                    if (datePrice==null){
                        continue;
                    }
                    if (TextUtils.equals(datePrice.getPriceDate(),priceDate)){
                        Toast.makeText(MoreInfoCalendarActivity.this, datePrice.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void showOtherFields(Object obj, View view, int gridItemYear, int gridItemMonth, int gridItemDay) {
                //当你设置了数据源之后，界面渲染会循环调用showOtherFields方法，在该方法中实现同一日期设置界面显示效果。
                ProductDatePrice productDatePrice  = (ProductDatePrice) obj;
                if (TextUtils.equals(productDatePrice.getPriceDate(), String.format("%s-%s-%s", gridItemYear,
                        StringUtils.leftPad(gridItemMonth + "", 2, "0"), StringUtils.leftPad(String.valueOf(gridItemDay), 2, "0")))) {
                    CommonCalendarView.GridViewHolder viewHolder = (CommonCalendarView.GridViewHolder) view.getTag();
                    viewHolder.mPriceTv.setText(String.format("¥ %s", productDatePrice.getPrice()));
                    view.setEnabled(true);
                    viewHolder.mTextView.setEnabled(true);
                }
            }

            @Override
            public Map<String, List> getDataSource() {
                return mYearMonthMap;
            }
        });
    }
}
