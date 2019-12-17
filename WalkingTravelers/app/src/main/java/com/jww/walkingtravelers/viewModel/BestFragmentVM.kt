package com.jww.walkingtravelers.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.viewpager.widget.ViewPager
import com.jww.walkingtravelers.adapter.BestMidPagerAdapter

class BestFragmentVM(testImages: ArrayList<Int>) : ViewModel() {


    val adapter: BestMidPagerAdapter = BestMidPagerAdapter()
    private val testImages = testImages
    var currentPosition: Int = 0

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
        currentPosition = (testImages.size * 100) / 2
    }
}