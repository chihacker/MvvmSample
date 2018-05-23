package blog.cmcmcmcm.webvideoarchiving.usecase

import blog.cmcmcmcm.webvideoarchiving.ui.main.MainViewModelProvider
import blog.cmcmcmcm.webvideoarchiving.ui.main.browser.BrowserFragment
import blog.cmcmcmcm.webvideoarchiving.ui.main.browser.BrowserModule
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

/**
 * Created by daesoon.choi on 2018. 5. 23..
 */

@Module
class UsecaseProvider {

    @Singleton
    @Provides
    fun provideVideoResourceUseCase() = VideoResourceUseCase()



}