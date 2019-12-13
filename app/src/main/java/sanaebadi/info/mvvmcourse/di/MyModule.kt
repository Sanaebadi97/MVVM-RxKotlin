package sanaebadi.info.mvvmcourse.di

import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import sanaebadi.info.mvvmcourse.androidWrapper.NetworkManager
import sanaebadi.info.mvvmcourse.repository.MainRepository
import sanaebadi.info.mvvmcourse.viewModel.MainViewModel

val viewModelModule = module {

    //single keyword is for Single tone pattern , just write our single tone classes
    single { NetworkManager(applicationContext = androidContext()) }

    single { MainRepository(get() as NetworkManager) }

    viewModel { MainViewModel(get() as MainRepository) }
}