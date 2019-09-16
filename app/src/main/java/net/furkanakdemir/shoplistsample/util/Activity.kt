package net.furkanakdemir.shoplistsample.util

import android.content.Context
import android.graphics.Point
import android.view.WindowManager
import androidx.fragment.app.FragmentActivity

fun FragmentActivity.getWindowWidth(): Int {
    val wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val display = wm.defaultDisplay
    val size = Point()
    display.getSize(size)
    return size.x
}
