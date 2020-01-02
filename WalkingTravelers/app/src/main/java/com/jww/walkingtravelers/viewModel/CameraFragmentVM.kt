package com.jww.walkingtravelers.viewModel

import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.jww.walkingtravelers.utils.BasicUtil
import com.jww.walkingtravelers.utils.Constants
import com.jww.walkingtravelers.utils.Permissions.PermissionClass

class CameraFragmentVM : ViewModel {
    private var fragment: Fragment

    private var imagePath: String = ""

    constructor(fragment: Fragment) {
        this.fragment = fragment
    }

    fun onCameraClick() {
        if (!PermissionClass().isPermission(fragment.activity!!, Constants.cameraPermission)) {
            val intent = Intent(fragment.context, PermissionClass()::class.java)
            intent.putStringArrayListExtra(Constants.INTENT_PERMISSION, Constants.cameraPermission)
            fragment.startActivity(intent)
        } else {
            imagePath = BasicUtil.callCamera(fragment)
        }
    }

    fun getImagePath() = imagePath

}