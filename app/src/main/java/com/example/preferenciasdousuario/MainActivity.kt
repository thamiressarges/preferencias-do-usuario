package com.example.preferenciasdousuario

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.annotation.ContentView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.preferenciasdousuario.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var cor = ""

    companion object{
        const val ARQUIVO_PREFERENCIAS = "ArquivoPreferencias"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.cor1.setOnClickListener {
            cor = "#FF03DAC5"
            binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
            salvar(cor)
        }

        binding.cor2.setOnClickListener {
            cor = "#FFBB86FC"
            binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
            salvar(cor)
        }

        binding.cor3.setOnClickListener {
            cor = "#83A9F4"
            binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
            salvar(cor)
        }

        binding.cor4.setOnClickListener {
            cor = "#FF0000"
            binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
            salvar(cor)
        }
    }

    private fun salvar(cor: String){

        binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))

        binding.btnTrocarCor.setOnClickListener { view ->
            val preferencias = getSharedPreferences(ARQUIVO_PREFERENCIAS, MODE_PRIVATE)
            val editor = preferencias.edit()
            editor.putString("cor", cor)
            editor.apply()

            snackbar(view)
        }
    }

    private fun snackbar(view: View){
        val snackbar = Snackbar.make(view, "Cor alterada com sucesso", Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction("OK"){

        }
        snackbar.setActionTextColor(Color.BLUE)
        snackbar.setBackgroundTint(Color.WHITE)
        snackbar.setTextColor(Color.BLACK)
        snackbar.show()
    }

    override fun onResume() {
        super.onResume()

        val preferences = getSharedPreferences(ARQUIVO_PREFERENCIAS, MODE_PRIVATE)
        val cor = preferences.getString("cor", "")

        if(cor!!.isNotEmpty()){
            binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
        }
    }
}


