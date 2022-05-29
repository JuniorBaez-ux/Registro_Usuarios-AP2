package com.example.registro_usarios_ap2.viewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.registro_usarios_ap2.databinding.ListaClientesFragmentBinding
import com.example.registro_usarios_ap2.model.Cliente
import com.example.registro_usarios_ap2.model.Ocupacion
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListaClientesFragment : Fragment() {

    private val viewModel: ClienteViewModel by viewModels()
    private lateinit var binding: ListaClientesFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListaClientesFragmentBinding.inflate(inflater, container, false)

        val adapter = ClientesAdapter(::openClientesFragment)

        binding.clientesRecyclerView.adapter = adapter

        lifecycleScope.launch {
            viewModel.clientes.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect { lista ->
                    adapter.submitList(lista)
                }
        }

        binding.agregarButton.setOnClickListener {
            openClientesFragment()
        }

        binding.ocupacionButton.setOnClickListener {
            openOcupacionesFragment()
        }

        return binding.root
    }

    fun openClientesFragment(cliente: Cliente?=null)  {
        val action = ListaClientesFragmentDirections.actionToClientesFragment(cliente)
       findNavController().navigate(action)
    }

    fun openOcupacionesFragment(ocupacion: Ocupacion?=null)  {
        val action = ListaClientesFragmentDirections.actionToOcupacionesFragment()
        findNavController().navigate(action)
    }
}