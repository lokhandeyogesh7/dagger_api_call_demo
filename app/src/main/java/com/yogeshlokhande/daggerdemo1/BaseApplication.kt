package com.yogeshlokhande.daggerdemo1

import android.app.Application
import com.yogeshlokhande.daggerdemo1.di.DaggerNetworkComponent
import com.yogeshlokhande.daggerdemo1.di.NetworkComponent
import com.yogeshlokhande.daggerdemo1.di.NetworksModule


class BaseApplication :Application(){

    lateinit var networkComponent:NetworkComponent

    override fun onCreate() {
        super.onCreate()
        networkComponent = DaggerNetworkComponent.builder()
                .networksModule(NetworksModule(Constants.baseUrl))//don't know why this is deprecated
                .build()
    }

    fun getNetworksComponent() :NetworkComponent{
        return  networkComponent
    }
}