package com.example.nozomisugiyama.timetodo.math;

import android.content.Context;
import android.database.Cursor;

import com.example.nozomisugiyama.timetodo.DBAdapter;

/**
 * Created by NozomiSugiyama on 2016/11/18.
 */

public class TimeTo {

    private DBAdapter dbAdapter = null;
    TimeTo (Context context){
        dbAdapter = new DBAdapter(context);
    }

    public boolean addPlan(long fromDate, long toDate, String title, String memo) {
        try {
            dbAdapter.savePlan(fromDate, toDate, title, memo);
        } catch (Exception e) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }


    public getAllPlan() {
        Cursor allplans = dbAdapter.getAllplans();
        allplans.getLong(allplans.getColumnIndex("_id"));
        allplans.getInt(allplans.getColumnIndex("from"));
        allplans.getInt(allplans.getColumnIndex("to"));
        allplans.getString(allplans.getColumnIndex("title"));
        allplans.getString(allplans.getColumnIndex("memo"));
    }

    private long whatDays (long toDate, long fromDate){
        return  ( toDate - fromDate ) / (1000 * 60 * 60 * 24 );
    }
}
