package com.example.test_kotlin

import android.app.Activity
import android.widget.ArrayAdapter
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView

class itemAdapter(activity: Activity, private val resId: Int, data: List<MyItem>) : ArrayAdapter<MyItem>(activity, resId, data){
    override fun getView(position: Int, converterView: View?, parent: ViewGroup): View{
        val view = LayoutInflater.from(context).inflate(resId, parent, false)
        val myItem = getItem(position)
        val img: ImageView = view.findViewById(R.id.img)
        val txt: TextView = view.findViewById(R.id.txt)
        if(myItem != null){
            img.setImageResource(myItem.imageId)
            txt.text = myItem.name
        }
        return view
    }
}

class MyItem (val name: String, val imageId: Int){

}