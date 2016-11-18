package com.example.nozomisugiyama.timetodo.math;

import android.content.Context;

import com.example.nozomisugiyama.timetodo.DBAdapter;

/**
 * Created by NozomiSugiyama on 2016/11/18.
 */

public class TimeTo {

    private Context context;

    TimeTo (Context context){
        this.context = context;
    }

    public boolean addTimeTo(long fromDate, long toDate, String title, String memo) {
        DBAdapter dbAdapter = new DBAdapter(this.context);
        try {
            dbAdapter.savePlan(fromDate, toDate, title, memo);
        } catch (Exception e) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private long whatDays (long toDate, long fromDate){
        return  ( toDate - fromDate ) / (1000 * 60 * 60 * 24 );
    }
}
