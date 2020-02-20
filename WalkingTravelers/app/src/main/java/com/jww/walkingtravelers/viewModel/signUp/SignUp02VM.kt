package com.jww.walkingtravelers.viewModel.signUp

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.jww.walkingtravelers.contract.SignUpCon
import com.jww.walkingtravelers.net.ApiStore
import com.jww.walkingtravelers.utils.RegularUtil

class SignUp02VM : ViewModel {
    private var context: Context
    private var contract: SignUpCon.SignUp02Con
    private var auth: FirebaseAuth

    val password: ObservableField<String> = ObservableField()
    val checkPassword: ObservableField<String> = ObservableField()

    private var passwordCheck: Boolean = false
    private var checkPasswordCheck: Boolean = false

    val passwordWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            passwordCheck = false
            s?.let {
                passwordCheck = if (it.length >= 6) {
                    RegularUtil.validatePassword(it.toString())
                } else {
                    false
                }
            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

    }
    val checkPasswordWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            checkPasswordCheck = false
            s?.let {
                checkPasswordCheck = if (it.length >= 6) {
                    RegularUtil.validatePassword(it.toString())
                } else {
                    false
                }
            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }
    }

    constructor(
        context: Context,
        contract: SignUpCon.SignUp02Con,
        auth: FirebaseAuth
    ) {
        this.context = context
        this.contract = contract
        this.auth = auth
    }

    fun onBefore() {
        contract.onBefore()
    }

    fun onComplete() {
        if (!passwordCheck) {
            Toast.makeText(context, "비밀번호 형식이 틀렸습니다.", Toast.LENGTH_SHORT).show()
            return
        }

        if (!checkPasswordCheck) {
            Toast.makeText(context, "비밀번호 확인 형식이 틀렸습니다.", Toast.LENGTH_SHORT).show()
            return
        }

        if (password.get() == checkPassword.get() && passwordCheck && checkPasswordCheck) {
            contract.onComplete()
        } else {
            Toast.makeText(context, "비밀번호가 일치 하지 않습니다.", Toast.LENGTH_SHORT).show()
        }
    }

    fun requestEmailSignUp(email: String) {
        auth.createUserWithEmailAndPassword(email, password.get().toString())
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val user = auth.currentUser
                    user?.let { userInfo ->
                        contract.fireBaseSignUpComplete(userInfo, password.get().toString())
                    }
                } else {
                    Toast.makeText(context, it.exception.toString(), Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun firebaseStoreAddUser(user: Map<String, Any>) {
        ApiStore.addUser(user["uid"].toString()).set(user).addOnSuccessListener {
            //            Log.d("Won", it.id)
//            Log.d("Won", it.path)
//            Log.d("Won", it.parent.toString())
//            Log.d("Won", it.firestore.toString())
//            Log.d("Won", it.firestore.app!!.name)
//            Log.d("Won", it.firestore.app!!.persistenceKey)
//            Log.d("Won", it.firestore.app!!.applicationContext.toString())
//            Log.d("Won", it.firestore.app!!.options.toString())
//            Log.d("Won", it.firestore.app.)
//            it.get().result?.let { result ->
//                Log.d("Won", result.toString())
//            }
            contract.fireStoreUserAddComplete(user.get("email").toString(),user.get("password").toString())
        }.addOnFailureListener {
            it.printStackTrace()
        }

    }
}