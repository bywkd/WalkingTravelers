package com.jww.walkingtravelers.viewModel

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import com.jww.walkingtravelers.utils.BasicUtil

class CameraFragmentVM : ViewModel {
    private var activity: FragmentActivity

    private var imagePath: String = ""

    constructor(activity: FragmentActivity) {
        this.activity = activity
    }

    fun onCameraClick() {
        imagePath = BasicUtil.callCamera(activity)
    }

    fun getImagePath() = imagePath


}