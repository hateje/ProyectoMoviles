package com.example.caso.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.caso.R
import com.example.caso.databinding.FragmentAgregarPropiedadBinding
import com.example.caso.model.Propiedad
import com.example.caso.viewmodel.HomeViewModel


class agregarPropiedad : Fragment() {

    private var _binding: FragmentAgregarPropiedadBinding?= null
    private val binding get()= _binding!!
    private lateinit var propiedadViewModel: HomeViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        propiedadViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentAgregarPropiedadBinding.inflate(inflater,container,false)
        binding.btAgregarPropiedad.setOnClickListener{agregarPropiedad()}



        // Inflate the layout for this fragment
        return binding.root
    }

    private fun agregarPropiedad() {
        val nombre = binding.etNombre.text.toString()
        val descripcion = binding.etDescripcion.text.toString()
        val habitaciones = binding.etHabitaciones.text.toString().toInt()
        val pisos = binding.etPisos.text.toString().toInt()
        val banos = binding.etBanos.text.toString().toInt()
        val precio = binding.etPrecio.text.toString().toLong()
        val nombreCorredor = binding.etNombreCorredor.text.toString()
        val telefonoCorredor = binding.etTelefonoCorredor.text.toString()


        if (nombre.isNotEmpty()){
            val propiedad = Propiedad("",nombre,descripcion,habitaciones,pisos,banos,precio,nombreCorredor,telefonoCorredor)
            //Proceso de agregar BD
            propiedadViewModel.savePropiedad(propiedad)
            Toast.makeText(requireContext(),getString(R.string.msg_exitoPropiedad), Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(requireContext(),getString(R.string.msg_error), Toast.LENGTH_LONG).show()
        }
    }


}