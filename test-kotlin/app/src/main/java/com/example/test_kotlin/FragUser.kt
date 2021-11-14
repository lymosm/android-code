package com.example.test_kotlin

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.view.LayoutInflater

class FragUser: Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedStateInstance: Bundle?): View?{
        return inflater.inflate(R.layout.frag_user, container, false)
    }
}