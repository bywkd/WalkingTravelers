package com.jww.walkingtravelers.viewModel

import androidx.lifecycle.ViewModel
import androidx.viewpager.widget.ViewPager
import com.jww.walkingtravelers.adapter.BestMidPagerAdapter
import com.jww.walkingtravelers.contract.BestFragmentCon

class BestFragmentVM(
    private val testImages: ArrayList<Int>,
    testCategory: ArrayList<Int>,
    private val contract: BestFragmentCon
) : ViewModel() {

    val adapter: BestMidPagerAdapter = BestMidPagerAdapter(testCategory)
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
            currentPosition = position
            contract.setPageChange(currentPosition)
        }
    }

    fun setImage() {
        adapter.setImageList(testImages)
        currentPosition = adapter.count / 2
        contract.setPageChange(currentPosition)
    }

}