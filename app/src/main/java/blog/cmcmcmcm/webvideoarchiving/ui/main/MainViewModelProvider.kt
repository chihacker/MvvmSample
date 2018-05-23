package blog.cmcmcmcm.webvideoarchiving.ui.main

import android.app.Activity
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import blog.cmcmcmcm.webvideoarchiving.injection.PerActivity
import blog.cmcmcmcm.webvideoarchiving.ui.main.browser.BrowserFragment
import blog.cmcmcmcm.webvideoarchiving.ui.main.browser.BrowserModule
import blog.cmcmcmcm.webvideoarchiving.ui.main.browser.BrowserViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

/**
 * Created by daesoon.choi on 2018. 5. 23..
 */

@Module
class MainViewModelProvider {


    @Provides
    fun provideMainViewModel(activity: MainActivity, factory: ViewModelProvider.Factory) : MainViewModel =
            ViewModelProviders.of(activity as AppCompatActivity, factory).get(MainViewModel::class.java)

    @Provides
    fun provideBrowserViewModel(activity: MainActivity, factory: ViewModelProvider.Factory) : BrowserViewModel =
            ViewModelProviders.of(activity as AppCompatActivity, factory).get(BrowserViewModel::class.java)



}