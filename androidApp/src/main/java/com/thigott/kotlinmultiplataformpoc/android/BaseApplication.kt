package com.thigott.kotlinmultiplataformpoc.android

import android.app.Application
import com.thigott.kotlinmultiplataformlibrary.di.dataModule
import com.thigott.kotlinmultiplataformlibrary.di.domainModule
import com.thigott.kotlinmultiplataformpoc.di.navigationModule
import com.thigott.kotlinmultiplataformpoc.di.presentationModule
import org.koin.core.context.GlobalContext.startKoin

class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                listOf(
                    domainModule,
                    navigationModule,
                    presentationModule,
                    dataModule
                )
            )
        }
    }
}