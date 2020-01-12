package com.jww.walkingtravelers.contract

interface SignUpCon {

    interface SignUp01Con {
        fun onNext()
        fun onCancel()
    }

    interface SignUp02Con {
        fun onComplete()
        fun onBefore()
    }
}