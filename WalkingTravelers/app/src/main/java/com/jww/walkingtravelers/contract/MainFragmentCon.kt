package com.jww.walkingtravelers.contract

import android.content.Context
import androidx.fragment.app.FragmentManager

interface MainFragmentCon {
    fun getMainFragmentManager(): FragmentManager

    fun getMainFragmentContext(): Context
}