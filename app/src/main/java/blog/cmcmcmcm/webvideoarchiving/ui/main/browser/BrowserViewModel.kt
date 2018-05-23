package blog.cmcmcmcm.webvideoarchiving.ui.main.browser

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import blog.cmcmcmcm.webvideoarchiving.common.rx.SchedulersFacade
import blog.cmcmcmcm.webvideoarchiving.usecase.VideoResourceUseCase
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by daesoon.choi on 2018. 5. 23..
 */

class BrowserViewModel @Inject constructor( private val schedulersFacade: SchedulersFacade,
                                            private val videoResourceUseCase: VideoResourceUseCase) : ViewModel() {

    private val dispoasbles = CompositeDisposable()

    val browserNavigation = MutableLiveData<BrowserNavi>()
    val videoResource = MutableLiveData<VideoResource>()

    fun onNextClick() {
        browserNavigation.value = BrowserNavi.GoForward()
    }

    fun onPrevClick() {
        browserNavigation.value = BrowserNavi.GoBack()
    }

    fun onAddVideoClick() {
        browserNavigation.value = BrowserNavi.Add()
        videoResource.value = VideoResource.Empty()
    }

    fun onLoadWebResource(url: String) {
        dispoasbles.add(videoResourceUseCase.checkVideoResource(url)
                .subscribeOn(schedulersFacade.io())
                .observeOn(schedulersFacade.ui())
                .subscribe(
                        { videoResource.value = VideoResource.Item(it) },
                        { /* Nothing */ }
                )
        )
    }

    override fun onCleared() {
        dispoasbles.clear()
    }

}

sealed class BrowserNavi {
    class GoBack : BrowserNavi()
    class GoForward : BrowserNavi()
    class Add() : BrowserNavi()
}

sealed class VideoResource {
    data class Item(val url: String) : VideoResource()
    class Empty : VideoResource()
}


