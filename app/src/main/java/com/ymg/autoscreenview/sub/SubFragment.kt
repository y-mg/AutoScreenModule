package com.ymg.autoscreenview.sub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ymg.autoscreenmodule.AutoScreenDestiny
import com.ymg.autoscreenview.R
import com.ymg.autoscreenview.base.BasicFragment


class SubFragment : BasicFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sub, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AutoScreenDestiny.setFragmentScreen(requireActivity(), view)
    }
}