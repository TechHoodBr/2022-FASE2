package com.example.comunicalibras.screens.home

import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.comunicalibras.R
import com.example.comunicalibras.data.models.Aula
import com.example.comunicalibras.databinding.ItemHomeClassesBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class AulaAdapter : ListAdapter<Aula, AulaAdapter.AulaViewHolder>(AulaDiffCallback) {

    var onClick: (Aula) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AulaViewHolder {
        val binding = ItemHomeClassesBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return AulaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AulaViewHolder, position: Int) {
        val aula = getItem(position)
        holder.bind(aula)
    }

    val formatter = DateTimeFormatter.ofPattern("dd/MM - HH:mm")

    inner class AulaViewHolder(private val binding: ItemHomeClassesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(aula: Aula) {
            Glide.with(binding.root)
                .load(aula.professor.avatar)
                .into(binding.imageView)

            binding.teacherName.text = aula.titulo
            binding.teacherCity.text = aula.professor.nome

            if (aula.video == null) {
                binding.dimCard.visibility = VISIBLE
                binding.iconLive.visibility = VISIBLE
                val localDateTime = LocalDateTime.parse(aula.liveInicio)
                val output = formatter.format(localDateTime)
                binding.textCallNow.text = output
            } else {
                binding.dimCard.visibility = GONE
                binding.iconLive.visibility = GONE
                binding.textCallNow.text = binding.root.context.getString(R.string.assista_agora)

            }
            binding.card.setOnClickListener { onClick(aula) }
            binding.textCallNow.setOnClickListener { onClick(aula) }
        }
    }
}

object AulaDiffCallback : DiffUtil.ItemCallback<Aula>() {
    override fun areItemsTheSame(oldItem: Aula, newItem: Aula): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Aula, newItem: Aula): Boolean {
        return oldItem.id == newItem.id
    }
}