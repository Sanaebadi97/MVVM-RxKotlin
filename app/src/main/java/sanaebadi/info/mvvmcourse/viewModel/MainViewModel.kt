package sanaebadi.info.mvvmcourse.viewModel

import androidx.databinding.ObservableField
import sanaebadi.info.mvvmcourse.model.NameModel
import sanaebadi.info.mvvmcourse.repository.MainRepository
import sanaebadi.info.mvvmcourse.utilitis.RepositoryCallback
import sanaebadi.info.mvvmcourse.utilitis.MainViewModelCallback

class MainViewModel(private val mainViewModelCallback: MainViewModelCallback) :
    RepositoryCallback {
    var isLoading = ObservableField<Boolean>(false)

    fun loadData() {
        val model = MainRepository()
        isLoading.set(true)
        model.loadData(this)

    }

    override fun onDataFetched(names: ArrayList<NameModel>) {
        mainViewModelCallback.onDataFetched(names)
        isLoading.set(false)

    }

}

