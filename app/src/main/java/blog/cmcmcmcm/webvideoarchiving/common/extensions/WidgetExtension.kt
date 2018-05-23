package blog.cmcmcmcm.webvideoarchiving.common.extensions

import android.content.Context
import android.widget.Toast

/**
 * Created by daesoon.choi on 2018. 5. 23..
 */

fun showToast(context: Context, message: String) {
    Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
}