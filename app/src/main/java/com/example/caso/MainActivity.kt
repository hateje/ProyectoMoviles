package com.example.caso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.caso.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    //Objeto firebase
    private lateinit var auth: FirebaseAuth

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inicializar el binding
        binding= ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //Inicializar el firebase
        FirebaseApp.initializeApp(this)
        auth = Firebase.auth

        binding.btLogin.setOnClickListener { haceLogin() }
        binding.btRegister.setOnClickListener { haceRegistro() }
    }

    private fun haceRegistro() {
        val correo = binding.etCorreo.text.toString()
        val clave = binding.etClave.text.toString()

        auth.createUserWithEmailAndPassword(correo,clave)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) { //Si se hizo el registro
                    val user = auth.currentUser
                    refresca(user)
                } else {  //Si no se hizo el registro...
                    Toast.makeText(baseContext,getString(R.string.msg_fallo), Toast.LENGTH_LONG).show()
                    refresca(null)
                }
            }
    }

    private fun refresca(user: FirebaseUser?) {
        if (user!=null) {
            //ME paso a la pantalal principal...
            val intent= Intent(this,MenuActivity::class.java)
            startActivity(intent)
        }
    }

    private fun haceLogin() {
        val correo = binding.etCorreo.text.toString()
        val clave = binding.etClave.text.toString()

        auth.signInWithEmailAndPassword(correo,clave)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) { //Si se hizo el registro
                    val user = auth.currentUser
                    refresca(user)
                } else {  //Si no se hizo el registro...
                    Toast.makeText(baseContext,getString(R.string.msg_fallo), Toast.LENGTH_LONG).show()
                    refresca(null)
                }
            }
    }

    override fun onStart() {
        super.onStart()
        val usuario = auth.currentUser
        refresca(usuario)
    }
}