package com.claudiolibanez.movieapp.domain.usecase.auth

import com.claudiolibanez.movieapp.domain.repository.auth.FirebaseAuthentication

class ForgotUseCase constructor(
    private val firebaseAuthentication: FirebaseAuthentication
) {
    suspend operator fun invoke(email: String) {
        firebaseAuthentication.forgot(email)
    }
}