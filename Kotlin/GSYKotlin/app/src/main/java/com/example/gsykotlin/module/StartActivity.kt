package com.example.gsykotlin.module

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gsykotlin.R
import org.jetbrains.anko.clearTask

/**
 * 启动页
 */
class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val intent = Intent(this, StartNavigationActivity::class.java)
        intent.clearTask()
        startActivity(intent)

        finish()

    }

    override fun onBackPressed() {

    }
}