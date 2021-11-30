package com.suonk.coyali_test_app.ui.fragments

import androidx.fragment.app.Fragment
import com.suonk.coyali_test_app.ui.activity.MainActivity

abstract class BaseFragment : Fragment() {

    protected val navController by lazy {
        (activity as MainActivity).navController
    }

    protected val contextActivity by lazy {
        activity as MainActivity
    }
}