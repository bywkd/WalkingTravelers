package com.example.mvvmbasicproject.customBinding

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


object ImageViewBinding {

    @JvmStatic
    @BindingAdapter("bind:loadImgViewSrc")
    fun loadImgViewSrc(imgView: ImageView, resId: Int) {
        imgView.setImageResource(resId)
    }

    @JvmStatic
    @BindingAdapter("bind:loadGlide")
    fun loadGlide(imgView: ImageView, imgUrl: String?) {
        Glide.with(imgView.context).load(imgUrl).into(imgView)
    }

    @JvmStatic
    @BindingAdapter("bind:loadGlideSrc")
    fun loadGlide(imgView: ImageView, resId: Int) {
        Glide.with(imgView.context).load(resId).into(imgView)
    }

    @JvmStatic
    @BindingAdapter("bind:loadGlideDrawable")
    fun loadGlide(imgView: ImageView, drawable: Drawable) {
        Glide.with(imgView.context).load(drawable).into(imgView)
    }
}