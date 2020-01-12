package com.jww.walkingtravelers.viewModel.signUp

import android.content.Context
import androidx.lifecycle.ViewModel
import com.jww.walkingtravelers.contract.SignUpCon

class SignUp01VM : ViewModel {
    private var context: Context
    private var contract: SignUpCon.SignUp01Con

    constructor(context: Context, contract: SignUpCon.SignUp01Con) {
        this.context = context
        this.contract = contract
    }

    fun onCancel() {
        contract.onCancel()
    }

    fun onNext() {
        contract.onNext()

    }

    fun onCheckEmail() {

    }
}