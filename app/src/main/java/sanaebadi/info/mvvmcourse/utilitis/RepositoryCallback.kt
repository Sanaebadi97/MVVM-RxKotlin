package sanaebadi.info.mvvmcourse.utilitis

import sanaebadi.info.mvvmcourse.model.NameModel

interface RepositoryCallback {
    fun onDataFetched(names: ArrayList<NameModel>)
}