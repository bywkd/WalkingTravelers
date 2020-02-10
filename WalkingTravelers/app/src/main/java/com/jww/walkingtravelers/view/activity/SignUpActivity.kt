package com.jww.walkingtravelers.view.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.jww.walkingtravelers.R
import com.jww.walkingtravelers.base.BaseActivity
import com.jww.walkingtravelers.contract.SignUpCon
import com.jww.walkingtravelers.databinding.ActivitySignUpBinding
import com.jww.walkingtravelers.view.fragment.signUp.SignUp01Fragment
import com.jww.walkingtravelers.view.fragment.signUp.SignUp02Fragment

class SignUpActivity : BaseActivity(), SignUpCon {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var fm: FragmentManager
    var isEmail: Boolean = false

    enum class GENDER {
        MEN, WOMEN
    }

    var email: String = ""
    //    val password: ObservableField<String> = ObservableField()
    var gender: GENDER = GENDER.MEN
    var year: Int = 0
    var month: Int = 0
    var day: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =
            DataBindingUtil.setContentView<ActivitySignUpBinding>(this, R.layout.activity_sign_up)
        fm = supportFragmentManager
        goSighUp01Fragment()

    }

    private fun getFm(): FragmentTransaction = fm.beginTransaction()

    private fun goSighUp01Fragment() {
        getFm().replace(binding.flRoot.id, SignUp01Fragment().newInstance()).commit()
    }

    fun goSignUp02Fragment() {
        getFm().add(binding.flRoot.id, SignUp02Fragment().newInstance(getAuth()))
            .addToBackStack(null).commit()
    }


}