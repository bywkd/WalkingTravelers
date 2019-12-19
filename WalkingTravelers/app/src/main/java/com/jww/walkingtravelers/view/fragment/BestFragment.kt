package com.jww.walkingtravelers.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.jww.walkingtravelers.R
import com.jww.walkingtravelers.base.BaseFragment
import com.jww.walkingtravelers.databinding.FragmentBestBinding
import com.jww.walkingtravelers.viewModel.BestFragmentVM

class BestFragment : BaseFragment() {

    private lateinit var binding: FragmentBestBinding

    fun newInstance(): BestFragment {
        val fragment = BestFragment()
        return fragment
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            LayoutInflater.from(container!!.context),
            R.layout.fragment_best,
            container,
            false
        )
        binding.vm =
            BestFragmentVM(testImages, testCategory, binding.viewPagerMid01, binding.tablMid01)
//        val tab = binding.tablMid01
//        val viewPager = binding.viewPagerMid01!!
//
//        tab.setupWithViewPager(viewPager,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vm!!.setImage()

//        binding.tablMid01.setupWithViewPager(binding.flMid01,true)
    }


}