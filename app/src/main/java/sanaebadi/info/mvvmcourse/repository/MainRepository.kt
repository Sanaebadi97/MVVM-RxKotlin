package sanaebadi.info.mvvmcourse.repository

import io.reactivex.Observable
import sanaebadi.info.mvvmcourse.androidWrapper.NetworkManager
import sanaebadi.info.mvvmcourse.model.NameModel
import java.util.concurrent.TimeUnit

class MainRepository(private val netManager:NetworkManager) {

    fun loadData(): Observable<ArrayList<NameModel>> {
        val onlineList = ArrayList<NameModel>()
        onlineList.add(NameModel("sana"))
        onlineList.add(NameModel("Mahdi"))
        onlineList.add(NameModel("Sara"))
        onlineList.add(NameModel("Zahra"))
        onlineList.add(NameModel("Amir"))

        val offlineList=ArrayList<NameModel>()
        offlineList.add(NameModel("sana offline"))
        offlineList.add(NameModel("Mahdi offline"))
        offlineList.add(NameModel("Sara offline"))
        offlineList.add(NameModel("Zahra offline"))
        offlineList.add(NameModel("Amir offline"))

        if (netManager.isConnected!!){
            return Observable.just(onlineList).delay(3, TimeUnit.SECONDS)
        }else{
            return Observable.just(offlineList).delay(3, TimeUnit.SECONDS)
        }



    }
}

