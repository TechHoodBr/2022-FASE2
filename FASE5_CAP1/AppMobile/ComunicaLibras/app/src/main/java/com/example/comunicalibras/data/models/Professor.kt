package com.example.comunicalibras.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Professor(
    val avatar: String,
    val id: Int,
    val login: String,
    val nome: String,
    val plano: Plano,
    val senha: String,
    val tipoUsuario: TipoUsuario,
): Parcelable