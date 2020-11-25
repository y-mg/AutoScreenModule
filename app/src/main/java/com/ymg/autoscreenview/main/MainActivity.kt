package com.ymg.autoscreenview.main


import android.content.Intent
import android.os.Bundle
import com.ymg.autoscreenmodule.AutoScreenDestiny
import com.ymg.autoscreenview.base.BasicActivity
import com.ymg.autoscreenview.databinding.ActivityMainBinding
import com.ymg.autoscreenview.recycler.RecyclerActivity
import com.ymg.autoscreenview.sub.SubActivity

class MainActivity : BasicActivity() {

    private lateinit var viewBinding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        AutoScreenDestiny.setActivityScreen(this)

        viewBinding.button01.setOnClickListener {
            startActivity(Intent(this, SubActivity::class.java))
        }

        viewBinding.button02.setOnClickListener {
            startActivity(Intent(this, RecyclerActivity::class.java))
        }
    }
}