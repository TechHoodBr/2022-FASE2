package com.example.comunicalibras.data

import android.content.SharedPreferences
import com.example.comunicalibras.data.models.Plano
import com.example.comunicalibras.data.models.Professor
import com.example.comunicalibras.data.models.TipoUsuario

class Session(private val sharedPref: SharedPreferences) {

    fun getUserInfo(): Professor {
        with (sharedPref) {
            val professor = Professor(
                avatar = getString(AVATAR, "") ?: "",
                id = getInt(ID, 0),
                login = getString(LOGIN, "") ?: "",
                nome = getString(NOME, "") ?: "",
                plano = Plano(
                    codigo = getString(PLANO_CODIGO, "") ?: "",
                    id = 0,
                    nome = "",
                    valor = 0.0
                ),
                senha = "",
                tipoUsuario = TipoUsuario(id = 0, nome = getString(AVATAR, "") ?: "")
            )
            return professor
        }
    }

    fun isLoggedIn(): Boolean {
        return sharedPref.getString(LOGIN, null)?.isNotEmpty() ?: false
    }

    fun logOut() {
        sharedPref.edit().clear().apply()
    }

    fun saveUserInfo(professor: Professor) {
        with (sharedPref.edit()) {
            putString(LOGIN, professor.login)
            putString(NOME, professor.nome)
            putInt(ID, professor.id)
            putString(PLANO_CODIGO, professor.plano.codigo)
            putString(TIPO_USUARIO, professor.tipoUsuario.nome)
            putString(AVATAR, professor.avatar)
            apply()
        }
    }

    companion object {
        const val LOGIN = "Login"
        const val NOME = "Nome"
        const val ID = "Id"
        const val PLANO_CODIGO = "PlanoCodigo"
        const val TIPO_USUARIO = "TipoUsuario"
        const val AVATAR = "Avatar"
    }

}