package com.jww.walkingtravelers.viewModel

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import com.jww.walkingtravelers.utils.BasicUtil
import com.jww.walkingtravelers.utils.Constants
import com.jww.walkingtravelers.utils.Permissions.PermissionClass

class CameraFragmentVM : ViewModel {
    private var activity: FragmentActivity

    private var imagePath: String = ""

    constructor(activity: FragmentActivity) {
        this.activity = activity
    }

    fun onCameraClick() {
        if (!PermissionClass().isPermission(activity, Constants.cameraPermission)) {
            val intent = Intent(activity, PermissionClass()::class.java)
            intent.putStringArrayListExtra(Constants.INTENT_PERMISSION, Constants.cameraPermission)
            activity.startActivity(intent)
        } else {
            imagePath = BasicUtil.callCamera(activity)
        }
    }

    fun getImagePath() = imagePath


}