package com.example.poonam.daan1;

/**
 * Created by Poonam on 27-01-2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

class DatabaseHelper extends SQLiteOpenHelper

{
    public static final String DATABASE_NAME= "user_database.db";
    public static final String TABLE_NAME= "user_accounts.db";
    public static final String COL_1= "name";
    public static final String COL_2= "email_id";
    public static final String COL_3= "aadhar_card_no";
    public static final String COL_4= "address";
    public static final String COL_5= "password";
    SQLiteDatabase db;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME + " (name TEXT not null, email_id TEXT not null, aadhar_card_no INTEGER PRIMARY KEY not null, address TEXT not null, password TEXT not null)");
    this.db=db;
    }

    public void insertContact(user_database userdb)
    {
       db =this.getWritableDatabase();
        ContentValues cv=new ContentValues();


        cv.put(COL_1,userdb.getName());
        cv.put(COL_2,userdb.getEmail());
        cv.put(COL_3,userdb.getAadhar());
        cv.put(COL_4,userdb.getAddress());
        cv.put(COL_5, userdb.getPassword());

        db.insert(TABLE_NAME, null, cv);
        db.close();

    }
    public String searchPass(String uname)
    {
        db=this.getReadableDatabase();
        String query="Select email,password from "+TABLE_NAME;
        db.execSQL(query);
        Cursor cursor=db.rawQuery(query,null);
        String a,b;
        b="not found";
        if(cursor.moveToFirst())
        {
            do {

                a = cursor.getString(2);

                if(a.equals(uname))
                {
                    b = cursor.getString(5);
                    break;
                }
            }while(cursor.moveToNext());

        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }
}



