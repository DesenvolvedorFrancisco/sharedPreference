package dev.francisco.sharedpreferences

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.francisco.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recebe o novo valor inserido
        val sharedPreferences = this.getSharedPreferences("valores", Context.MODE_PRIVATE)
        val valor = sharedPreferences.getString("valor", "")

        binding.textValor.setText(valor)


        binding.buttonGravar.setOnClickListener {
            val novoValor = binding.editValor.text.toString()
            binding.textValor.setText(novoValor)

            //Armazena o novo valor

            val editor = sharedPreferences.edit()
            editor.putString("valor" , novoValor)

            // efectiva as alterações
            editor.apply()
        }
    }
}