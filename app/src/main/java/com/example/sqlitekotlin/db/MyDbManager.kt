package com.example.sqlitekotlin.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class MyDbManager(context: Context) {
    lateinit var context: Context
    lateinit var db: SQLiteDatabase
     var myDbHelper: MyDbHelper = MyDbHelper(context)

    fun openDB() { // функция для открытия базы данных
        db = myDbHelper.writableDatabase
    }
    fun insertToDb(title:String, discription:String) { // тут будет все записываться в базу данных
         val cv = ContentValues().apply {
             put(MyConstance.TITLE, title)
             put(MyConstance.DISCRIPTION, discription)
         }
       val newRowId =  db.insert(MyConstance.TABLE_NAME, null, cv)
    }
    fun getFromDb(): List<String> {
        val tempList = arrayListOf<String>()
        val cursor: Cursor = db.query(MyConstance.TABLE_NAME, null, null,
            null, null,null,null)

        while (cursor.moveToNext()) {
            val title: String = cursor.getString(cursor.getColumnIndex(MyConstance.TITLE))
            tempList.add(title)
        }
        cursor.close()
        return  tempList
    }
    fun closeDb() {
        myDbHelper.close()
    }
}













