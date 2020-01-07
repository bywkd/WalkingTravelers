package com.jww.walkingtravelers.view.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.jww.walkingtravelers.R
import com.jww.walkingtravelers.base.BaseActivity
import com.jww.walkingtravelers.databinding.ActivitySignUpBinding
import com.jww.walkingtravelers.view.fragment.SignUp_01Fragment

class SignUpActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding =
            DataBindingUtil.setContentView<ActivitySignUpBinding>(this, R.layout.activity_sign_up)

        val fm = supportFragmentManager.beginTransaction()
            .add(binding.flRoot.id, SignUp_01Fragment().newInstance())
        fm.commit()
    }
}