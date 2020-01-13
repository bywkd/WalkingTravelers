package com.jww.walkingtravelers

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.jww.walkingtravelers.base.BaseActivity
import com.jww.walkingtravelers.databinding.ActivityMainBinding
import com.jww.walkingtravelers.view.activity.SignInActivity
import com.jww.walkingtravelers.view.fragment.MainFragment

class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val fm =
            supportFragmentManager.beginTransaction().add(R.id.fl_main, MainFragment.newInstance())
        fm.commit()
    }
}
