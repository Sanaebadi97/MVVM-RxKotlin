package sanaebadi.info.mvvmcourse.viewModel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import sanaebadi.info.mvvmcourse.extension.plusAssign
import sanaebadi.info.mvvmcourse.model.NameModel
import sanaebadi.info.mvvmcourse.repository.MainRepository

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    var isLoading = ObservableField<Boolean>(false)

    private val compositeDisposable = CompositeDisposable()

    val names = MutableLiveData<ArrayList<NameModel>>()
    fun loadData() {

        isLoading.set(true)
        compositeDisposable += mainRepository.loadData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { success: ArrayList<NameModel> ->
                    names.value = success
                    isLoading.set(false)
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

