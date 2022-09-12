package com.example.comunicalibras.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Aula(
    val descricao: String,
    val id: Int,
    @SerializedName("live_fim") val liveFim: String,
    @SerializedName("live_inicio") val liveInicio: String,
    val professor: Professor,
    val titulo: String,
    val video: String
): Parcelable