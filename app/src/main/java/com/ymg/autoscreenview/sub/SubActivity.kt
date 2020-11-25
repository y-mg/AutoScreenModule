package com.ymg.autoscreenview.sub


import android.os.Bundle
import com.ymg.autoscreenmodule.AutoScreenDestiny
import com.ymg.autoscreenview.R
import com.ymg.autoscreenview.base.BasicActivity
import com.ymg.autoscreenview.databinding.ActivitySubBinding


class SubActivity : BasicActivity() {

    private lateinit var viewBinding: ActivitySubBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

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