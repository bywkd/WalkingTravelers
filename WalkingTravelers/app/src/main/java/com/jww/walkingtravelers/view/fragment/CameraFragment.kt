package com.jww.walkingtravelers.view.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.jww.walkingtravelers.R
import com.jww.walkingtravelers.base.BaseFragment
import com.jww.walkingtravelers.databinding.FragmentCameraBinding
import com.jww.walkingtravelers.viewModel.CameraFragmentVM

class CameraFragment : BaseFragment() {
    private lateinit var binding: FragmentCameraBinding
    fun newInstance(): CameraFragment {
        val fragment = CameraFragment()

        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            LayoutInflater.from(container!!.context),
            R.layout.fragment_camera,
            container,
            false
        )
        binding.vm = CameraFragmentVM(this.activity!!)

        return binding.root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("Won","onActivityResult")
    }
}