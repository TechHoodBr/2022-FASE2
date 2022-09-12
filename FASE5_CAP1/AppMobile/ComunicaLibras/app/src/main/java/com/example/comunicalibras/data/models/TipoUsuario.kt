package com.example.comunicalibras.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TipoUsuario(
    val id: Int,
    val nome: String
): Parcelable