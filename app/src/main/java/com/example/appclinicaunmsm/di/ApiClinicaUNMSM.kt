package com.example.appclinicaunmsm.di

import com.example.appclinicaunmsm.data.source.remoto.ApiInterfaz
import com.example.appclinicaunmsm.util.Constantes
import com.google.android.gms.common.api.Api
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
    @Singleton
    @Provides
    fun obtenerApi(): ApiInterfaz {
        return Retrofit.Builder()
            .baseUrl(Constantes.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterfaz::class.java)
    }

}