package com.jww.walkingtravelers

import android.app.Application
import com.google.firebase.firestore.FirebaseFirestore

class WTApp : Application() {
    private var fireStore: FirebaseFirestore? = null

    override fun onCreate() {
        super.onCreate()
    }

    fun getDB(): FirebaseFirestore {
        fireStore?.let {
            return it
        }
        fireStore = FirebaseFirestore.getInstance()
        return fireStore!!
    }
}