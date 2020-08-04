package com.ymg.autoscreenview.main


import android.content.Intent
import android.os.Bundle
import com.ymg.autoscreenmodule.AutoScreenDestiny
import com.ymg.autoscreenview.R
import com.ymg.autoscreenview.base.BasicActivity
import com.ymg.autoscreenview.recycler.RecyclerActivity
import com.ymg.autoscreenview.sub.SubActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BasicActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AutoScreenDestiny.setActivityScreen(this)

        button01.setOnClickListener {
            startActivity(Intent(this, SubActivity::class.java))
        }

        button02.setOnClickListener {
            startActivity(Intent(this, RecyclerActivity::class.java))
        }
    }
}