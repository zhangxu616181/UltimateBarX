package com.zackratos.ultimatebarx.library.operator

import android.os.Build
import androidx.fragment.app.FragmentActivity
import com.zackratos.ultimatebarx.library.*
import com.zackratos.ultimatebarx.library.bean.BarConfig
import com.zackratos.ultimatebarx.library.defaultStatusBar
import com.zackratos.ultimatebarx.library.extension.*
import com.zackratos.ultimatebarx.library.ultimateBarXInitialization
import com.zackratos.ultimatebarx.library.updateNavigationBar
import com.zackratos.ultimatebarx.library.updateStatusBar

/**
 * @Author   : Zackratos
 * @Date     : 2020/11/27 0:34
 * @email    : 869649338@qq.com
 * @Describe :
 */
internal class ActivityOperator private constructor(val activity: FragmentActivity, config: BarConfig): BaseOperator(config) {

    companion object {
        internal fun newInstance(activity: FragmentActivity, config: BarConfig = BarConfig.newInstance()) = ActivityOperator(activity, config)
    }

    override fun applyStatusBar() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) return
        activity.ultimateBarXInitialization()
        val navLight = manager.getNavigationBarConfig(activity).light
        activity.barLight(config.light, navLight)
        activity.updateStatusBar(config)
        activity.defaultNavigationBar()
        activity.addObserver()
    }

    override fun applyNavigationBar() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) return
        activity.ultimateBarXInitialization()
        val staLight = manager.getStatusBarConfig(activity).light
        activity.barLight(staLight, config.light)
        activity.updateNavigationBar(config)
        activity.defaultStatusBar()
        activity.addObserver()
    }

}