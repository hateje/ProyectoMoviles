package com.example.caso.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.caso.R
import com.example.caso.adapter.PropiedadAdapter
import com.example.caso.databinding.FragmentHomeBinding
import com.example.caso.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    //ViewModel
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.addLugarFabBt.setOnClickListener{
            findNavController().navigate(R.id.action_nav_home_to_agregarPropiedad)
        }

        //Cargar datos
        val propiedadAdapter = PropiedadAdapter()
        val reciclador = binding.reciclador
        reciclador.adapter = propiedadAdapter
        reciclador.layoutManager = LinearLayoutManager(requireContext())

        homeViewModel.getPropiedades.observe(viewLifecycleOwner){
                propiedades -> propiedadAdapter.setPropiedades(propiedades)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}