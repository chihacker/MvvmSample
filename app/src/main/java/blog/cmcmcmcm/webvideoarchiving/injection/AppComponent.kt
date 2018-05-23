package blog.cmcmcmcm.webvideoarchiving.injection

import android.app.Application
import blog.cmcmcmcm.webvideoarchiving.VideoArchiverApp
import blog.cmcmcmcm.webvideoarchiving.usecase.UsecaseProvider
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by daesoon.choi on 2018. 5. 23..
 */


@Singleton
@Component(modules = [AndroidInjectionModule::class,
                      AppModule::class,
                      ActivityBuilder::class,
                      ViewModelModule::class,
                      UsecaseProvider::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: VideoArchiverApp)
}
