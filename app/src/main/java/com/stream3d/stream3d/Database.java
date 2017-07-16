package com.stream3d.stream3d;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "users.db";
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_NAME = "name";
    private SQLiteDatabase db;
    private static final String COLUMN_USER = "username";
    private static final String COLUMN_PASSWORD = "password";

    private static final String TABLE_CREATE = "create table " + TABLE_NAME + " (id integer primary key not null auto_increment , " +
            "name text not null, username text not null, password text not null)";

    Database(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    void insertUser(Users u)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, u.getName());
        values.put(COLUMN_PASSWORD, u.getPassword());
        values.put(COLUMN_USER, u.getUser());

        db.insert(TABLE_NAME, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
