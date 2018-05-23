package blog.cmcmcmcm.webvideoarchiving.injection

import blog.cmcmcmcm.webvideoarchiving.ui.main.MainActivity
import blog.cmcmcmcm.webvideoarchiving.ui.main.MainActivityModule
import blog.cmcmcmcm.webvideoarchiving.ui.main.MainViewModelProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by daesoon.choi on 2018. 5. 23..
 */

@Module
abstract class ActivityBuilder {


    @ContributesAndroidInjector(modules = [MainActivityModule::class, MainViewModelProvider::class])
    abstract fun bindMainActivity(): MainActivity
}