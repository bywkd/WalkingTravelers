package com.jww.walkingtravelers.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.jww.walkingtravelers.R
import com.jww.walkingtravelers.databinding.ItemBestMidBinding

class BestMidPagerAdapter : PagerAdapter() {
    private var imgList: ArrayList<Int> = arrayListOf()


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return (imgList.size * 100)
    }

    fun setImageList(imgList: ArrayList<Int>) {
        this.imgList = imgList
        Log.d("Won", "image Size = ${imgList.size}")
        notifyDataSetChanged()
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding: ItemBestMidBinding = DataBindingUtil.inflate(
            LayoutInflater.from(container.context),
            R.layout.item_best_mid,
            container,
            false
        )
        (container as ViewPager).addView(binding.root)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        (container as ViewPager).removeView(`object` as LinearLayout)
    }

    override fun getPageWidth(position: Int): Float {
        return 1f
    }
}