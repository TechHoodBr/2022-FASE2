package com.example.comunicalibras.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comunicalibras.data.Service
import com.example.comunicalibras.data.models.Credentials
import com.example.comunicalibras.data.models.Professor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel : ViewModel() {

    private val service = Service()

    private val _loginRequest = MutableLiveData<Professor>()
    val loginRequest: LiveData<Professor>
        get() = _loginRequest

    private val _requestFailed = MutableLiveData<String>()
    val requestFailed: LiveData<String>
        get() = _requestFailed

    fun login(login: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val request = service.login(Credentials(login, password))
            withContext(Dispatchers.Main) {
                if (request.isSuccessful) _loginRequest.value = request.body()
                else _requestFailed.value = request.message() ?: "Erro ao fazer login"
            }
        }
    }
}