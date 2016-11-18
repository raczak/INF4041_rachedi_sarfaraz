package com.rachedisarfaraz.project4a.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by zakariarachedi on 17/11/2016.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    public static final String PET_KEY = "id";
    public static final String PET_NAME = "name";
    public static final String PET_BIRTH_DATE = "birth_date";

    public static final String PET_TABLE_NAME = "pets";
    public static final String PET_TABLE_CREATE =
            "CREATE TABLE " + PET_TABLE_NAME + " (" +
                    PET_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    PET_NAME + " TEXT, " +
                    PET_BIRTH_DATE + " NUMERIC);";

    public static final String PET_TABLE_DROP = "DROP TABLE IF EXISTS " + PET_TABLE_NAME + ";";

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PET_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(PET_TABLE_DROP);
        onCreate(db);
    }
}
