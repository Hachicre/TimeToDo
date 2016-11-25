package com.example.nozomisugiyama.timetodo.math;

import com.example.nozomisugiyama.timetodo.DBAdapter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by NozomiSugiyama on 2016/11/18.
 */

public class Plane {

    private Integer id;
    private String from;
    private String to;
    private String title;
    private String memo;

    Plane(){}

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param id database _id.
     * @param from datetime from.
     * @param to datetime to.
     * @param title plane title.
     * @param memo plane memo.
     * @return A new instance of Plane.
     */
    Plane(int id, String from, String to, String title, String memo) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.title = title;
        this.memo = memo;

    }

    public String whatDays (){
        return dayChange(this.from, this.to);
    }

    public String fromToNow (){
        DateFormat df = new SimpleDateFormat(DBAdapter.DATE_TIME_FORMAT);
        Date date = new Date(System.currentTimeMillis());
        return dayChange(this.from, df.format(date));
    }

    private String dayChange(String from, String to){
        SimpleDateFormat sdf = new SimpleDateFormat(DBAdapter.DATE_TIME_FORMAT);
        Date dateTo = null;
        Date dateFrom = null;

        // 日付を作成します。
        try {
            dateFrom = sdf.parse(from);
            dateTo = sdf.parse(to);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 日付をlong値に変換します。
        long dateTimeTo = dateTo.getTime();
        long dateTimeFrom = dateFrom.getTime();

        // 差分の日数を算出します。
        long dayDiff = ( dateTimeTo - dateTimeFrom  ) / (1000 * 60 * 60 * 24 );
        return String.valueOf(dayDiff);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

}
