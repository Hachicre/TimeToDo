package com.example.nozomisugiyama.timetodo;

/**
 * Created by ryusei on 2016/11/18.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAdapter {
    static final String DATABASE_NAME = "switch.db";
    static final int DATABASE_VERSION = 1;

    /*
    public static final String TABLE_NAME = "notes";
    public static final String COL_ID = "_id";
    public static final String COL_NOTE = "note";
    public static final String COL_LASTUPDATE = "lastupdate";
    */

    public static final String TABLE_PLANS = "plans";
    public static final String COL_ID = "_id";
    public static final String COL_FROM = "time_from";
    public static final String COL_TO = "time_to";
    public static final String COL_TITLE = "title";
    public static final String COL_MEMO = "memo";

    public static final String DATE_TIME_FORMAT = "yyyy/MM/dd";

    protected final Context context;
    protected DatabaseHelper dbHelper;
    protected SQLiteDatabase db;

    public DBAdapter(Context context) {
        this.context = context;
        dbHelper = new DatabaseHelper(this.context);
    }

    //
    // SQLiteOpenHelper
    //

    private static class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            /*
            db.execSQL(
                    "CREATE TABLE " + TABLE_NAME + " ("
                            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                            + COL_NOTE + " TEXT NOT NULL,"
                            + COL_LASTUPDATE + " TEXT NOT NULL);");
            */


            db.execSQL(
                    "CREATE TABLE " + TABLE_PLANS + " ("
                            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                            + COL_FROM + " TEXT NOT NULL, "
                            + COL_TO + " TEXT NOT NULL, "
                            + COL_TITLE + " TEXT NOT NULL, "
                            + COL_MEMO + " TEXT"
                            + ");"
            );
        }

        @Override
        public void onUpgrade(
                SQLiteDatabase db,
                int oldVersion,
                int newVersion) {
            //db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLANS);
            onCreate(db);
        }

    }

    //
    // Adapter Methods
    //

    public DBAdapter open() {
        db = dbHelper.getWritableDatabase();
        return this;
    }


    public void close() {
        dbHelper.close();
    }


    //
    // App Methods
    //

    /*
    public boolean deleteAllNotes() {
        return db.delete(TABLE_NAME, null, null) > 0;
    }

    public boolean deleteNote(int id) {
        return db.delete(TABLE_NAME, COL_ID + "=" + id, null) > 0;
    }

    public Cursor getAllNotes() {
        return db.query(TABLE_NAME, null, null, null, null, null, null);
    }

    public void saveNote(String note) {
        Date dateNow = new Date();
        ContentValues values = new ContentValues();
        values.put(COL_NOTE, note);
        values.put(COL_LASTUPDATE, dateNow.toLocaleString());
        db.insertOrThrow(TABLE_NAME, null, values);
    }

    */

    public void savePlan(String from, String to, String title, String memo) {
        ContentValues values = new ContentValues();
        values.put(COL_FROM, from);
        values.put(COL_TO, to);
        values.put(COL_TITLE, title);
        values.put(COL_MEMO, memo);

        db.insertOrThrow(TABLE_PLANS, null, values);
    }

    public Cursor getAllPlans() {
        return db.query(TABLE_PLANS, null, null, null, null, null, null);
    }
}
