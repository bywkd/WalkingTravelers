package com.jww.walkingtravelers.view.fragment.signUp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.jww.walkingtravelers.R
import com.jww.walkingtravelers.base.BaseFragment
import com.jww.walkingtravelers.contract.SignUpCon
import com.jww.walkingtravelers.databinding.FragmentSignUp01Binding
import com.jww.walkingtravelers.view.activity.SignUpActivity
import com.jww.walkingtravelers.viewModel.signUp.SignUp01VM

class SignUp01Fragment : BaseFragment(), SignUpCon.SignUp01Con {


    private lateinit var binding: FragmentSignUp01Binding
    private lateinit var currentActivity: SignUpActivity
    private var isEmail: Boolean = false

    fun newInstance(): SignUp01Fragment {
        val fragment = SignUp01Fragment()
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        currentActivity = activity as SignUpActivity
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(container!!.context),
            R.layout.fragment_sign_up_01, container,
            false
        )
        binding.vm = SignUp01VM(this.context!!, this, currentActivity.getAuth())

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onNext() {
        if (isEmail && currentActivity.email.isNotEmpty()) {
            currentActivity.goSignUp02Fragment()
        } else {
            Toast.makeText(currentActivity, "이메일 중복 검사를 해주세요", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCancel() {
        currentActivity.finish()
    }

    /*이메일 중복 검사 결과*/
    override fun resultEmail(email: String, errorMessage: String) {
        if (email.isNotEmpty()) {
            /*이메일 사용 가능*/
            isEmail = true
            currentActivity.apply {
                this.email = email
                this.year = binding.dpBirthDay.year
                this.month = binding.dpBirthDay.month + 1
                this.day = binding.dpBirthDay.dayOfMonth
                checkGender()
            }
        } else if (errorMessage.isNotEmpty()) {
            /*이메일 사용 불가능*/
            currentActivity.email = ""
            Toast.makeText(currentActivity, errorMessage, Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkGender() {
        when (binding.radioGGender.checkedRadioButtonId) {
            binding.radioBtnMen.id -> {
                currentActivity.gender = SignUpActivity.GENDER.MEN
            }
            binding.radioBtnWomen.id -> {
                currentActivity.gender = SignUpActivity.GENDER.WOMEN
            }
            else -> {
                currentActivity.gender = SignUpActivity.GENDER.MEN
            }
        }
    }
}