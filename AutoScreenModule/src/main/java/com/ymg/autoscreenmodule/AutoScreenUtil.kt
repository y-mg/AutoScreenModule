package com.ymg.autoscreenmodule

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.widget.TextView
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

object AutoScreenUtil {

    private var displayWidth = 0
    private var displayHeight = 0

    private var designWidth = 0
    private var designHeight = 0

    private var textPixelsRate = 0.0



    @Suppress("DEPRECATION")
    fun setSize(
        act: Activity?,
        hasStatusBar: Boolean,
        designWidth: Int,
        designHeight: Int
    ) {
        if (act == null || designWidth < 1 || designHeight < 1) {
            return
        }

        val display = act.windowManager.defaultDisplay
        val width = display.width
        var height = display.height

        if (hasStatusBar) {
            height -= getStatusBarHeight(act)
        }

        displayWidth = width
        displayHeight = height

        AutoScreenUtil.designWidth = designWidth
        AutoScreenUtil.designHeight = designHeight

        val displayDiagonal = sqrt(
            displayWidth.toDouble().pow(2.0) + displayHeight.toDouble().pow(2.0)
        )
        val designDiagonal = sqrt(
            designWidth.toDouble().pow(2.0) + designHeight.toDouble().pow(2.0)
        )

        textPixelsRate = displayDiagonal / designDiagonal
    }



    private fun getStatusBarHeight(context: Context): Int {
        var result = 0

        try {
            val resourceId = context.resources.getIdentifier(
                "status_bar_height", "dimen", "android"
            )

            if (resourceId > 0) {
                result = context.resources.getDimensionPixelSize(resourceId)
            }
        } catch (e: Resources.NotFoundException) {
            e.printStackTrace()
        }

        return result
    }



    // Use Activity
    fun auto(act: Activity?) {
        if (act == null || displayWidth < 1 || displayHeight < 1) {
            return
        }

        val view = act.window.decorView
        auto(view)
    }

    // Use Fragment
    fun auto(view: View?) {
        if (view == null || displayWidth < 1 || displayHeight < 1) {
            return
        }

        autoTextSize(view)
        autoSize(view)
        autoPadding(view)
        autoMargin(view)

        if (view is ViewGroup) {
            auto(view)
        }
    }

    private fun auto(viewGroup: ViewGroup) {
        val count = viewGroup.childCount
        for (i in 0 until count) {
            val child = viewGroup.getChildAt(i)
            child?.let {
                auto(
                    it
                )
            }
        }
    }



    private fun autoMargin(view: View) {
        if (view.layoutParams !is MarginLayoutParams) {
            return
        }

        val lp = view.layoutParams as MarginLayoutParams
        lp.leftMargin =
            getDisplayWidthValue(
                lp.leftMargin
            )
        lp.topMargin =
            getDisplayHeightValue(
                lp.topMargin
            )
        lp.rightMargin =
            getDisplayWidthValue(
                lp.rightMargin
            )
        lp.bottomMargin =
            getDisplayHeightValue(
                lp.bottomMargin
            )
    }

    private fun autoPadding(view: View) {
        var l = view.paddingLeft
        var t = view.paddingTop
        var r = view.paddingRight
        var b = view.paddingBottom
        l =
            getDisplayWidthValue(
                l
            )
        t =
            getDisplayHeightValue(
                t
            )
        r =
            getDisplayWidthValue(
                r
            )
        b =
            getDisplayHeightValue(
                b
            )
        view.setPadding(l, t, r, b)
    }

    private fun autoSize(view: View) {
        val lp = view.layoutParams ?: return

        var isSquare = false
        if (lp.width == lp.height) {
            isSquare = true
        }

        if (lp.width > 0) {
            lp.width =
                getDisplayWidthValue(
                    lp.width
                )
        }

        if (lp.height > 0) {
            lp.height =
                getDisplayHeightValue(
                    lp.height
                )
        }

        if (isSquare) {
            when {
                lp.width > lp.height -> {
                    lp.width = lp.height
                }

                else -> {
                    lp.height = lp.width
                }
            }
        }
    }

    private fun autoTextSize(view: View?) {
        if (view is TextView) {
            val designPixels = view.textSize.toDouble()
            val displayPixels = textPixelsRate * designPixels
            view.includeFontPadding = false
            view.setTextSize(
                TypedValue.COMPLEX_UNIT_PX,
                displayPixels.toFloat()
            )
        }
    }



    private fun getDisplayWidthValue(designWidthValue: Int): Int {
        return if (abs(designWidthValue) < 2) {
            designWidthValue
        } else {
            designWidthValue * displayWidth / designWidth
        }
    }


    private fun getDisplayHeightValue(designHeightValue: Int): Int {
        return if (abs(designHeightValue) < 2) {
            designHeightValue
        } else {
            designHeightValue * displayHeight / designHeight
        }
    }
}