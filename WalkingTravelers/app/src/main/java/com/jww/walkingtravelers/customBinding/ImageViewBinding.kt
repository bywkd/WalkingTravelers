package com.example.mvvmbasicproject.customBinding

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target


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
        Glide.with(imgView.context).load(resId).override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
            .into(imgView)
    }

    @JvmStatic
    @BindingAdapter("bind:loadGlideDrawable")
    fun loadGlide(imgView: ImageView, drawable: Drawable) {
        Glide.with(imgView.context).load(drawable).into(imgView)
    }
}