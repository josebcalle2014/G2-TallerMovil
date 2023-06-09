package com.example.appclinicaunmsm.di

import com.example.appclinicaunmsm.data.source.remoto.ApiInterfaz
import com.example.appclinicaunmsm.util.Constantes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiClinicaUNMSM {
    @Provides
    @Singleton
    fun obtenerApi():ApiInterfaz{
        return Retrofit
            .Builder()
            .baseUrl(Constantes.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()
            .create(ApiInterfaz::class.java)
    }

}