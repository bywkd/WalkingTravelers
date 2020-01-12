package com.jww.walkingtravelers.viewModel.signUp

import android.content.Context
import androidx.lifecycle.ViewModel
import com.jww.walkingtravelers.contract.SignUpCon

class SignUp02VM : ViewModel {
    private var context: Context
    private var contract: SignUpCon.SignUp02Con

    constructor(context: Context, contract: SignUpCon.SignUp02Con) {
        this.context = context
        this.contract = contract
    }

    fun onBefore() {
        contract.onBefore()
    }

    fun onComplete() {
        contract.onComplete()
    }
}