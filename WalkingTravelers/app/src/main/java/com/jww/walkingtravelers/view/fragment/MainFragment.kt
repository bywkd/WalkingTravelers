package com.jww.walkingtravelers.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.jww.walkingtravelers.R
import com.jww.walkingtravelers.base.BaseFragment
import com.jww.walkingtravelers.databinding.FragmentMainBinding

class MainFragment : BaseFragment() {

    private lateinit var binding: FragmentMainBinding


    companion object {
        fun newInstance(): MainFragment {
//            val fragment = MainFragment()
//            val args = Bundle()
//            fragment.arguments = args
            return MainFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(container!!.context),
            R.layout.fragment_main, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTabLayout()
    }

    private fun setTabLayout() {
        val tabLayoutLabel = arrayListOf(
            getString(R.string.tabL_Best),
            getString(R.string.tabL_Snapshot),
            getString(R.string.tabL_Favorites),
            getString(R.string.tabL_MyPage)
        )
        val tabLayout = binding.tabL
        tabLayout.apply {
            tabLayoutLabel.forEach {
                this.addTab(this.newTab().setText(it))
            }
        }
    }
}