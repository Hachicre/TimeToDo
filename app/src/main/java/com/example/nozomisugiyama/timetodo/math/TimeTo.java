package com.example.nozomisugiyama.timetodo.math;

import android.content.Context;
import android.database.Cursor;

import com.example.nozomisugiyama.timetodo.DBAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NozomiSugiyama on 2016/11/18.
 */

public class TimeTo {

    private DBAdapter dbAdapter;

    public TimeTo(Context context){
        dbAdapter = new DBAdapter(context);
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param fromDate plan from date.
     * @param toDate plan to date.
     * @param title plan title.
     * @param memo plan memo.
     * @return boolean TRUE or FALSE.
     */
    public boolean addPlan(long fromDate, long toDate, String title, String memo) {
        try {
            dbAdapter.open();
            dbAdapter.savePlan(fromDate, toDate, title, memo);
            dbAdapter.close();
        } catch (Exception e) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }


    public List<Plane> getAllPlan () {
        Cursor allplans = dbAdapter.getAllPlans();
        allplans.moveToFirst();
        List<Plane> planes = new ArrayList<Plane>();
        dbAdapter.open();
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
        dbAdapter.close();
        return planes;
    }

    private long whatDays (long toDate, long fromDate){
        return  ( toDate - fromDate ) / (1000 * 60 * 60 * 24 );
    }
}
