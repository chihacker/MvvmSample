package blog.cmcmcmcm.webvideoarchiving.injection

import android.arch.lifecycle.ViewModel
import blog.cmcmcmcm.webvideoarchiving.ui.main.MainViewModel
import blog.cmcmcmcm.webvideoarchiving.ui.main.browser.BrowserViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by daesoon.choi on 2018. 5. 23..
 */

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(BrowserViewModel::class)
    abstract fun bindBrowserViewModel(browserViewModel: BrowserViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel) : ViewModel
}