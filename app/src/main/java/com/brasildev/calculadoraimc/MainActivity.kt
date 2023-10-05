package com.brasildev.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.brasildev.calculadoraimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    lateinit var resultado: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener {
            val intent = Intent(this, Resultado::class.java)


            val salvaPeso = binding.editTextPeso.text.toString()
            val salvaAltura = binding.editTextAltura.text.toString()

            if (salvaPeso.isNotEmpty() || salvaAltura.isNotEmpty()){

                val peso = salvaPeso.toDouble()
                val altura = salvaAltura.toDouble()

                val imc = peso / (altura*altura)

                resultado = if(imc < 18.5){
                    "Baixo"
                }else if (imc >= 18.5 || imc <= 24.9){
                    "Normal"
                }else if (imc >= 25.0 || imc <= 29.9){
                    "Sobrepeso"
                }else{
                    "Obesidade"
                }

                intent.putExtra("peso", peso)
                intent.putExtra("altura", altura)
                intent.putExtra("resultado", resultado)

                startActivity(intent)
            }else{
                Toast.makeText(this, "Preencha os Campos!", Toast.LENGTH_LONG).show()
            }

        }
    }



}