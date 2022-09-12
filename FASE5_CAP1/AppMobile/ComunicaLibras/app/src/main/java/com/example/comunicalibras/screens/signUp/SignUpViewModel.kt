package com.example.comunicalibras.screens.signUp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comunicalibras.data.Service
import com.example.comunicalibras.data.models.Plano
import com.example.comunicalibras.data.models.Professor
import com.example.comunicalibras.data.models.TipoUsuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignUpViewModel : ViewModel() {

    private val service = Service()

    private val _signUpRequest = MutableLiveData<Professor>()
    val signUpRequest: LiveData<Professor>
        get() = _signUpRequest

    private val _requestFailed = MutableLiveData<String>()
    val requestFailed: LiveData<String>
        get() = _requestFailed

    fun signUp(login: String, password: String, nome: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val request = service.signUp(
                Professor(
                    login = login,
                    nome = nome,
                    plano = Plano(id = 1),
                    senha = password,
                    tipoUsuario = TipoUsuario(id = 1)
                )
            )
            withContext(Dispatchers.Main) {
                if (request.isSuccessful) _signUpRequest.value = request.body()
                else _requestFailed.value = request.message() ?: "Erro ao fazer cadastro"
            }
        }
    }
}