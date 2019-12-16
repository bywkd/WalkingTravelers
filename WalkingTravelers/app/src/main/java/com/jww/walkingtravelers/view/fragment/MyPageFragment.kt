package com.jww.walkingtravelers.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.jww.walkingtravelers.R
import com.jww.walkingtravelers.base.BaseFragment
import com.jww.walkingtravelers.databinding.FragmentMyPageBinding

class MyPageFragment : BaseFragment() {

    private lateinit var binding: FragmentMyPageBinding
    fun newInstance(): MyPageFragment {
        val fragment = MyPageFragment()

        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            LayoutInflater.from(container!!.context),
            R.layout.fragment_my_page,
            container,
            false
        )

        return binding.root
    }
}