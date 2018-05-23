package blog.cmcmcmcm.webvideoarchiving.injection

import android.app.Activity
import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity
import dagger.Binds
import dagger.Module

/**
 * Created by daesoon.choi on 2018. 5. 23..
 */



@Module
abstract class AppModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

}