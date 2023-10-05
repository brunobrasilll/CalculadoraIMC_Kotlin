package com.brasildev.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brasildev.calculadoraimc.databinding.ActivityResultadoBinding

class Resultado : AppCompatActivity() {

    private val binding by lazy {
        ActivityResultadoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val bundle = intent.extras

        val peso = bundle?.getDouble("peso")
        val altura = bundle?.getDouble("altura")
        val resultado = bundle?.getString("resultado")

        binding.textViewPeso.text = "Peso informado: $peso Kgs"
        binding.textViewAltura.text = "Altura informado: $altura m"
        binding.textViewResultado.text = "$resultado"

    }
}