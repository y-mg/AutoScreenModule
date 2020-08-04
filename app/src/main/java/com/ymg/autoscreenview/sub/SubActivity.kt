package com.ymg.autoscreenview.sub


import android.os.Bundle
import com.ymg.autoscreenmodule.AutoScreenDestiny
import com.ymg.autoscreenview.R
import com.ymg.autoscreenview.base.BasicActivity


class SubActivity : BasicActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        AutoScreenDestiny.setActivityScreen(this)

        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragment,
                SubFragment()
            )
            .commitAllowingStateLoss()
    }
}