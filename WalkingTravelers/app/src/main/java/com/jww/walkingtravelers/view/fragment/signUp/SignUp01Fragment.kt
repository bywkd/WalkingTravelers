package com.jww.walkingtravelers.view.fragment.signUp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    fun newInstance(): SignUp01Fragment {
        val fragment = SignUp01Fragment()
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(container!!.context),
            R.layout.fragment_sign_up_01, container,
            false
        )
        binding.vm = SignUp01VM(this.context!!, this)
        currentActivity = activity as SignUpActivity
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onNext() {
        currentActivity.goSignUp02Fragment()
    }

    override fun onCancel() {
        currentActivity.finish()
    }

}