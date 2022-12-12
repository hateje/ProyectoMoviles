package com.example.caso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.Toast
import com.example.caso.databinding.ActivityMenuBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inicializar el binding
        binding= ActivityMenuBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val btColores = findViewById<ImageButton>(R.id.bt_colores)
        val btFiguras = findViewById<ImageButton>(R.id.bt_figuras)
        val btNumeros = findViewById<ImageButton>(R.id.bt_numeros)
        val btVocales = findViewById<ImageButton>(R.id.bt_vocales)
        val btlogout = findViewById<ImageButton>(R.id.btlogout)


        btColores.setOnClickListener{refrescaColores()}
        btFiguras.setOnClickListener{refrescaFiguras()}
        btNumeros.setOnClickListener{refrescaNumeros()}
        btVocales.setOnClickListener{refrescaVocales()}
        btlogout.setOnClickListener{cerrarSesion()}
        //binding.btFiguras.setOnClickListener { refrescaFiguras() }
        //binding.btColores.setOnClickListener { refrescaColores() }

    }



    private fun refrescaColores() {
        val intent= Intent(this,ColoresActivity::class.java)
        startActivity(intent)
    }

    private fun refrescaFiguras() {

        val intent= Intent(this,FigurasActivity::class.java)
        startActivity(intent)
    }

    private fun refrescaNumeros() {

        val intent= Intent(this,NumerosActivity::class.java)
        startActivity(intent)
    }

    private fun refrescaVocales() {

        val intent= Intent(this,VocalesActivity::class.java)
        startActivity(intent)
    }

    private fun cerrarSesion() {
        FirebaseAuth.getInstance().signOut()
        finish()
    }



}


