package com.jww.walkingtravelers.viewModel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.jww.walkingtravelers.contract.SignInCon

class SignInVM : ViewModel {
    private var context: Context
    private var contract: SignInCon
    private var auth: FirebaseAuth
    val email: ObservableField<String> = ObservableField()
    val password: ObservableField<String> = ObservableField()

    constructor(context: Context, contract: SignInCon, auth: FirebaseAuth) {
        this.context = context
        this.contract = contract
        this.auth = auth
    }

    fun onLogin() {

        if (email.get().toString().length < 6) {
            Toast.makeText(context, "이메일이 틀렸습니다.", Toast.LENGTH_SHORT).show()
            return
        }
        if (password.get().toString().length < 6) {
            Toast.makeText(context, "비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show()
            return
        }
        requestLogin(email.get().toString(), password.get().toString())


        contract.goMainActivity()
    }

    fun onSignUp() {
        contract.goSignUpActivity()
    }

    fun requestLogin(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                val user = auth.currentUser
                Log.d("Won","성공")
                contract.goMainActivity()
            } else {
                Toast.makeText(context, it.exception.toString(), Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            it.printStackTrace()
        }
    }
}