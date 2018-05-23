package blog.cmcmcmcm.webvideoarchiving.common.extensions

import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by daesoon.choi on 2018. 5. 23..
 */

fun ViewGroup.inflate(resourceId: Int, attach: Boolean) =
        LayoutInflater.from(context).inflate(resourceId,this, attach)