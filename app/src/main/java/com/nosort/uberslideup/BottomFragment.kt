package com.nosort.uberslideup

import android.os.Bundle
import android.support.constraint.motion.MotionLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_fragment.*

class BottomFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            LayoutInflater.from(context).inflate(R.layout.bottom_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setMotionLayoutListener()
    }

    private fun setMotionLayoutListener() {
        bottomMotionlayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, progress: Float) {
                val mainActivity = activity as MainActivity
                mainActivity.mainMotionLayout.progress = Math.abs(progress)
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
            }
        })
    }

    companion object {
        fun newInstance(): Fragment =
                BottomFragment()
    }

}
