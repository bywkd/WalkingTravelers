package com.jww.walkingtravelers.view.fragment.signUp

import android.app.Activity.RESULT_OK
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
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
        binding.vm?.requestEmailSignUp(currentActivity.email)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        currentActivity.isEmail = false
    }

    override fun onSignUpComplete(user: FirebaseUser, password: String) {


        val userMap: HashMap<String, Any> = hashMapOf()
        userMap["uid"] = user.uid
        userMap["email"] = user.email.toString()
        userMap["password"] = password
        userMap["gender"] = currentActivity.gender.toString()
        userMap["year"] = currentActivity.year
        userMap["month"] = currentActivity.month
        userMap["day"] = currentActivity.day

        binding.vm?.signUpUser(userMap)

//        currentActivity.setResult(RESULT_OK)
//        currentActivity.finish()
    }

}