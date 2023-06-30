package com.example.appclinicaunmsm.di

import com.example.appclinicaunmsm.data.repositorio.NoticiaRepositorioImp
import com.example.appclinicaunmsm.dominio.repositorio.NoticiaRepositorio
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoriesModule {
    @Binds
    abstract fun bindNoticiaRepository(imp: NoticiaRepositorioImp): NoticiaRepositorio

}
