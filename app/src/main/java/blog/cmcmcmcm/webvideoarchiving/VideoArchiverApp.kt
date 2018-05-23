package blog.cmcmcmcm.webvideoarchiving

import android.app.Activity
import android.app.Application
import blog.cmcmcmcm.webvideoarchiving.injection.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by daesoon.choi on 2018. 5. 23..
 */

class VideoArchiverApp : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this)

    }

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector
}