package com.jww.walkingtravelers.utils

import android.app.Activity
import android.content.Intent
import android.os.Environment
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class BasicUtil {

    companion object {
        fun callCamera(activity: Activity): String {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            intent.resolveActivity(activity.packageManager)?.let {


                var photoFile: File? = null
                try {
                    photoFile = createImageFile(activity)
                    val imageFilePath = photoFile.absolutePath

                    photoFile?.let {
                        val photoURI = FileProvider.getUriForFile(
                            activity,
                            activity.packageName + ".provider",
                            it
                        )
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                        activity.startActivityForResult(intent, Constants.REQUEST_CAPTURE_IMAGE)
                        return imageFilePath
                    }


                } catch (e: Exception) {
                    e.printStackTrace()

                }
            }
            return ""
        }

        fun createImageFile(activity: Activity): File {
            val timeStamp = SimpleDateFormat("yyyMMdd_HHmm", Locale.getDefault()).format(Date())
            val imageFileName = "IMG_" + timeStamp + "_"
            val storageDir = activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            val image = File.createTempFile(imageFileName, ".jpg", storageDir)
            return image
        }
    }
}