package blog.cmcmcmcm.webvideoarchiving.ui.main.browser

import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import blog.cmcmcmcm.webvideoarchiving.common.navigator.NavigationDelegator
import blog.cmcmcmcm.webvideoarchiving.common.webview.ExpandWebClient
import blog.cmcmcmcm.webvideoarchiving.common.webview.NestedWebView
import blog.cmcmcmcm.webvideoarchiving.common.webview.WebClientDecorator
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 * Created by daesoon.choi on 2018. 5. 23..
 */

const val DEFAULT_URL = "http://m.sports.naver.com/video.nhn?id=431102"

class BrowserFragment : Fragment(),
                        NavigationDelegator  {

    private val webView: WebView?
        get() = view as WebView

    @Inject
    lateinit var browserViewModel: BrowserViewModel

    private val loadResourceDelegator = object : WebClientDecorator {
        override fun onLoadResource(view: WebView?, url: String?) {
            browserViewModel.onLoadWebResource(url ?: "")
        }
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
        Log.d("daesoon","BrowserFragment $browserViewModel")
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return NestedWebView(context).also { initWebView(it) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        webView?.loadUrl( savedInstanceState?.getString("url") ?: DEFAULT_URL )

        browserViewModel.browserNavigation.observe(this, Observer {
            when(it) {
                is BrowserNavi.GoBack -> goBack()
                is BrowserNavi.GoForward -> goForward()
            }
        })



    }

    override fun onBackPress() : Boolean {
        return goBack()
    }

    private fun goBack() = webView?.takeIf { it.canGoBack() }
                            .let {
                                it?.goBack()
                                it != null
                            }

    private fun goForward() = webView?.takeIf { it.canGoForward() }
                                .let {
                                    it?.goBack()
                                    it != null
                                }


    private fun initWebView(pWebView: WebView) = pWebView.apply {
        layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
        webViewClient = ExpandWebClient(arrayOf(loadResourceDelegator))
        settings.javaScriptEnabled = true
    }

}