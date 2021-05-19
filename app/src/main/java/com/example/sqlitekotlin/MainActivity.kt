package com.example.sqlitekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.sqlitekotlin.databinding.ActivityMainBinding
import com.example.sqlitekotlin.db.MyDbManager

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding
    lateinit var myDbManager: MyDbManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        myDbManager = MyDbManager(this)
    }

    override fun onResume() {
        super.onResume()
        myDbManager.openDB()
        for (title in myDbManager.getFromDb()) {
            bindingClass.tvTest.append(title)
            bindingClass.tvTest.append("\n")
        }
    }

    fun onClickSave(view: View) {
        bindingClass.tvTest.text = "" // это для очистки, чтоб не повторялись записи

        myDbManager.insertToDb(bindingClass.edTitle.text.toString(),
                              bindingClass.edDisc.text.toString())

        for ( title in myDbManager.getFromDb()) {
            bindingClass.tvTest.append(title)
            bindingClass.tvTest.append("\n")

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }
}