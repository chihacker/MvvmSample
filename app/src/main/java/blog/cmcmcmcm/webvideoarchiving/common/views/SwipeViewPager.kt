package blog.cmcmcmcm.webvideoarchiving.common.views

import android.content.Context
import android.support.v4.view.MotionEventCompat
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * Created by daesoon.choi on 2018. 5. 23..
 */

class SwipeViewPager : ViewPager {

    var isSwipeEnabled = true

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {

        if(!isSwipeEnabled) {
            if (MotionEventCompat.getActionMasked(ev) != MotionEvent.ACTION_MOVE) {
                if (super.onInterceptTouchEvent(ev)) {
                    super.onTouchEvent(ev)
                }
            }
            return false
        }

        return super.onInterceptTouchEvent(ev)

    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return if (isSwipeEnabled) {
            super.onTouchEvent(ev)
        } else {
            MotionEventCompat.getActionMasked(ev) != MotionEvent.ACTION_MOVE && super.onTouchEvent(ev)
        }
    }


}