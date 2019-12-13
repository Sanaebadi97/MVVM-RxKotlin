package sanaebadi.info.mvvmcourse.repository

import io.reactivex.Observable
import sanaebadi.info.mvvmcourse.model.NameModel
import java.util.concurrent.TimeUnit

class MainRepository {

    fun loadData(): Observable<ArrayList<NameModel>> {
        val nameList = ArrayList<NameModel>()
        nameList.add(NameModel("sana"))
        nameList.add(NameModel("Mahdi"))
        nameList.add(NameModel("Sara"))
        nameList.add(NameModel("Zahra"))
        nameList.add(NameModel("Amir"))

        return Observable.just(nameList).delay(3, TimeUnit.SECONDS)

    }
}

