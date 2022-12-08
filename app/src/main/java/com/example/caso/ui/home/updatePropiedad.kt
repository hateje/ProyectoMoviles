package com.example.caso

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.caso.databinding.FragmentUpdatePropiedadBinding
import com.example.caso.model.Propiedad
import com.example.caso.viewmodel.HomeViewModel

class updatePropiedad : Fragment() {

    //Variable que nos va a recuperar argumentos
    private val args by navArgs<updatePropiedadArgs>()


    //objeto del xml
    private var _binding: FragmentUpdatePropiedadBinding? = null
    private val binding get() = _binding!!
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentUpdatePropiedadBinding.inflate(inflater,container,false)

        //Cargar los valores edit
        binding.etNombre.setText(args.propiedad.nombre)
        binding.etDescripcion.setText(args.propiedad.descripcion)
        binding.etHabitaciones.setText(args.propiedad.habitaciones.toString())
        binding.etPisos.setText(args.propiedad.pisos.toString())
        binding.etBanos.setText(args.propiedad.banos.toString())
        binding.etPrecio.setText(args.propiedad.precio.toString())
        binding.etNombreCorredor.setText(args.propiedad.nombreCorredor)
        binding.etTelefonoCorredor.setText(args.propiedad.telefonoCorredor)

        //Binding de los botones de actualizar y eliminar propiedad
        binding.btUpdatePropiedad.setOnClickListener{updatePropiedad()}
        binding.btDeletePropiedad.setOnClickListener { deletePropiedad() }

        // Inflate the layout for this fragment
        return binding.root
    }

    //Función para eliminar el lugar, tarea semana 10
    private fun deletePropiedad() {
        val nombre = binding.etNombre.text.toString()
        val descripcion = binding.etDescripcion.text.toString()
        val habitaciones = binding.etHabitaciones.text.toString().toInt()
        val pisos = binding.etPisos.text.toString().toInt()
        val banos = binding.etBanos.text.toString().toInt()
        val precio = binding.etPrecio.text.toString().toLong()
        val nombreCorredor = binding.etNombreCorredor.text.toString()
        val telefonoCorredor = binding.etTelefonoCorredor.text.toString()


        val propiedad = Propiedad(args.propiedad.id,nombre,descripcion,habitaciones,pisos,banos,precio,nombreCorredor,telefonoCorredor)
        homeViewModel.deletePropiedad(propiedad)
        Toast.makeText(requireContext(),getString(R.string.msg_ppropiedadBorrada), Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.action_updatePropiedad_to_nav_home)

    }

    private fun updatePropiedad() {
        val nombre = binding.etNombre.text.toString()
        val descripcion = binding.etDescripcion.text.toString()
        val habitaciones = binding.etHabitaciones.text.toString().toInt()
        val pisos = binding.etPisos.text.toString().toInt()
        val banos = binding.etBanos.text.toString().toInt()
        val precio = binding.etPrecio.text.toString().toLong()
        val nombreCorredor = binding.etNombreCorredor.text.toString()
        val telefonoCorredor = binding.etTelefonoCorredor.text.toString()

        if (nombre.isEmpty()){
            Toast.makeText(requireContext(),getString(R.string.msg_data), Toast.LENGTH_LONG).show()
        }
        else if (descripcion.isEmpty()){
            Toast.makeText(requireContext(),getString(R.string.msg_data), Toast.LENGTH_LONG).show()
        }
        else{
            val propiedad = Propiedad(args.propiedad.id,nombre,descripcion,habitaciones,pisos,banos,precio,nombreCorredor,telefonoCorredor)
            homeViewModel.savePropiedad(propiedad)
            Toast.makeText(requireContext(),getString(R.string.msg_lugar_updated), Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updatePropiedad_to_nav_home)
        }
    }


}