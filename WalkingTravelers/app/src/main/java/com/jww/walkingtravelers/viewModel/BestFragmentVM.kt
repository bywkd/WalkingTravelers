package com.jww.walkingtravelers.viewModel

import androidx.lifecycle.ViewModel
import androidx.viewpager.widget.ViewPager
import com.jww.walkingtravelers.adapter.BestMidPagerAdapter

class BestFragmentVM(
    testImages: ArrayList<Int>,
    testCategory: ArrayList<Int>
) : ViewModel() {

    val adapter: BestMidPagerAdapter = BestMidPagerAdapter(testCategory)
    private val testImages = testImages
    var currentPosition: Int = 0

    var pageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {

            if(state == ViewPager.SCROLL_STATE_IDLE)
            {

            }
        }

        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
        }

        override fun onPageSelected(position: Int) {
            currentPosition = when (position) {
                0 -> adapter.count
                adapter.count + 1 -> 1
                else -> position - 1
            }
        }
    }

    fun setImage() {
        adapter.setImageList(testImages)
        currentPosition = testImages.size / 2
    }

}