package com.claudiolibanez.movieapp.presenter.auth.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.claudiolibanez.movieapp.domain.usecase.auth.RegisterUseCase
import com.claudiolibanez.movieapp.utils.StateView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {

    fun register(email: String, password: String) = liveData(Dispatchers.IO) {
        try {

            emit(StateView.Loading())

            registerUseCase.invoke(email, password)

            emit(StateView.Success(Unit))

        } catch (exception: Exception) {

            exception.printStackTrace()

            emit(StateView.Error(message = exception.message))

        }
    }

}