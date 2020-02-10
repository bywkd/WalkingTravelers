package com.jww.walkingtravelers.viewModel.signUp

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.jww.walkingtravelers.R
import com.jww.walkingtravelers.contract.SignUpCon
import com.jww.walkingtravelers.utils.RegularUtil

class SignUp01VM : ViewModel {
    private var context: Context
    private var contract: SignUpCon.SignUp01Con
    private var auth: FirebaseAuth

    val email: ObservableField<String> = ObservableField()

    constructor(context: Context, contract: SignUpCon.SignUp01Con, auth: FirebaseAuth) {
        this.context = context
        this.contract = contract
        this.auth = auth
    }

    fun onCancel() {
        contract.onCancel()
    }

    fun onNext() {
        contract.onNext()
    }

    fun onCheckEmail() {
        var resultEmail = email.get().toString().trim()

        if (resultEmail.isNotEmpty()) {
            var errorMessage: String = ""
            if (RegularUtil.validateEmail(resultEmail)) {
                emailDuplicateCheck(resultEmail)
            } else {
                resultEmail = ""
                errorMessage = "이메일 형식이 맞지 않습니다."
                contract.resultEmail(resultEmail, errorMessage)
            }

        }
    }

    /*이메일 중복 검사 요청*/
    private fun emailDuplicateCheck(email: String) {
        /*이메일 사용자의 로그인 방식 검사
        * 이방식으로 현제 사용자 아이디 중복 검사를 한다. 아무 것도 없으면 같은 아이디 사용자 가 없다는 뜻*/
        auth.fetchSignInMethodsForEmail(email)
            .addOnSuccessListener { result ->
                val signInMethods = result.signInMethods
                signInMethods?.let {
                    checkEmail(it, email)
                }
            }
            .addOnFailureListener { exception ->
                /*검사 실패*/
                Log.d("Won", "검사 실패 ${exception.message}")
            }

    }

    private fun checkEmail(messageList: MutableList<String>, email: String) {

        var errorMessage: String = ""
        /*해당 아이디가 없어서  가입 할때 비밀번호 인지 링크인지 모름*/
//        if (messageList.isEmpty())
        /*가입된 아이디 가 있어 해당아이디의 가입 타입을 출력*/
        if (messageList.isNotEmpty()) {
            with(messageList)
            {
                if (this.contains(EmailAuthProvider.EMAIL_PASSWORD_SIGN_IN_METHOD)) {
                    /*이미 등록된 이메일*/
                    errorMessage = context.getString(R.string.sign_up_alreadyRegisteredEmail)
                } else if (this.contains(EmailAuthProvider.EMAIL_LINK_SIGN_IN_METHOD)) {
                    /*이메일 링크 */
//                EMAIL_LINK_SIGN_IN_METHOD
                    errorMessage = context.getString(R.string.sign_up_alreadyRegisteredEmail)
                } else if (this.contains(context.getString(R.string.sign_up_emailAvailableEmail))) {
                    /*사용할수 있는 이메일*/
                    errorMessage = ""
                } else if (this.contains(context.getString(R.string.check_email_errorType_notFormat_Email))) {
                    /*잘못된 형식의 이메일*/
                    errorMessage = context.getString(R.string.sign_up_notFormatEmail)
                } else {
                    errorMessage = "알수 없는 에러 메시지 = ${messageList.toString()}"
                    Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT)
                        .show()/*알수 없는 에러*/
                }
            }
        }
        contract.resultEmail(email, errorMessage)

    }
}