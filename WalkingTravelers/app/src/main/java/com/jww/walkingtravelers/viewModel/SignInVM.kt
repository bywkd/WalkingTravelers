package com.jww.walkingtravelers.viewModel

import androidx.lifecycle.ViewModel
import com.jww.walkingtravelers.contract.SignInCon

class SignInVM : ViewModel {

    private var contract: SignInCon

    constructor(contract: SignInCon) {
        this.contract = contract
    }

    fun onLogin() {
        contract.goMainActivity()
    }

    fun onSignUp() {
        contract.goSignUpActivity()
    }
}