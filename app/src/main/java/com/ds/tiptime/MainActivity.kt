package com.ds.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ds.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val button = binding.calcular
        button.setOnClickListener { calculateTip() }


    }
    fun calculateTip() {
        val stringInTextField = binding.tamanhoGorjeta.text.toString()
        val cost = stringInTextField.toDouble()
        val selectId = binding.opcoesGorjeta.checkedRadioButtonId
        val tipPercentage = when(selectId) {
            R.id.opcao_vinte -> 0.20
            R.id.opcao_dezoito -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * cost
        val roundUp = binding.arredondar.isChecked
        if(roundUp) {
            tip = kotlin.math.ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.resultado.text = formattedTip
    }
}