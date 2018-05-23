package blog.cmcmcmcm.webvideoarchiving.common.webview

import android.graphics.Bitmap
import android.webkit.*

/**
 * Created by daesoon.choi on 2018. 5. 23..
 */

class ExpandWebClient( pDecorators: Array<WebClientDecorator>? = null) : WebViewClient() {

    private val decorators = mutableListOf<WebClientDecorator>()

    init {
        pDecorators?.also { decorators.addAll(it) }
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        decorators.forEach { it.onPageFinished(view, url) }
    }


    override fun onReceivedError(view: WebView?, errorCode: Int, description: String?, failingUrl: String?) {
        super.onReceivedError(view, errorCode, description, failingUrl)
        decorators.forEach { it.onReceivedError(view, errorCode, description, failingUrl) }
    }

    override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
        super.onReceivedError(view, request, error)
        decorators.forEach { it.onReceivedError(view, request, error) }
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        decorators.forEach { it.onPageStarted(view, url, favicon) }
    }


    override fun onLoadResource(view: WebView?, url: String?) {
        super.onLoadResource(view, url)
        decorators.forEach { it.onLoadResource(view, url) }
    }
}