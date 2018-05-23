package blog.cmcmcmcm.webvideoarchiving.common.webview

import android.graphics.Bitmap
import android.webkit.*

/**
 * Created by daesoon.choi on 2018. 5. 23..
 */

interface WebClientDecorator {
    fun onPageFinished(view: WebView?, url: String?) {}

    fun onReceivedError(view: WebView?, errorCode: Int, description: String?, failingUrl: String?) {}

    fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {}

    fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {}

    fun onLoadResource(view: WebView?, url: String?) {}
}