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



/**
 * @author y-mg
 *
 * 이것은 View 의 각 속성을 해상도에 맞게 자동으로 설정해주는 Object 클래스입니다.
 * This is an Object Class that automatically sets each property in the view to fit its resolution.
 */
object AutoScreenUtil {

    private var displayWidth = 0
    private var displayHeight = 0

    private var designWidth = 0
    private var designHeight = 0

    private var textPixelsRate = 0.0



    /**
     * Setting Display Size
     */
    @Suppress("DEPRECATION")
    internal fun setSize(
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



    /**
     * Setting StatusBar Height
     */
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



    /**
     * Setting Activity
     */
    internal fun auto(act: Activity?) {
        if (act == null || displayWidth < 1 || displayHeight < 1) {
            return
        }

        val view = act.window.decorView
        auto(view)
    }

    /**
     * Setting Fragment
     */
    internal fun auto(view: View?) {
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

    /**
     * Setting ViewGroup
     */
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



    /**
     * Setting Margin
     */
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



    /**
     * Setting Padding
     */
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



    /**
     * Setting Size(Width, Height)
     */
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



    /**
     * Setting Text Size
     */
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



    /**
     * Getting Display Width
     */
    private fun getDisplayWidthValue(designWidthValue: Int): Int {
        return if (abs(designWidthValue) < 2) {
            designWidthValue
        } else {
            designWidthValue * displayWidth / designWidth
        }
    }



    /**
     * Getting Display Height
     */
    private fun getDisplayHeightValue(designHeightValue: Int): Int {
        return if (abs(designHeightValue) < 2) {
            designHeightValue
        } else {
            designHeightValue * displayHeight / designHeight
        }
    }
}