package com.jww.walkingtravelers.view.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.jww.walkingtravelers.R
import com.jww.walkingtravelers.base.BaseActivity
import com.jww.walkingtravelers.contract.SignInCon
import com.jww.walkingtravelers.databinding.ActivitySignInBinding
import com.jww.walkingtravelers.viewModel.SignInVM

class SignInActivity : BaseActivity(), SignInCon {
    override fun goMainActivity() {
//        val intent = Intent(this, MainActivity::class.java)
//        this.startActivity(intent)
        setResult(Activity.RESULT_OK)
        finish()
    }

    override fun goSignUpActivity() {
        val intent = Intent(this, SignUpActivity::class.java)
        this.startActivity(intent)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySignInBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_sign_in)
        binding.vm = SignInVM(this)
    }
}