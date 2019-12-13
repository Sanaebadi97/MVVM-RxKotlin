package sanaebadi.info.mvvmcourse.repository

import android.os.Handler
import sanaebadi.info.mvvmcourse.model.NameModel
import sanaebadi.info.mvvmcourse.utilitis.RepositoryCallback

class MainRepository {

    fun loadData(repositoryCallBack: RepositoryCallback) {
        Handler().postDelayed({
            val nameList = ArrayList<NameModel>()
            nameList.add(NameModel("sana"))
            nameList.add(NameModel("Mahdi"))
            nameList.add(NameModel("Sara"))
            nameList.add(NameModel("Zahra"))
            nameList.add(NameModel("Amir"))

            repositoryCallBack.onDataFetched(nameList)


        }, 3000)
    }
}

