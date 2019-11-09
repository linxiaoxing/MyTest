package com.example.musicplayersam.ui.activity.main

import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import com.example.musicplayersam.ui.activity.base.BaseActivity

/**
 * application splash
 */
class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, AppMainActivity::class.java))
        finish()
    }

}