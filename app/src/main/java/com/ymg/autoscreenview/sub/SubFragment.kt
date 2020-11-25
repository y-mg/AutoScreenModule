package com.ymg.autoscreenview.sub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ymg.autoscreenmodule.AutoScreenDestiny
import com.ymg.autoscreenview.databinding.FragmentSubBinding


class SubFragment : Fragment() {

    private lateinit var viewBinding: FragmentSubBinding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentSubBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AutoScreenDestiny.setFragmentScreen(requireActivity(), view)
    }
}