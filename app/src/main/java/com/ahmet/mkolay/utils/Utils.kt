package com.ahmet.mkolay.utils

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.ahmet.mkolay.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


fun ImageView.downloadFromUrl(url:String, progressDrawable:CircularProgressDrawable){

    val option= RequestOptions()
        .placeholder(progressDrawable)
        .error(R.mipmap.ic_launcher)

    Glide.with(context)
        .setDefaultRequestOptions(option)
        .load(url)
        .into(this)
}

fun placeHolderProgressBar(context: Context):CircularProgressDrawable{
    return CircularProgressDrawable(context).apply {
        strokeWidth=8f
        centerRadius=40f
        start()
    }
}