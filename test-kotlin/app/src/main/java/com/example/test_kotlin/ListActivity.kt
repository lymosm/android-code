package com.example.test_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.ArrayAdapter

class ListActivity : AppCompatActivity(){
    private val myItemList = ArrayList<MyItem>()
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list)

       // setData()
        setAdapterData()
    }

    /**
     * set the list data
     */
    private fun setData(){
        val data = listOf("aaa", "bbb", "ccc")
        val listEle: ListView = findViewById(R.id.list)
        val adapterData = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        listEle.adapter = adapterData
    }

    /**
     * set the list item for image and text
     */
    private fun setAdapterData(){
        // 0-5 foreach
        for(i in 0..5){
            myItemList.add(MyItem("test222", R.mipmap.ic_launcher))
        }
        val listEle: ListView = findViewById(R.id.list)
        val adapterData = itemAdapter(this, R.layout.my_item, myItemList)
        listEle.adapter = adapterData
    }

    private fun getListFromServer(){

    }
}