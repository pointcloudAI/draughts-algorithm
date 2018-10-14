package com.krystian.checkers.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class GameDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "GameDatabase";
    public static final int DATABASE_VERSION = 1;

    public GameDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.v("Db", "1");
        db.execSQL("CREATE TABLE STATS (_id INTEGER PRIMARY KEY AUTOINCREMENT, PLAYED INTEGER, WON INTEGER)"); //smthg wrong here
        Log.v("Db", "2");
        db.execSQL("CREATE TABLE GAMES (_id INTEGER PRIMARY KEY AUTOINCREMENT, NUMBER INTEGER, NAME TEXT, " +
                "WHITE TEXT, BROWN TEXT, BOARD TEXT)");
        Log.v("Db", "3");
        ContentValues stats = new ContentValues();
        stats.put("PLAYED", 0); //no games played yet
        stats.put("WON", 0);
        db.insert("STATS", null, stats);

        Log.v("DB created", "HERE!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}