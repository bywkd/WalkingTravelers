package com.jww.walkingtravelers.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import com.jww.walkingtravelers.R
import com.jww.walkingtravelers.base.BaseFragment
import com.jww.walkingtravelers.contract.MainFragmentCon
import com.jww.walkingtravelers.databinding.FragmentMainBinding
import com.jww.walkingtravelers.viewModel.MainFragmentVM

class MainFragment : BaseFragment(), MainFragmentCon {

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
        binding.vm = MainFragmentVM(this)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getMainFragmentManager(): FragmentManager {
        return this.fragmentManager!!
    }

    override fun getMainFragmentContext(): Context {
        return activity as Context
    }

}