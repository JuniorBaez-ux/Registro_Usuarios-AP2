package com.example.registro_usarios_ap2.viewmodel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.registro_usarios_ap2.databinding.RowClienteBinding
import com.example.registro_usarios_ap2.model.Cliente

class ClientesAdapter(
    private var onItemClicked: ((cliente:Cliente) -> Unit)
) :
    ListAdapter<Cliente, ClientesAdapter.ClienteViewHolder>(ClienteDiffCallBack()) {

    override fun onBindViewHolder(holder: ClienteViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClienteViewHolder {
        val binding =
            RowClienteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClienteViewHolder(binding)
    }

    inner class ClienteViewHolder(private val binding: RowClienteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Cliente) {
            binding.clienteIdTextView.text = item.clienteId.toString()
            binding.clienteextView.text = item.nombre
            binding.balanceTextView.text = item.balance.toString()

            binding.root.setOnClickListener {
                onItemClicked(item)
            }
        }
    }
}

class ClienteDiffCallBack : DiffUtil.ItemCallback<Cliente>() {
    override fun areItemsTheSame(oldItem: Cliente, newItem: Cliente): Boolean {
        return oldItem.clienteId == newItem.clienteId
    }

    override fun areContentsTheSame(oldItem: Cliente, newItem: Cliente): Boolean {
        return oldItem == newItem
    }
}