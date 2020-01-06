package com.jww.walkingtravelers.view.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.jww.walkingtravelers.R
import com.jww.walkingtravelers.base.BaseActivity
import com.jww.walkingtravelers.databinding.ActivitySignInBinding
import com.jww.walkingtravelers.viewModel.SignInVM

class SignInActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySignInBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_sign_in)
        binding.vm = SignInVM()
    }
}