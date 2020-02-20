package com.jww.walkingtravelers.view.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.jww.walkingtravelers.R
import com.jww.walkingtravelers.base.BaseActivity
import com.jww.walkingtravelers.constants.Constants
import com.jww.walkingtravelers.contract.SignInCon
import com.jww.walkingtravelers.databinding.ActivitySignInBinding
import com.jww.walkingtravelers.model.UserLoginModel
import com.jww.walkingtravelers.objects.UserObject
import com.jww.walkingtravelers.viewModel.SignInVM

class SignInActivity : BaseActivity(), SignInCon {
    lateinit var binding: ActivitySignInBinding
    override fun goMainActivity() {
        getAuth().currentUser?.let {
            requestUser(it.uid, ::userInfoCompleteF)
        }
    }

    override fun goSignUpActivity() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivityForResult(intent, Constants.REQUEST_ACTIVITY_SIGN_UP)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in)
        binding.vm = SignInVM(this, this, getAuth())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            Constants.REQUEST_ACTIVITY_SIGN_UP -> {
                if (resultCode == Constants.RESULT_SIGN_UP) {
                    data?.let {
                        val email = it.getStringExtra("email")
                        val password = it.getStringExtra("password")
                        binding.vm?.requestLogin(email, password)
                    }
                }
            }
        }
    }

    fun userInfoCompleteF(userInfo: UserLoginModel?) {
        userInfo?.let {
            UserObject.userInfo = it
            setResult(Activity.RESULT_OK)
            finish()
        }
    }
}