package com.jww.walkingtravelers.base

import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

open class BaseActivity : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null

    override fun onStart() {
        super.onStart()
    }

    fun getAuth(): FirebaseAuth {
        mAuth?.let {
            return it
        } ?: let {
            mAuth = FirebaseAuth.getInstance()
            return mAuth!!
        }
    }
}