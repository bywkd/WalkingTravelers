package com.jww.walkingtravelers.view.fragment.signUp

import android.app.Activity.RESULT_OK
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.jww.walkingtravelers.R
import com.jww.walkingtravelers.base.BaseFragment
import com.jww.walkingtravelers.contract.SignUpCon
import com.jww.walkingtravelers.databinding.FragmentSignUp02Binding
import com.jww.walkingtravelers.view.activity.SignUpActivity
import com.jww.walkingtravelers.viewModel.signUp.SignUp02VM

class SignUp02Fragment : BaseFragment(), SignUpCon.SignUp02Con {


    private lateinit var binding: FragmentSignUp02Binding
    private lateinit var currentActivity: SignUpActivity

    fun newInstance(auth: FirebaseAuth): SignUp02Fragment {
        val fragment = SignUp02Fragment()
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(container!!.context),
            R.layout.fragment_sign_up_02,
            container,
            false
        )
        currentActivity = activity as SignUpActivity
        binding.vm = SignUp02VM(this.context!!, this, currentActivity.getAuth())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    override fun onBefore() {
        currentActivity.onBackPressed()
    }

    override fun onComplete() {

        binding.vm?.let {
//            it.requestEmailSignUp(currentActivity.email.get()!!, currentActivity.password.get()!!)
        }

    }

    override fun onSignUpComplete() {
        currentActivity.setResult(RESULT_OK)
        currentActivity.finish()
    }

}