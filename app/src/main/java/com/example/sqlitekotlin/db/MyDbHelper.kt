package com.example.sqlitekotlin.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDbHelper(context: Context):SQLiteOpenHelper(context, MyConstance.DB_NAME, null, MyConstance.DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(MyConstance.TABLE_STRUCTURE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(MyConstance.DROP_TABLE)
        onCreate(db)
    }
}














