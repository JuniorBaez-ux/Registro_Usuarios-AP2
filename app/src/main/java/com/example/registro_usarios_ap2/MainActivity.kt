package com.example.registro_usarios_ap2

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import com.example.registro_usarios_ap2.databinding.ActivityMainBinding
import com.example.registro_usarios_ap2.model.Cliente
import com.example.registro_usarios_ap2.viewmodel.ClienteViewModel
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class   MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ClienteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.guardarButton.setOnClickListener {
            viewModel.guardar(Cliente(
                0,
                binding.clienteEditText.text.toString(),
                binding.emailEditText.text.toString(),
                binding.ocuapcionEditText.text.toString().toInt(),
                binding.balanceEditText.floatValue()
            ))
        }

        viewModel.guardado.observe(this) {
            if (it) {
                Snackbar.make(binding.balanceEditText, "Se guardo con exito!", Snackbar.LENGTH_LONG).show()
            }
        }
    }

    fun TextInputEditText.floatValue() = text.toString().toFloatOrNull() ?: 0.0f

}