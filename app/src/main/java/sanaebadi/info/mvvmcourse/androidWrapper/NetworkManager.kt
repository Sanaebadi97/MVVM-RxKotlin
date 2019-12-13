package sanaebadi.info.mvvmcourse.androidWrapper

import android.content.Context
import android.net.ConnectivityManager

class NetworkManager(private val applicationContext: Context) {

    val isConnected: Boolean?
        get() {
            val confManager =
                applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = confManager.activeNetworkInfo

            return networkInfo != null && networkInfo.isConnected
        }
}