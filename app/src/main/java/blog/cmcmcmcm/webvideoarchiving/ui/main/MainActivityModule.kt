package blog.cmcmcmcm.webvideoarchiving.ui.main

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import blog.cmcmcmcm.webvideoarchiving.ui.main.browser.BrowserFragment
import blog.cmcmcmcm.webvideoarchiving.ui.main.browser.BrowserModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by daesoon.choi on 2018. 5. 23..
 */


@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = [BrowserModule::class])
    abstract fun bindBrowserFragment(): BrowserFragment


}