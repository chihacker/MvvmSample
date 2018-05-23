package blog.cmcmcmcm.webvideoarchiving.common.extensions

import android.net.Uri

/**
 * Created by daesoon.choi on 2018. 5. 23..
 */

fun String.toUri() : Uri = Uri.parse(this)