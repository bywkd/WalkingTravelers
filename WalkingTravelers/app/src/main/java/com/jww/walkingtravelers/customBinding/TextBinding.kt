package com.jww.walkingtravelers.customBinding

import android.text.TextWatcher
import android.widget.EditText
import androidx.databinding.BindingAdapter

object TextBinding {
    @JvmStatic
    @BindingAdapter("textBind:textWatcher")
    fun textWatcher(editText: EditText, textWatcher: TextWatcher) {
        editText.addTextChangedListener(textWatcher)
    }

}