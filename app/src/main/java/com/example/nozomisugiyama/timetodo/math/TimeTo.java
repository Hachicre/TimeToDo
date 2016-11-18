package com.example.nozomisugiyama.timetodo.math;

import com.example.nozomisugiyama.timetodo.DBAdapter;

import java.util.Date;
/**
 * Created by NozomiSugiyama on 2016/11/18.
 */


public class TimeTo {

    public boolean addTimeTo(String title, String memo, long fromDate, long toDate) {
        
        return Boolean.TRUE;
    }

    private long whatDays (long toDate, long fromDate){
        return  ( toDate - fromDate ) / (1000 * 60 * 60 * 24 );
    }
}
