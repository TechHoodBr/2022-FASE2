package com.example.comunicalibras.screens.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.comunicalibras.data.models.Aula
import com.example.comunicalibras.databinding.ItemHomeClassesBinding

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

    inner class AulaViewHolder(val binding: ItemHomeClassesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(aula: Aula) {
            Glide.with(binding.root)
                .load(aula.professor.avatar)
                .into(binding.imageView)

            binding.teacherName.text = aula.titulo
            binding.teacherCity.text = aula.professor.nome
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