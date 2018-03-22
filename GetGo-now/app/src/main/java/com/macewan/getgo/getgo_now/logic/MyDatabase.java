/**
 * Created by Michael on 2018-03-21.
 */
package com.macewan.getgo.getgo_now.logic;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class MyDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "databases/databases/getgo.db";
    private static final int DATABASE_VERSION = 1;
    // All Static variables
    // Database Version
    //private static final int DATABASE_VERSION = 1;

    // Database Name
    //private static final String DATABASE_NAME = "android_api";

    // Login table name
    private static final String TABLE_USER = "user";
    // Login Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_UID = "uid";
    private static final String KEY_CREATED_AT = "created_at";

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Storing user details in database
     * */
    public void addUser(String name, String email, String uid, String created_at) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name); // Name
        values.put(KEY_EMAIL, email); // Email
        values.put(KEY_UID, uid); // Email
        values.put(KEY_CREATED_AT, created_at); // Created At

        // Inserting Row
        long id = db.insert(TABLE_USER, null, values);
        db.close(); // Closing database connection

        ///Log.d(TAG, "New user inserted into sqlite: " + id);
    }

}