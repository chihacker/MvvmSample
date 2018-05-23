package blog.cmcmcmcm.webvideoarchiving.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.support.v4.app.Fragment
import blog.cmcmcmcm.webvideoarchiving.common.rx.SchedulersFacade
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by daesoon.choi on 2018. 5. 23..
 */

class MainViewModel @Inject constructor(private val schedulersFacade: SchedulersFacade) : ViewModel() {

    private val dispoasbles = CompositeDisposable()


    val fragmentState = MutableLiveData<Fragment>()

    fun onFragmentChanged(fragment: Fragment) {
        fragmentState.value = fragment
    }

    override fun onCleared() {
        dispoasbles.clear()
    }

}