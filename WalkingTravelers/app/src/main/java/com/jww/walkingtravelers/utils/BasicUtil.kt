package com.jww.walkingtravelers.utils

import android.content.Intent
import android.provider.MediaStore
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import com.jww.walkingtravelers.constants.Constants
import java.io.File

class BasicUtil {

    companion object {

        fun callCamera(fragment: Fragment): String {
            var photoFile: File? = null
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            intent.resolveActivity(fragment.activity!!.packageManager)?.let {
                try {
                    photoFile = ImageUtils.createImageFileFolder(fragment.activity!!)
                    val imageFilePath = photoFile!!.absolutePath

                    photoFile?.let {
                        val photoURI = FileProvider.getUriForFile(
                            fragment.context!!,
                            "${fragment.activity!!.packageName}.provider",
                            it
                        )
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                        fragment.startActivityForResult(intent, Constants.REQUEST_CAPTURE_IMAGE)
                        return imageFilePath
                    }

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            return ""
        }


    }
}