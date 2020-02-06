package com.jww.walkingtravelers.constants

import android.Manifest

class Constants {
    companion object {
        const val BEST_IMAGE_INFINITE_COUNT: Int = 1000


        const val REQUEST_CAPTURE_IMAGE: Int = 8000
        const val REQUEST_PERMISSION: Int = 8999


        /*퍼미션*/

        const val INTENT_PERMISSION: String = "permission"
        val storagePermission = arrayListOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )

        val cameraPermission = arrayListOf(
            Manifest.permission.INTERNET,
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
        val detectPermission = arrayListOf(
            Manifest.permission.CAMERA,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
        val locationPermission = arrayListOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
    }
}