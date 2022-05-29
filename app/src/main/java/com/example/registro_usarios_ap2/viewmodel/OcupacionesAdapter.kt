package com.example.registro_usarios_ap2.viewmodel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.registro_usarios_ap2.databinding.RowOcupacionBinding
import com.example.registro_usarios_ap2.model.Ocupacion

class OcupacionesAdapter(
    private var onItemClicked: ((ocupacion: Ocupacion) -> Unit)
) :
    ListAdapter<Ocupacion, OcupacionesAdapter.OcupacionViewHolder>(OcupacionDiffCallBack()) {

    override fun onBindViewHolder(holder: OcupacionViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OcupacionViewHolder {
        val binding =
            RowOcupacionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OcupacionViewHolder(binding)
    }

    inner class OcupacionViewHolder(private val binding: RowOcupacionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Ocupacion) {
            binding.ocupacionIdTextView.text = item.ocupacionId.toString()
            binding.descripcionTextView.text = item.descripcion
            binding.ingresosTextView.text = item.Ingresos.toString()

            binding.root.setOnClickListener {
                onItemClicked(item)
            }
        }
    }
}

class OcupacionDiffCallBack : DiffUtil.ItemCallback<Ocupacion>() {
    override fun areItemsTheSame(oldItem: Ocupacion, newItem: Ocupacion): Boolean {
        return oldItem.ocupacionId == newItem.ocupacionId
    }

    override fun areContentsTheSame(oldItem: Ocupacion, newItem: Ocupacion): Boolean {
        return oldItem == newItem
    }
}