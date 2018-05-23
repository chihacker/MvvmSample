package blog.cmcmcmcm.webvideoarchiving.usecase

import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable

/**
 * Created by daesoon.choi on 2018. 5. 23..
 */

class VideoResourceUseCase {

    fun checkVideoResource(resource : String) : Single<String> {
        return Single.just(resource)
                .map {
                    if( it.contains(".mp4") || it.contains(".m3u8") ) it
                    else throw IllegalArgumentException()
                }
    }
}