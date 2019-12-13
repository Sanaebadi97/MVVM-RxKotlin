package sanaebadi.info.mvvmcourse.utilitis

import sanaebadi.info.mvvmcourse.model.NameModel

interface MainViewModelCallback {
    fun onDataFetched(names: ArrayList<NameModel>)
}