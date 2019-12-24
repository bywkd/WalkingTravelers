package com.jww.walkingtravelers.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.jww.walkingtravelers.R
import com.jww.walkingtravelers.databinding.ItemBestMidBinding
import com.jww.walkingtravelers.viewModel.BestMidPagerAdapterVM

class BestMidPagerAdapter : PagerAdapter {
    private var imgList: ArrayList<Int> = arrayListOf()
    private var categoryList: ArrayList<Int>

    constructor(testCategory: ArrayList<Int>) {
        categoryList = testCategory
    }


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return imgList.size
    }

    fun setImageList(imgList: ArrayList<Int>) {
        this.imgList = imgList
        notifyDataSetChanged()
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding: ItemBestMidBinding = DataBindingUtil.inflate(
            LayoutInflater.from(container.context),
            R.layout.item_best_mid,
            container,
            false
        )
        binding.vm = BestMidPagerAdapterVM()
        binding.vm!!.apply {
            this.setImage(imgList[position % imgList.size])
            this.setCategory(categoryList[position % categoryList.size])
        }
        (container as ViewPager).addView(binding.root)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        (container as ViewPager).removeView(`object` as LinearLayout)
    }

    override fun getPageWidth(position: Int): Float {
        return 1f
    }

//    override fun getPageTitle(position: Int): CharSequence? {
//        return "sdf2"
//    }

}