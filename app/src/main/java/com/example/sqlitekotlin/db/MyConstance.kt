package com.example.sqlitekotlin.db
object MyConstance {
    const val TABLE_NAME = "my_table"
    const val _ID = "_id"
    const val TITLE = "title"
    const val DISCRIPTION = "discription"
    const val DB_NAME = "my_db.db"
    const val DB_VERSION = 2
    const val TABLE_STRUCTURE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
            "$_ID INTEGER PRIMARY KEY, " +
            "$TITLE TEXT," +
            "$DISCRIPTION TEXT)"
    const val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
}