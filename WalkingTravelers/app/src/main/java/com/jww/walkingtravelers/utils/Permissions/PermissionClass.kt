package com.jww.walkingtravelers.utils.Permissions

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.jww.walkingtravelers.constants.Constants

class PermissionClass() : AppCompatActivity(),
    PermissionCon {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        intent?.let {
            val permissionList = it.getStringArrayListExtra(Constants.INTENT_PERMISSION)
            val vm = PermissionVM(this, this)
            permissionList?.let { list ->
                vm.requestPermission(list)
            }
        }

    }

    fun isPermission(activity: Activity, requestPermission: ArrayList<String>) =
        isCheckPermission(activity, requestPermission)

    private fun isCheckPermission(activity: Activity, permissionList: ArrayList<String>): Boolean {
        permissionList.forEach {
            val result = ContextCompat.checkSelfPermission(activity, it)
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == Constants.REQUEST_PERMISSION) {
            if (grantResults.isNotEmpty()) {
                var isAllPermission = true
                for (grant in grantResults) {
                    if (grant != PackageManager.PERMISSION_GRANTED) {
                        isAllPermission = false
                        break
                    }
                }
                if (isAllPermission) {
                    resultSuccess()
                } else {
                    resultFailed()
                }
            }
        }
    }

    override fun resultSuccess() {
        setResult(Activity.RESULT_OK)
        finish()
    }

    override fun resultFailed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }

}