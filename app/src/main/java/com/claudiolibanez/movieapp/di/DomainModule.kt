package com.claudiolibanez.movieapp.di

import com.claudiolibanez.movieapp.data.repository.auth.FirebaseAuthenticationImpl
import com.claudiolibanez.movieapp.domain.repository.auth.FirebaseAuthentication
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindFirebaseAuthenticationImpl(
        firebaseAuthentication: FirebaseAuthenticationImpl
    ): FirebaseAuthentication

}