package com.jww.walkingtravelers.base

import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.jww.walkingtravelers.model.UserLoginModel
import com.jww.walkingtravelers.net.ApiStore

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

    fun requestUser(auth: String, completeFun: ((UserLoginModel) -> Unit)) {
        ApiStore.getUser(auth).get().addOnSuccessListener {
            it.data?.let { data ->
                val userInfo = UserLoginModel()
                userInfo.apply {
                    uid = data["uid"].toString()
                    email = data["email"].toString()
                    gender = data["gender"].toString()
                    year = (data["year"] as Long).toInt()
                    month = (data["month"] as Long).toInt()
                    day = (data["day"] as Long).toInt()
                }
                completeFun(userInfo)
            }
        }.addOnFailureListener {
            it.printStackTrace()
        }
    }
}