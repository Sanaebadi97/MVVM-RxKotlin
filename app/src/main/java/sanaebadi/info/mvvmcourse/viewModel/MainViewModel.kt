package sanaebadi.info.mvvmcourse.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import sanaebadi.info.mvvmcourse.extension.plusAssign
import sanaebadi.info.mvvmcourse.model.NameModel
import sanaebadi.info.mvvmcourse.repository.MainRepository

class MainViewModel : ViewModel() {
    var isLoading = MutableLiveData<Boolean>()

    private val mainRepository: MainRepository = MainRepository()
    private val compositeDisposable = CompositeDisposable()

    val names = MutableLiveData<ArrayList<NameModel>>()
    fun loadData() {
        compositeDisposable += mainRepository.loadData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { success: ArrayList<NameModel> ->
                    names.value = success

                },
                { error ->
                    Log.e("RX ERROR", "Loading $error")
                }
            )
    }

    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }

}

