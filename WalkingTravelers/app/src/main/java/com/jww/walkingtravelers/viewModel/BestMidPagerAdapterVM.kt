package com.jww.walkingtravelers.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class BestMidPagerAdapterVM : ViewModel() {

    val image: ObservableField<Int> = ObservableField()
    val category: ObservableField<Int> = ObservableField()
    fun setImage(image: Int) {
        this.image.set(image)
    }

    fun setCategory(category: Int) {
        this.category.set(category)
    }
}