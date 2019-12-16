package com.jww.walkingtravelers.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.jww.walkingtravelers.base.BaseFragment
import com.jww.walkingtravelers.view.fragment.BestFragment
import com.jww.walkingtravelers.view.fragment.FavoritesFragment
import com.jww.walkingtravelers.view.fragment.MyPageFragment
import com.jww.walkingtravelers.view.fragment.SnapshotFragment

class TabLPagerAdapter : FragmentStatePagerAdapter {

    private val pageCount: Int
    private val titleLabel: ArrayList<String>
    private val pageFragment: ArrayList<BaseFragment>

    constructor(
        fm: FragmentManager,
        pageFragment: ArrayList<BaseFragment>,
        titleLabel: ArrayList<String>
    ) : super(fm) {
        this.pageFragment = pageFragment
        this.pageCount = pageFragment.size
        this.titleLabel = titleLabel

    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return (pageFragment[position] as BestFragment)
            }
            1 -> {
                return (pageFragment[position] as SnapshotFragment)
            }
            2 -> {
                return (pageFragment[position] as FavoritesFragment)
            }
            3 -> {
                return (pageFragment[position] as MyPageFragment)
            }
            else -> {
                return (pageFragment[position] as BestFragment)
            }
        }
    }

    override fun getCount(): Int {
        return pageCount
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titleLabel[position]
    }
}