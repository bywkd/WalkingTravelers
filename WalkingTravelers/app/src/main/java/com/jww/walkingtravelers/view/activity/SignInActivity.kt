package com.jww.walkingtravelers.view.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.jww.walkingtravelers.R
import com.jww.walkingtravelers.base.BaseActivity
import com.jww.walkingtravelers.constants.Constants
import com.jww.walkingtravelers.contract.SignInCon
import com.jww.walkingtravelers.databinding.ActivitySignInBinding
import com.jww.walkingtravelers.viewModel.SignInVM

class SignInActivity : BaseActivity(), SignInCon {
    override fun goMainActivity() {
//        val intent = Intent(this, MainActivity::class.java)
//        this.startActivity(intent)
        Log.d("Won","성공")
        setResult(Activity.RESULT_OK)
        finish()
    }

    override fun goSignUpActivity() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivityForResult(intent, Constants.REQUEST_ACTIVITY_SIGN_UP)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySignInBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_sign_in)
        binding.vm = SignInVM(this,this,getAuth())
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            Constants.REQUEST_ACTIVITY_SIGN_UP -> {
                if (resultCode == Constants.RESULT_SIGN_UP) {
                    data?.let {
                        val email = it.getStringExtra("email")
                        val password = it.getStringExtra("password")
                        Log.d("Won", "email = $email    password = $password")
                    }
                }
            }
        }
    }
}