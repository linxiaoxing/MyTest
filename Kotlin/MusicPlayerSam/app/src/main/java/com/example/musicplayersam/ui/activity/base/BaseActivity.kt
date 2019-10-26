package com.example.musicplayersam.ui.activity.base

import android.os.Bundle
import androidx.annotation.ColorInt
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.musicplayersam.AppContext
import com.example.musicplayersam.utils.component.support.QuietViewModelProvider
import com.example.musicplayersam.utils.component.support.attrValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import com.example.musicplayersam.R
import com.example.musicplayersam.utils.annotation.LayoutId
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext
import kotlin.reflect.full.companionObject
import kotlin.reflect.full.companionObjectInstance
import kotlin.reflect.full.declaredFunctions

abstract class BaseActivity : AppCompatActivity(), CoroutineScope {

//    private val controllerViewModel by lazy { ViewModel<MusicControllerViewModel>() }

    var viewModelFactory: ViewModelProvider.Factory = QuietViewModelProvider()

    private lateinit var job: Job

//    @ColorInt
//    var colorPrimary: Int = AppContext.attrValue(R.attr.colorPrimary)

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onCreate(savedInstanceState: Bundle?) {
        checkTest()
        super.onCreate(savedInstanceState)
        job = Job()

        val layoutId = this::class.java.getAnnotation(LayoutId::class.java)
        if (layoutId != null) {
            setContentView(layoutId.value)
        }
    }

    /**
     *  check for test , if is in test mode, will replace [viewModelFactory]
     */
    private fun checkTest() {
        val isTest = intent.getBooleanExtra("isTest", false)
        if (!isTest) {
            return
        }

        val rule = Class.forName("tech.soit.quiet.utils.test.BaseActivityTestRule").kotlin
        val objectInstance = rule.companionObjectInstance ?: return
        val objectClass = rule.companionObject ?: return
        objectClass.declaredFunctions.find { it.name == "injectActivity" }
            ?.call(objectInstance, this)
    }
}