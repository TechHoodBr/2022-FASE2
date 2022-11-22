package com.example.comunicalibras.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Plano(
    val codigo: String?=null,
    val id: Int,
    val nome: String?=null,
    val valor: Double?=null
): Parcelable