package com.example.nozomisugiyama.timetodo.math;

import java.util.Date;

/**
 * Created by NozomiSugiyama on 2016/11/18.
 */


public class TimeTo {

    private long fromDate;
    private long toDate;
    private Date now;
    private String memo;

    TimeTo(Long fromDate, Long toDate) {
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public long whatDays (){
        return  ( this.toDate - this.fromDate ) / (1000 * 60 * 60 * 24 );
    }
}
