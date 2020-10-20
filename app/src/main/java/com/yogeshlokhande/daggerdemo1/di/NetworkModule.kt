package com.yogeshlokhande.daggerdemo1.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module//as a part of network component hence declared as module
class NetworksModule(url: String) {

    var urlLink:String = url

    @Singleton//envoked only once hence used singletone
    @Provides//this will provide output hence marked as provides
    fun provideGson():Gson{
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson):Retrofit{
        val retrofit = Retrofit.Builder()
            .baseUrl(urlLink)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return retrofit
    }
}