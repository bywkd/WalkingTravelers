package com.jww.walkingtravelers.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.jww.walkingtravelers.R
import com.jww.walkingtravelers.base.BaseFragment
import com.jww.walkingtravelers.contract.BestFragmentCon
import com.jww.walkingtravelers.databinding.FragmentBestBinding
import com.jww.walkingtravelers.viewModel.BestFragmentVM

class BestFragment : BaseFragment(), BestFragmentCon {


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
            BestFragmentVM(testImages, testCategory, this)

        setMidTabLayout()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm!!.setImage()
    }

    override fun setPageChange(currentPosition: Int) {
        binding.tablMid01.getTabAt(currentPosition % testImages.size)?.select()
    }

    private fun setMidTabLayout() {
        binding.apply {
            testImages.forEach { _ ->
                this.tablMid01.addTab(this.tablMid01.newTab().setIcon(R.drawable.tab_selector))
            }

            val tabMidItems = this.tablMid01.getChildAt(0) as LinearLayout
            for (idx in 0 until tabMidItems.childCount) {
                tabMidItems.getChildAt(idx).setOnTouchListener { _, _ ->
                    true
                }
            }
        }
    }
}