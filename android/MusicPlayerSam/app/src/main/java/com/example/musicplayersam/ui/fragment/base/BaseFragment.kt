package com.example.musicplayersam.ui.fragment.base

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.appcompat.widget.ContentFrameLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.musicplayersam.R
import com.example.musicplayersam.utils.annotation.LayoutId
import com.example.musicplayersam.utils.component.support.QuietViewModelProvider
import com.example.musicplayersam.utils.component.support.attrValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext
import kotlin.reflect.full.findAnnotation
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.musicplayersam.ui.activity.base.BaseActivity

/**
 * @see Fragment
 */
abstract class BaseFragment : Fragment(), CoroutineScope {

    var viewModelFactory: ViewModelProvider.Factory = QuietViewModelProvider()

    private lateinit var job: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = Job()
    }

    @SuppressLint("RestrictedApi")
    final override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = onCreateView2(inflater, container, savedInstanceState)
        if (view == null) {
            view = getAnnotatedLayout(inflater, container)
        }
        if (view != null && view !is ContentFrameLayout) {
            val wrapper = ContentFrameLayout(inflater.context)
            wrapper.layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT)
            wrapper.addView(view)
            return wrapper
        }
        return view
    }

    /**
     * inflate view by [LayoutId] annotation
     *  if annotation is not presenter , null returned
     */
    protected fun getAnnotatedLayout(inflater: LayoutInflater, container: ViewGroup?): View? {
        val layoutId = this::class.findAnnotation<LayoutId>() ?: return null
        val view = inflater.inflate(layoutId.value, container, false)
        if (!layoutId.translucent) {
            view.setBackgroundColor(view.context.attrValue(R.attr.quietBackground))
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

    /**
     * lazy generate ViewModel , this ViewModel store is use the fragment
     *
     * example :
     *   private val viewModel by lazyViewModel(XXXViewModel::class)
     *
     */
    protected inline fun <reified T : ViewModel> lazyViewModelInternal(): Lazy<T> = lazy {
        ViewModelProviders.of(this, viewModelFactory).get(T::class.java)
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

    /**
     * Take care of popping the fragment back stack or finishing the activity
     * as appropriate.
     */
    open fun onBackPressed() {
        val isStateSaved = childFragmentManager.isStateSaved
        if (isStateSaved && Build.VERSION.SDK_INT <= Build.VERSION_CODES.N_MR1) {
            // Older versions will throw an exception from the framework
            // FragmentManager.popBackStackImmediate(), so we'll just
            // return here. The Activity is likely already on its way out
            // since the fragmentManager has already been saved.
            return
        }

        if (isStateSaved || !childFragmentManager.popBackStackImmediate()) {
            requireBaseActivity().onBackPressed()
        }
    }

    /**
     * cast the activity to [BaseActivity]
     */
    protected fun requireBaseActivity() = requireActivity() as BaseActivity

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}