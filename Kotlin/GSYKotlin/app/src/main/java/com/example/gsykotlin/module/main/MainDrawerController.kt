package com.example.gsykotlin.module.main

import android.app.Activity
import android.content.Context
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.URLSpan
import com.example.gsykotlin.common.net.ResultCallBack
import com.example.gsykotlin.model.bean.Release
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem
import org.jetbrains.anko.*
import android.content.pm.PackageManager
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.example.gsykotlin.common.utils.IssueDialogClickListener
import com.example.gsykotlin.common.utils.showIssueEditDialog
import com.example.gsykotlin.model.AppGlobalModel
import com.example.gsykotlin.model.bean.Issue
import com.orhanobut.dialogplus.DialogPlus
import androidx.core.net.toUri
import com.example.gsykotlin.repository.LoginRepository
import com.example.gsykotlin.repository.ReposRepository


/**
 * 主页Drawer控制器
 */
class MainDrawerController(private val activity: Activity, toolbar: Toolbar,
                           loginRepository: LoginRepository,
                           private val issueRepository: IssueRepository,
                           private val reposRepository: ReposRepository,
                           globalModel: AppGlobalModel
) {

    var drawer: Drawer? = null

    init {
        drawer = DrawerBuilder()
            .withActivity(activity)
            .withToolbar(toolbar)
            .withSelectedItem(-1)
            .addDrawerItems(
                PrimaryDrawerItem().withName(com.example.gsykotlin.R.string.feedback)
                    .withTextColorRes(com.example.gsykotlin.R.color.colorPrimary).withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                    override fun onItemClick(
                        view: View?,
                        position: Int,
                        drawerItem: IDrawerItem<*>
                    ): Boolean {
                        feedback()
                        unSelect(drawerItem)
                        return true
                    }
                })
            )
            .addDrawerItems(
                PrimaryDrawerItem().withName(com.example.gsykotlin.R.string.person)
                    .withTextColorRes(com.example.gsykotlin.R.color.colorPrimary).withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                        override fun onItemClick(
                            view: View?,
                            position: Int,
                            drawerItem: IDrawerItem<*>
                        ): Boolean {
                            // UserInfoActivity.gotoUserInfo()
                            unSelect(drawerItem)
                            return true
                        }
                    })
            )
            .addDrawerItems(
                PrimaryDrawerItem().withName(com.example.gsykotlin.R.string.update)
                    .withTextColorRes(com.example.gsykotlin.R.color.colorPrimary).withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                        override fun onItemClick(
                            view: View?,
                            position: Int,
                            drawerItem: IDrawerItem<*>
                        ): Boolean {
                            checkUpdate(true)
                            unSelect(drawerItem)
                            return true
                        }
                    })
            )
            .addDrawerItems(
                PrimaryDrawerItem().withName(com.example.gsykotlin.R.string.about)
                    .withTextColorRes(com.example.gsykotlin.R.color.colorPrimary).withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                        override fun onItemClick(
                            view: View?,
                            position: Int,
                            drawerItem: IDrawerItem<*>
                        ): Boolean {
                            showAboutDialog()
                            unSelect(drawerItem)
                            return true
                        }
                    })
            )
            .addDrawerItems(
                PrimaryDrawerItem().withName(com.example.gsykotlin.R.string.LoginOut)
                    .withTextColorRes(com.example.gsykotlin.R.color.red).withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                        override fun onItemClick(
                            view: View?,
                            position: Int,
                            drawerItem: IDrawerItem<*>
                        ): Boolean {
                            view?.let { loginRepository.logout(view.context) }
                            unSelect(drawerItem)
                            return true
                        }
                    })
            )
            .withAccountHeader(
                AccountHeaderBuilder().withActivity(activity)
                .addProfiles(ProfileDrawerItem().withName(globalModel.userObservable.login)
                    .withSelected(false)
                    .withIcon(globalModel.userObservable.avatarUrl?.toUri()!!)
                    .withEmail(globalModel.userObservable.email ?: ""))
                .withHeaderBackground(com.example.gsykotlin.R.color.colorPrimary)
                .withSelectionListEnabled(false)
                .build()).build()


        checkUpdate(false)
    }


    private fun feedback() {
        activity.showIssueEditDialog(activity.getString(com.example.gsykotlin.R.string.feedback), false, "", "", object :
            IssueDialogClickListener {
            override fun onConfirm(dialog: DialogPlus, title: String, editTitle: String?, editContent: String?) {
                val issue = Issue()
                issue.title = activity.getString(com.example.gsykotlin.R.string.feedback)
                issue.body = editContent
                issueRepository.createIssue(activity, "CarGuo", "GSYGithubAppKotlin", issue, null)
                dialog.dismiss()
            }
        })

    }

    private fun showAboutDialog() {
        val pm = activity.getPackageManager()
        var versionName = ""
        try {
            val packageInfo = pm.getPackageInfo(activity.getPackageName(), 0)
            versionName = packageInfo.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }

        val start =  activity.getString(com.example.gsykotlin.R.string.version) + ": " + versionName + "\n"
        val url  = "https://github.com/CarGuo/GSYGithubAppKotlin"
        val span = SpannableStringBuilder(start + url)
        span.setSpan(URLSpan(url), start.length, start.length + url.length, Spanned.SPAN_INCLUSIVE_INCLUSIVE)

        activity.alert {
            this.iconResource = com.example.gsykotlin.R.drawable.logo
            this.title = activity.getString(com.example.gsykotlin.R.string.app_name)
            this.message = span
            this.negativeButton(com.example.gsykotlin.R.string.open) {
                // ReposDetailActivity.gotoReposDetail("CarGuo", "GSYGithubAppKotlin")
            }
            this.positiveButton(com.example.gsykotlin.R.string.cancel) {
                it.dismiss()
            }
            this.show()
        }
    }

    private fun unSelect(drawerItem: IDrawerItem<*>) {
        drawerItem.isSelected = false
        drawer?.adapter?.notifyAdapterDataSetChanged()
    }

    private fun checkUpdate(needTip: Boolean = false) {
        reposRepository.checkoutUpDate(activity, object : ResultCallBack<Release> {
            override fun onSuccess(result: Release?) {
                result?.name?.apply {
                    showUpdateDialog(activity, this, result.body
                        ?: "", "https://www.pgyer.com/XGtw")
                    return
                }
                if (needTip) {
                    activity.toast(com.example.gsykotlin.R.string.newestVersion)
                }
            }
        })
    }

    private fun showUpdateDialog(context: Context, version: String, message: String, url: String) {
        activity.alert {
            this.iconResource = com.example.gsykotlin.R.drawable.logo
            this.title = activity.getString(com.example.gsykotlin.R.string.app_name)
            this.message = "$version: \n$message"
            this.cancelButton {
                it.dismiss()
            }
            this.okButton {
                context.browse(url)
            }
            this.show()
        }
    }
}