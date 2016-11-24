package com.example.nozomisugiyama.timetodo.math;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.nozomisugiyama.timetodo.DBAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NozomiSugiyama on 2016/11/18.
 */

public class TimeTo {

    private DBAdapter dbAdapter = null;
    public TimeTo(Context context){
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


    public List<Plane> getAllPlan () {
        Cursor allplans = dbAdapter.getAllplans();
        allplans.moveToFirst();
        List<Plane> planes = new ArrayList<Plane>();
        for (int i = 0 ; i < allplans.getCount(); i++) {
            Plane plane = new Plane(
                    allplans.getInt(allplans.getColumnIndex(DBAdapter.COL_ID)),
                    allplans.getInt(allplans.getColumnIndex(DBAdapter.COL_FROM)),
                    allplans.getInt(allplans.getColumnIndex(DBAdapter.COL_TO)),
                    allplans.getString(allplans.getColumnIndex(DBAdapter.COL_TITLE)),
                    allplans.getString(allplans.getColumnIndex(DBAdapter.COL_MEMO))
            );
            planes.add(plane);
        }
        return planes;
    }

    private long whatDays (long toDate, long fromDate){
        return  ( toDate - fromDate ) / (1000 * 60 * 60 * 24 );
    }
}
