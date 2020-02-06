package com.jww.walkingtravelers.utils.Permissions

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.jww.walkingtravelers.constants.Constants

class PermissionVM {

    private var activity: Activity
    private var contract: PermissionCon

    constructor(activity: Activity, contract: PermissionCon) {
        this.activity = activity
        this.contract = contract
    }

    fun requestPermission(permissionList: ArrayList<String>) {
        if (checkPermission(permissionList, true)) {
            contract.resultSuccess()
        }
    }

    private fun checkPermission(
        permissionList: ArrayList<String>,
        isNeedRequest: Boolean
    ): Boolean {

        val permissionNeedList: ArrayList<String> = arrayListOf()
        permissionList.forEach {
            val result = ContextCompat.checkSelfPermission(activity, it)
            if (result != PackageManager.PERMISSION_GRANTED) {
                permissionNeedList.add(it)
            }
        }

        if (permissionNeedList.isNotEmpty()) {
            if (isNeedRequest) {
                ActivityCompat.requestPermissions(
                    activity,
                    permissionNeedList.toTypedArray(),
                    Constants.REQUEST_PERMISSION
                )
            }
            return false
        }
        return true
    }

}