package com.jww.walkingtravelers.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.jww.walkingtravelers.adapter.BestMidPagerAdapter

class BestFragmentVM(
    testImages: ArrayList<Int>,
    testCategory: ArrayList<Int>,
    viewPager: ViewPager,
    tabLayout: TabLayout
) : ViewModel() {


    val adapter: BestMidPagerAdapter = BestMidPagerAdapter(testCategory)
    private val testImages = testImages
    var currentPosition: Int = 0
    val viewPager = viewPager
    private val tabLayout = tabLayout

    var pageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {
        }

        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
        }

        override fun onPageSelected(position: Int) {
            Log.d("Won", "position = $position")
            currentPosition = position
        }
    }

    fun setImage() {
        adapter.setImageList(testImages)
        currentPosition = (testImages.size )
//        currentPosition = (testImages.size * 100) / 2

//        tabLayout.setupWithViewPager(viewPager)
    }
}