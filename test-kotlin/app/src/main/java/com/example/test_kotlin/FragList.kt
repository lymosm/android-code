package com.example.test_kotlin

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View

class FragList: Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedStateInstance: Bundle?) : View?{
        return inflater.inflate(R.layout.frag_list, container, false)
    }
}