package com.ymg.autoscreenview.base

import android.os.Bundle
import android.view.WindowManager
import androidx.fragment.app.Fragment

open class BasicFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        setHasOptionsMenu(true) // Fragment Option Menu 사용
    }
}