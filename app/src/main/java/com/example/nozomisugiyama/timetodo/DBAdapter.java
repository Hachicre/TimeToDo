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

    public static final String TABLE_COURSES_NAME = "courses";
    public static final String COL_COURSE_ID = "_id";
    public static final String COL_COURSE_NAME = "name";
    public static final String COL_COURSE_GIRLS_MONEY = "girls_money";
    public static final String COL_COURSE_SHOPS_MONEY = "shops_money";

    public static final String TABLE_SEGMENTS_NAME = "segments";
    public static final String COL_SEGMENT_ID = "_id";
    public static final String COL_SEGMENT_NAME = "name";
    public static final String COL_SEGMENT_GIRLS_MONEY = "girls_money";
    public static final String COL_SEGMENT_SHOPS_MONEY = "shops_money";

    public static final String TABLE_GIRLS_NAME = "girls";
    public static final String COL_GIRL_ID = "_id";
    public static final String COL_GIRL_NAME = "name";
    public static final String COL_GIRL_RANK_ID = "rank_id";

    public static final String TABLE_RANKS_NAME = "ranks";
    public static final String COL_RANK_ID = "_id";
    public static final String COL_RANK_NAME = "name";
    public static final String COL_RANK_GIRLS_MONEY = "girls_money";
    public static final String COL_RANK_SHOPS_MONEY = "shops_money";

    public static final String TABLE_OPTIONS_NAME = "options";
    public static final String COL_OPTION_ID = "_id";
    public static final String COL_OPTION_NAME = "name";
    public static final String COL_OPTION_GIRLS_MONEY = "girls_money";
    public static final String COL_OPTION_SHOPS_MONEY = "shops_money";

    public static final String TABLE_DISCOUNTS_NAME = "discounts";
    public static final String COL_DISCOUNT_ID = "_id";
    public static final String COL_DISCOUNT_NAME = "name";
    public static final String COL_DISCOUNT_GIRLS_MONEY = "girls_money";
    public static final String COL_DISCOUNT_SHOPS_MONEY = "shops_money";

    public static final String TABLE_ORDERS_NAME = "orders";
    public static final String COL_ORDER_ID = "_id";
    public static final String COL_ORDER_COURSE_ID = "course_id";
    public static final String COL_ORDER_GIRL_ID = "girl_id";
    public static final String COL_ORDER_SEGMENT_ID = "segmentation_id";
    public static final String COL_ORDER_GIRL_3P_ID = "girl_3p_id";
    public static final String COL_ORDER_SEGMENT_3P_ID = "segmentation_3p_id";
    public static final String COL_ORDER_DATE = "date";

    public static final String TABLE_ORDER_DISCOUNTS_NAME = "order_discount";
    public static final String COL_ORDER_DISCOUNT_ORDER_ID = "order_id";
    public static final String COL_ORDER_DISCOUNT_DISCOUNT_ID = "discount_id";

    public static final String TABLE_ORDER_OPTIONS__NAME = "order_option";
    public static final String COL_ORDER_OPTION_ORDER_ID = "order_id";
    public static final String COL_ORDER_OPTION_OPTION_ID = "option_id";

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
                    "CREATE TABLE " + TABLE_COURSES_NAME + " ("
                            + COL_COURSE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                            + COL_COURSE_NAME + " TEXT NOT NULL, "
                            + COL_COURSE_GIRLS_MONEY + " INTEGER NOT NULL, "
                            + COL_COURSE_SHOPS_MONEY + " INTEGER NOT NULL"
                            + ");"
            );

            db.execSQL(
                    "CREATE TABLE " + TABLE_SEGMENTS_NAME + " ("
                            + COL_SEGMENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                            + COL_SEGMENT_NAME + " TEXT NOT NULL, "
                            + COL_SEGMENT_GIRLS_MONEY + " INTEGER NOT NULL, "
                            + COL_SEGMENT_SHOPS_MONEY + " INTEGER NOT NULL"
                            + ");"
            );

            db.execSQL(
                    "CREATE TABLE " + TABLE_GIRLS_NAME + " ("
                            + COL_GIRL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                            + COL_GIRL_NAME + " TEXT NOT NULL, "
                            + COL_GIRL_RANK_ID + " INTEGER NOT NULL"
                            + ");"
            );

            db.execSQL(
                    "CREATE TABLE " + TABLE_RANKS_NAME + " ("
                            + COL_RANK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                            + COL_RANK_NAME + " TEXT NOT NULL, "
                            + COL_RANK_GIRLS_MONEY + " INTEGER NOT NULL, "
                            + COL_RANK_SHOPS_MONEY + " INTEGER NOT NULL"
                            + ");"
            );

            db.execSQL(
                    "CREATE TABLE " + TABLE_OPTIONS_NAME + " ("
                            + COL_OPTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                            + COL_OPTION_NAME + " TEXT NOT NULL, "
                            + COL_OPTION_GIRLS_MONEY + " INTEGER NOT NULL, "
                            + COL_OPTION_SHOPS_MONEY + " INTEGER NOT NULL"
                            + ");"
            );

            db.execSQL(
                    "CREATE TABLE " + TABLE_DISCOUNTS_NAME + " ("
                            + COL_DISCOUNT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                            + COL_DISCOUNT_NAME + " TEXT NOT NULL, "
                            + COL_DISCOUNT_GIRLS_MONEY + " INTEGER NOT NULL, "
                            + COL_DISCOUNT_SHOPS_MONEY + " INTEGER NOT NULL"
                            + ");"
            );

            db.execSQL(
                    "CREATE TABLE " + TABLE_ORDERS_NAME + " ("
                            + COL_ORDER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                            + COL_ORDER_COURSE_ID + " INTEGER NOT NULL, "
                            + COL_ORDER_GIRL_ID + " INTEGER NOT NULL, "
                            + COL_ORDER_SEGMENT_ID + " INTEGER NOT NULL, "
                            + COL_ORDER_GIRL_3P_ID + " INTEGER NULL, "
                            + COL_ORDER_SEGMENT_3P_ID + " INTEGER NULL, "
                            + COL_ORDER_DATE + " TEXT NOT NULL, " //ISO8601 表記の文字列("YYYY-MM-DD HH:MM:SS.SSS")

                            + "FOREIGN KEY(" + COL_ORDER_COURSE_ID + ") REFERENCES " + TABLE_COURSES_NAME + "(" + COL_COURSE_ID + "), "
                            + "FOREIGN KEY(" + COL_ORDER_GIRL_ID + ") REFERENCES " + TABLE_GIRLS_NAME + "(" + COL_GIRL_ID + "), "
                            + "FOREIGN KEY(" + COL_ORDER_SEGMENT_ID + ") REFERENCES " + TABLE_SEGMENTS_NAME + "(" + COL_SEGMENT_ID + "), "
                            + "FOREIGN KEY(" + COL_ORDER_GIRL_3P_ID + ") REFERENCES " + TABLE_GIRLS_NAME + "(" + COL_GIRL_ID + "), "
                            + "FOREIGN KEY(" + COL_ORDER_SEGMENT_3P_ID + ") REFERENCES " + TABLE_SEGMENTS_NAME + "(" + COL_SEGMENT_ID + ")"
                            + ");"
            );

            db.execSQL(
                    "CREATE TABLE " + TABLE_ORDER_DISCOUNTS_NAME + " ("
                            + COL_ORDER_DISCOUNT_ORDER_ID + " INTEGER NOT NULL, "
                            + COL_ORDER_DISCOUNT_DISCOUNT_ID + " INTEGER NOT NULL, "
                            + "FOREIGN KEY(" + COL_ORDER_DISCOUNT_ORDER_ID + ") REFERENCES " + TABLE_ORDERS_NAME + "(" + COL_ORDER_ID + "), "
                            + "FOREIGN KEY(" + COL_ORDER_DISCOUNT_DISCOUNT_ID + ") REFERENCES " + TABLE_DISCOUNTS_NAME + "(" + COL_DISCOUNT_ID + ")"
                            + ");"
            );

            db.execSQL(
                    "CREATE TABLE " + TABLE_ORDER_OPTIONS__NAME + " ("
                            + COL_ORDER_OPTION_ORDER_ID + " INTEGER NOT NULL, "
                            + COL_ORDER_OPTION_OPTION_ID + " INTEGER NOT NULL, "
                            + "FOREIGN KEY(" + COL_ORDER_OPTION_ORDER_ID + ") REFERENCES " + TABLE_ORDERS_NAME + "(" + COL_ORDER_ID + "), "
                            + "FOREIGN KEY(" + COL_ORDER_OPTION_OPTION_ID + ") REFERENCES " + TABLE_OPTIONS_NAME + "(" + COL_OPTION_ID + ")"
                            + ");"
            );
        }

        @Override
        public void onUpgrade(
                SQLiteDatabase db,
                int oldVersion,
                int newVersion) {
            //db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDER_OPTIONS__NAME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDER_DISCOUNTS_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDERS_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_COURSES_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_SEGMENTS_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_GIRLS_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_RANKS_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_OPTIONS_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_DISCOUNTS_NAME);
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

    public void saveTest(int couse, int girl, int segment, String date) {
        ContentValues values = new ContentValues();
        values.put(COL_ORDER_COURSE_ID, couse);
        values.put(COL_ORDER_GIRL_ID, girl);
        values.put(COL_ORDER_SEGMENT_ID, segment);
        values.put(COL_ORDER_DATE, date);

        db.insertOrThrow(TABLE_ORDERS_NAME, null, values);
    }

    public Cursor getAllOrder() {
        return db.query(TABLE_ORDERS_NAME, null, null, null, null, null, null);
    }
}
