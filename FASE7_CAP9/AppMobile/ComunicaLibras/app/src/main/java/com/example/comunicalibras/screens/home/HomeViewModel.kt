package com.example.comunicalibras.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comunicalibras.data.Service
import com.example.comunicalibras.data.models.Aula
import com.example.comunicalibras.data.models.Credentials
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : ViewModel() {

    private val service = Service()

    private val _aulaRequest = MutableLiveData<List<Aula>>()
    val aulaRequest: LiveData<List<Aula>>
        get() = _aulaRequest

    private val _requestFailed = MutableLiveData<String>()
    val requestFailed: LiveData<String>
        get() = _requestFailed

    fun getClasses() {
        viewModelScope.launch(Dispatchers.IO) {
            val request = service.getClasses()
            withContext(Dispatchers.Main) {
                if (request.isSuccessful) _aulaRequest.value = request.body()
                else _requestFailed.value = request.message() ?: "Erro"
            }
        }
    }
}