package com.jww.walkingtravelers.viewModel

import androidx.lifecycle.ViewModel
import androidx.viewpager.widget.ViewPager
import com.jww.walkingtravelers.R
import com.jww.walkingtravelers.adapter.TabLPagerAdapter
import com.jww.walkingtravelers.contract.MainFragmentCon
import com.jww.walkingtravelers.view.fragment.BestFragment
import com.jww.walkingtravelers.view.fragment.CameraFragment
import com.jww.walkingtravelers.view.fragment.MyPageFragment
import com.jww.walkingtravelers.view.fragment.SnapshotFragment

class MainFragmentVM(contract: MainFragmentCon) : ViewModel() {
    private val tabLayoutLabel = arrayListOf(
        contract.getMainFragmentContext().getString(R.string.tabL_Best),
        contract.getMainFragmentContext().getString(R.string.tabL_Snapshot),
        contract.getMainFragmentContext().getString(R.string.tabL_Camera),
        contract.getMainFragmentContext().getString(R.string.tabL_MyPage)
    )
    private var fragmentList = arrayListOf(
        BestFragment().newInstance(),
        SnapshotFragment().newInstance(),
        CameraFragment().newInstance(),
        MyPageFragment().newInstance()
    )
    var currentPosition: Int = 0

    var adapter = TabLPagerAdapter(contract.getMainFragmentManager(), fragmentList, tabLayoutLabel)

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
        }
    }
}