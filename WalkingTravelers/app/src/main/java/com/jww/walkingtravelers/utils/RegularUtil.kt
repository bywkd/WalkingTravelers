package com.jww.walkingtravelers.utils

import java.util.regex.Matcher
import java.util.regex.Pattern

class RegularUtil {
    companion object {
        // 이메일 정규식
        private val VALID_EMAIL_ADDRESS_REGEX: Pattern =
            Pattern.compile("^[A-z0-9._%+-]+@[A-z0-9.-]+\\.[A-z]+$", Pattern.CASE_INSENSITIVE)

        // 이메일 검사
        fun validateEmail(emailStr: String): Boolean {
            val matcher: Matcher =
                VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr)
            return matcher.find()
        }

        //비밀번호 정규식
        val VALID_PASSWOLD_REGEX_ALPHA_NUM: Pattern =
            Pattern.compile("^[a-zA-Z0-9!@.#$%^&*?_~]{6,16}$") // 6자리 ~ 16자리까지 가능

        // 비밀번호 검사
        fun validatePassword(pwStr: String): Boolean {
            val matcher: Matcher = VALID_PASSWOLD_REGEX_ALPHA_NUM.matcher(pwStr)
            return matcher.matches()
        }
    }
}