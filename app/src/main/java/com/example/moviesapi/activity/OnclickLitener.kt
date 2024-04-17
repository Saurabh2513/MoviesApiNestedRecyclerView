package com.example.moviesapi.activity

import android.view.View
import com.example.moviesapi.model.MainModel

interface  OnclickLitener {
    fun onclick(position:Int,name:String)

    fun onLikeClick(item:MainModel,position: Int)
}