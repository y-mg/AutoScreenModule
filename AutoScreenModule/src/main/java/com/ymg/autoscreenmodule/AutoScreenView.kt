package com.ymg.autoscreenmodule

import android.app.Activity
import android.util.DisplayMetrics
import android.view.View



/**
 * @author y-mg
 *
 * 이것은 화면을 해상도에 맞게 자동으로 설정해주는 Object 클래스입니다.
 * This is an Object Class that automatically sets the screen to the resolution.
 */
@Suppress("DEPRECATION")
object AutoScreenView {

    /**
     * - Activity 의 밀도를 자동으로 설정한다.
     * - The density of the Activity is automatically set.
     *
     * @param activity -> Activity
     *
     * @param hasStatusBar -> Status bar Status
     */
    @Suppress("DEPRECATION")
    fun setActivityView(activity: Activity, hasStatusBar: Boolean = true) {
        val displayMetrics = DisplayMetrics()
        activity.windowManager?.defaultDisplay?.getMetrics(displayMetrics)

        when (displayMetrics.densityDpi) {
            DisplayMetrics.DENSITY_LOW -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 320, 480)
            }

            DisplayMetrics.DENSITY_140 -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 400, 600)
            }

            DisplayMetrics.DENSITY_MEDIUM -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 480, 720)
            }

            DisplayMetrics.DENSITY_180 -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 540, 810)
            }

            DisplayMetrics.DENSITY_200 -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 600, 900)
            }

            DisplayMetrics.DENSITY_220 -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 660, 990)
            }

            DisplayMetrics.DENSITY_HIGH -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 720, 1080)
            }

            DisplayMetrics.DENSITY_260 -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 780, 1170)
            }

            DisplayMetrics.DENSITY_280 -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 840, 1260)
            }
            
            DisplayMetrics.DENSITY_300 -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 900, 1350)
            }
                
            DisplayMetrics.DENSITY_XHIGH -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 960, 1440)
            }
            
            DisplayMetrics.DENSITY_340 -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 1020, 1530)
            }
            
            DisplayMetrics.DENSITY_360 -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 1080, 1710)
            }

            DisplayMetrics.DENSITY_400 -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 1200, 1800)
            }
            
            DisplayMetrics.DENSITY_420 -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 1260, 1890)
            }
            
            DisplayMetrics.DENSITY_440 -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 1320, 1980)
            }
            
            DisplayMetrics.DENSITY_450 -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 1350, 2025)
            }
            
            DisplayMetrics.DENSITY_XXHIGH -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 1440, 2160)
            }

            DisplayMetrics.DENSITY_560 -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 1680, 2520)
            }
            
            DisplayMetrics.DENSITY_600 -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 1800, 2700)
            }
            
            DisplayMetrics.DENSITY_XXXHIGH -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 1920, 2880)
            }

            else -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, displayMetrics.widthPixels, displayMetrics.heightPixels)
            }
        }
        AutoScreenUtil.auto(activity)
    }



    /**
     * - Fragment 의 밀도를 자동으로 설정한다.
     * - The density of the Fragment is automatically set.
     *
     * @param activity -> Activity
     *
     * @param view -> View of Fragment
     *
     * @param hasStatusBar -> Status bar Status
     */
    fun setFragmentView(activity: Activity, view: View?, hasStatusBar: Boolean = true) {
        val displayMetrics = DisplayMetrics()
        activity.windowManager?.defaultDisplay?.getMetrics(displayMetrics)

        when (displayMetrics.densityDpi) {
            DisplayMetrics.DENSITY_LOW -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 320, 480)
            }

            DisplayMetrics.DENSITY_140 -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 400, 600)
            }

            DisplayMetrics.DENSITY_MEDIUM -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 480, 720)
            }

            DisplayMetrics.DENSITY_180 -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 540, 810)
            }

            DisplayMetrics.DENSITY_200 -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 600, 900)
            }

            DisplayMetrics.DENSITY_220 -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 660, 990)
            }

            DisplayMetrics.DENSITY_HIGH -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 720, 1080)
            }

            DisplayMetrics.DENSITY_260 -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 780, 1170)
            }

            DisplayMetrics.DENSITY_280 -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 840, 1260)
            }

            DisplayMetrics.DENSITY_300 -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 900, 1350)
            }

            DisplayMetrics.DENSITY_XHIGH -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 960, 1440)
            }

            DisplayMetrics.DENSITY_340 -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 1020, 1530)
            }

            DisplayMetrics.DENSITY_360 -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 1080, 1710)
            }

            DisplayMetrics.DENSITY_400 -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 1200, 1800)
            }

            DisplayMetrics.DENSITY_420 -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 1260, 1890)
            }

            DisplayMetrics.DENSITY_440 -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 1320, 1980)
            }

            DisplayMetrics.DENSITY_450 -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 1350, 2025)
            }

            DisplayMetrics.DENSITY_XXHIGH -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 1440, 2160)
            }

            DisplayMetrics.DENSITY_560 -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 1680, 2520)
            }

            DisplayMetrics.DENSITY_600 -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 1800, 2700)
            }

            DisplayMetrics.DENSITY_XXXHIGH -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, 1920, 2880)
            }

            else -> {
                AutoScreenUtil.setSize(activity, hasStatusBar, displayMetrics.widthPixels, displayMetrics.heightPixels)
            }
        }
        AutoScreenUtil.auto(view)
    }



    /**
     * - ItemView 의 밀도를 자동으로 설정한다.
     * - The density of the ItemView is automatically set.
     *
     * @param view -> Item View
     */
    fun setItemView(view: View?) {
        AutoScreenUtil.auto(view)
    }
}