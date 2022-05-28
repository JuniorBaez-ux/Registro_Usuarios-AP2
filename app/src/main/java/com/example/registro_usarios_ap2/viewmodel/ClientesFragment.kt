package com.example.registro_usarios_ap2.viewmodel

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.registro_usarios_ap2.databinding.ClientesFragmentBinding
import com.example.registro_usarios_ap2.model.Cliente
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ClientesFragment : Fragment() {

    private val viewModel: ClienteViewModel by viewModels()
    private lateinit var binding: ClientesFragmentBinding

    // get the arguments
    private val args : ClientesFragmentArgs by navArgs()

    private var clienteId: Int =0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ClientesFragmentBinding.inflate(inflater, container, false)

        LlenarCampos()


        binding.guardarButton.setOnClickListener {
            viewModel.guardar(Cliente(
                0,
                binding.clienteEditText.text.toString(),
                binding.emailEditText.text.toString(),
                binding.ocuapcionEditText.text.toString().toInt(),
                binding.balanceEditText.floatValue()
            ))
        }

        viewModel.guardado.observe(viewLifecycleOwner){
            if (it) {
                Snackbar.make(binding.balanceEditText, "Guardo", Snackbar.LENGTH_LONG).show()
                findNavController().navigateUp()
            }
        }

        return binding.root
    }


    fun LlenarCampos(){
        val cliente: Cliente? = args.cliente

        cliente?.let {
            clienteId = it.clienteId
            binding.clienteEditText.setText(it.nombre)
            binding.emailEditText.setText(it.email)
            binding.ocuapcionEditText.setText(it.ocupacionId.toString())
            binding.balanceEditText.setText(it.balance.toString())
        }
    }

    fun TextInputEditText.floatValue() = text.toString().toFloatOrNull() ?: 0.0f


}