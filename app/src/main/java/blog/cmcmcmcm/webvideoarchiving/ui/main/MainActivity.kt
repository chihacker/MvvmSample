package blog.cmcmcmcm.webvideoarchiving.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.util.Log
import blog.cmcmcmcm.webvideoarchiving.R
import blog.cmcmcmcm.webvideoarchiving.ui.main.browser.BrowserFragment
import blog.cmcmcmcm.webvideoarchiving.ui.main.browser.BrowserViewModel
import blog.cmcmcmcm.webvideoarchiving.ui.main.browser.VideoResource
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import kotlinx.android.synthetic.main.activity_main.*
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by daesoon.choi on 2018. 5. 23..
 */

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector, ViewPager.OnPageChangeListener {


    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var browserViewModel: BrowserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Viewpager 설정
        with(mainPager) {
            isSwipeEnabled = false
            adapter = FragmentAdapter(supportFragmentManager)
            addOnPageChangeListener(this@MainActivity)
        }

        //Tab Layout 설정
        mainTab.setupWithViewPager(mainPager)

        // browser 버튼 설정
        btnAddVideo.setOnClickListener { browserViewModel.onAddVideoClick() }
        btnPrev.setOnClickListener { browserViewModel.onPrevClick() }
        btnNext.setOnClickListener { browserViewModel.onNextClick() }

        btnAddVideo.hide()

        browserViewModel.videoResource.observe(this, Observer {
            when(it) {
                is VideoResource.Item -> btnAddVideo.show()
                is VideoResource.Empty -> btnAddVideo.hide()
            }
        })

        Log.d("daesoon","MainActivity $browserViewModel")


    }

    override fun onPageScrollStateChanged(state: Int) {}

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

    override fun onPageSelected(position: Int) {
        mainViewModel.onFragmentChanged(supportFragmentManager.fragments[position])
    }

    class FragmentAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
        override fun getItem(position: Int) =
                when(position) {
                    0 -> BrowserFragment()
                    else -> throw IllegalArgumentException()
                }

        override fun getPageTitle(position: Int) =
                when(position) {
                    0 -> "브라우저"
                    else -> "동영상"
                }

        override fun getCount() = 1
    }

    override fun supportFragmentInjector() : AndroidInjector<Fragment> = fragmentDispatchingAndroidInjector

}
