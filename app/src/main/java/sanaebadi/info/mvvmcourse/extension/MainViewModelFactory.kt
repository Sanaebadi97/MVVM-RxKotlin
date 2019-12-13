package sanaebadi.info.mvvmcourse.extension

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import sanaebadi.info.mvvmcourse.androidWrapper.NetworkManager
import sanaebadi.info.mvvmcourse.repository.MainRepository
import sanaebadi.info.mvvmcourse.viewModel.MainViewModel

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(val networkManager: NetworkManager) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return MainViewModel(MainRepository(networkManager)) as T
    }
}