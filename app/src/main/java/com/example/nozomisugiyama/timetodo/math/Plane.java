package com.example.nozomisugiyama.timetodo.math;

/**
 * Created by NozomiSugiyama on 2016/11/18.
 */

public class Plane {

    private Integer id = null;
    private long from;
    private long to;
    private String title;
    private String memo;

    Plane(){}

    Plane(long from, long to, String title, String memo) {
        this.from = from;
        this.to = to;
        this.title = title;
        this.memo = memo;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getFrom() {
        return from;
    }

    public void setFrom(long from) {
        this.from = from;
    }

    public long getTo() {
        return to;
    }

    public void setTo(long to) {
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
