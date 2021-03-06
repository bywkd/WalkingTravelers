package com.jww.walkingtravelers.view.fragment

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.jww.walkingtravelers.R
import com.jww.walkingtravelers.base.BaseFragment
import com.jww.walkingtravelers.databinding.FragmentCameraBinding
import com.jww.walkingtravelers.constants.Constants
import com.jww.walkingtravelers.utils.ImageUtils
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
        binding.vm = CameraFragmentVM(this)

        return binding.root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Constants.REQUEST_CAPTURE_IMAGE && resultCode == RESULT_OK) {
            try {
                val rotateBitmap = ImageUtils.getRotateImageBitmap(binding.vm!!.getImagePath())
                rotateBitmap?.let {
                    //                    binding.ivCamera.setImageBitmap(it)
                    Glide.with(binding.ivCamera.context).load(it)
                        .into(binding.ivCamera)
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}