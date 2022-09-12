package com.example.comunicalibras.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Plano(
    val codigo: String,
    val id: Int,
    val nome: String,
    val valor: Double
): Parcelable