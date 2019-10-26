package com.example.musicplayersam.ui.fragment.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.appcompat.widget.ContentFrameLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.musicplayersam.utils.annotation.LayoutId
import com.example.musicplayersam.utils.component.support.QuietViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import android.view.ViewGroup.LayoutParams.MATCH_PARENT

abstract class BaseFragment : Fragment(), CoroutineScope {

    var viewModelFactory: ViewModelProvider.Factory = QuietViewModelProvider()

    private lateinit var job: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = Job()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = onCreateView2(inflater, container, savedInstanceState)
        if (view == null) {
            view = getAnnotatedLayout(inflater, container)
        }
        if (view != null && view !is ContentFrameLayout) {
            val wrapper = com.example.musicplayersam.ui.view.ContentFrameLayout(inflater.context)
            wrapper.layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT)
            wrapper.addView(view)
            return wrapper
        }
        return view
    }

    protected fun getAnnotatedLayout(inflater: LayoutInflater, container: ViewGroup?): View? {
        val layoutId = this::class.java.getAnnotation(LayoutId::class.java) ?: return null
        val view = inflater.inflate(layoutId.value, container, false)
        if (!layoutId.translucent) {
           // view.setBackgroundColor(view.context.attrValue(R.attr.quietBackground))
        }
        return view
    }

    /**
     * @see Fragment.onCreateView
     *
     * @return Return the View for the fragment's UI, or null.
     */
    open fun onCreateView2(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return null
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.requestApplyInsets()
    }


    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

}