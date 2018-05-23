package blog.cmcmcmcm.webvideoarchiving.injection

import dagger.Reusable
import javax.inject.Scope

/**
 * Created by daesoon.choi on 2018. 5. 23..
 */

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerFragment
