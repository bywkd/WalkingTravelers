package com.jww.walkingtravelers.utils

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.os.Environment
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class ImageUtils {
    companion object {
        fun getRotateImageBitmap(imagePath: String): Bitmap? {
            try {
                val exif = ExifInterface(imagePath)
                val exifOrientation = exif.getAttributeInt(
                    ExifInterface.TAG_ORIENTATION,
                    ExifInterface.ORIENTATION_NORMAL
                )
                val exifDegree = exifOrientationToDegrees(exifOrientation)

                var imageBitmap = BitmapFactory.decodeFile(imagePath)
                imageBitmap = rotateBitmap(imageBitmap, exifDegree)
                return imageBitmap
            } catch (e: Exception) {
                e.printStackTrace()
                return null
            }
        }

        /**
         * EXIF정보를 회전각도로 변환하는 메서드
         *
         * @param exifOrientation EXIF 회전각
         * @return 실제 각도
         */
        private fun exifOrientationToDegrees(exifOrientation: Int): Int {
            return when (exifOrientation) {
                ExifInterface.ORIENTATION_ROTATE_90 -> {
                    90
                }
                ExifInterface.ORIENTATION_ROTATE_180 -> {
                    180
                }
                ExifInterface.ORIENTATION_ROTATE_270 -> {
                    270
                }
                else -> {
                    0
                }
            }
        }

        private fun rotateBitmap(bitmap: Bitmap, degrees: Int): Bitmap? {
            if (degrees != 0) {
                val m = Matrix()
                m.postRotate(degrees.toFloat())
                return try {
                    val converted =
                        Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, m, true)
                    if (bitmap != converted) {
                        bitmap.recycle()
                    }
                    converted
                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                    null
                }
            }
            return bitmap
        }

        /*기본 이미지 파일 저장 경로*/
        fun createImageFileFolder(activity: Activity): File {
            val timeStamp = SimpleDateFormat("yyyMMdd_HHmm", Locale.getDefault()).format(Date())
            val imageFileName = "IMG_${timeStamp}_"
            val storageDir = activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            val image = File.createTempFile(imageFileName, ".jpg", storageDir)
            return image
        }

        /*특정 이미지 파일 저장 경로*/
        fun createImageFileFolder(folderName: String): File? {
            return try {
                val dirPath =
                    Environment.getExternalStorageDirectory().absolutePath + "/" + folderName + "/"
                val dir = File(dirPath)
                if (!dir.exists()) {
                    dir.mkdir()
                }
                return File.createTempFile("IMG", ".jpg", dir)
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
                null
            }
        }
    }

}