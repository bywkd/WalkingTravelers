package com.jww.walkingtravelers.contract

import com.google.firebase.auth.FirebaseUser

interface SignUpCon {

    interface SignUp01Con {
        fun onNext()
        fun onCancel()
        fun resultEmail(email: String, errorMessage: String)
    }

    interface SignUp02Con {
        fun onComplete()
        fun onBefore()
        fun onSignUpComplete(user: FirebaseUser, password: String)
    }
}