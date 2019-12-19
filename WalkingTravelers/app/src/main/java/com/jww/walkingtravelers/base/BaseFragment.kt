package com.jww.walkingtravelers.base

import androidx.fragment.app.Fragment
import com.jww.walkingtravelers.R

open class BaseFragment : Fragment() {

    val testImages: ArrayList<Int> = arrayListOf(
        R.drawable.imge_1,
        R.drawable.imge_2,
        R.drawable.imge_3,
        R.drawable.imge_4,
        R.drawable.imge_5
    )
    val testCategory: ArrayList<Int> = arrayListOf(
        R.drawable.category_defalut,
        R.drawable.category_air,
        R.drawable.category_clothes,
        R.drawable.category_food,
        R.drawable.category_people,
        R.drawable.category_smile
    )
}