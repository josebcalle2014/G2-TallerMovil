package com.example.appclinicaunmsm.di

import com.example.appclinicaunmsm.data.repositorio.NoticiaRepositorioImp
import com.example.appclinicaunmsm.data.repositorio.UsuarioRepositorioImp
import com.example.appclinicaunmsm.dominio.repositorio.NoticiaRepositorio
import com.example.appclinicaunmsm.dominio.repositorio.UsuarioRepositorio
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoriesModule {
    @Binds
    abstract fun bindNoticiaRepository(imp: NoticiaRepositorioImp): NoticiaRepositorio

    @Binds
    abstract fun bindUsuarioRepository(imp: UsuarioRepositorioImp): UsuarioRepositorio

}
