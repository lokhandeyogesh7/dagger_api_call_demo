package com.yogeshlokhande.daggerdemo1.di

import com.yogeshlokhande.daggerdemo1.MainActivity
import dagger.Component
import javax.inject.Singleton


@Singleton//normal singletone class which will create only one instance of this class throughout the application
@Component(modules = [NetworksModule::class])//this will live throughout the application life
interface NetworkComponent {
    fun inject(activity: MainActivity?)
}