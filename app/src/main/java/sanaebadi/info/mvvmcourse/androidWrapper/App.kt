package sanaebadi.info.mvvmcourse.androidWrapper

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import sanaebadi.info.mvvmcourse.di.viewModelModule

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            // declare used Android context
            androidContext(this@App)

            modules(viewModelModule)
        }
    }
}