package com.example.test_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.ArrayAdapter
import android.os.Looper
// import java.net.HttpURLConnection

import java.net.URL
import androidx.appcompat.app.AlertDialog
import javax.net.ssl.HttpsURLConnection

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
        getListFromServer()

       // MyThread().start()

        // 0-5 foreach
        for(i in 0..5){
            myItemList.add(MyItem("test222", R.mipmap.ic_launcher))
        }
        val listEle: ListView = findViewById(R.id.list)
        val adapterData = itemAdapter(this, R.layout.my_item, myItemList)
        listEle.adapter = adapterData
    }

    /**
     * get server data
     */
    private fun getListFromServer(){
        // 启用线程 不然会报错 不允许在主线程中发http / https
        Thread{
            val url = "https://www.baidu.com/"
            // var conn: HttpURLConnection? = null
            Looper.prepare() // 非主线程中没有开启Looper，而Handler对象必须绑定Looper对象需要调用Looper.prepare()来给线程创建一个消息循环，调用Looper.loop()来使消息循环起作用
            var conn: HttpsURLConnection? = null
            try{
                conn = URL(url).openConnection() as HttpsURLConnection
                conn.connect()
                conn.inputStream.use{ input ->
                    val data = input.bufferedReader().readText()
                    println(data)
                    alertMsg(data)
                }
              //  alertMsg("1")
            }catch(e: Exception){
                alertMsg("2")
                e.printStackTrace()
            }finally{
                conn?.disconnect()
            }
            Looper.loop() // 非主线程中没有开启Looper，而Handler对象必须绑定Looper对象需要调用Looper.prepare()来给线程创建一个消息循环，调用Looper.loop()来使消息循环起作用
        }.start()
    }

    private fun alertMsg(msg: String){
        val dialog = AlertDialog.Builder(this)
            .setIcon(R.drawable.ic_launcher_background)
            .setTitle("提示")
            .setMessage(msg)
        dialog.create().show()
    }
/*
    private inner class MyThread: Thread(){
        override fun run(){
          //  ListActivity().getListFromServer()
        }
    }
 */
}