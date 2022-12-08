package com.example.caso.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.caso.data.PropiedadDao
import com.example.caso.model.Propiedad
import com.example.caso.repository.PropiedadRepository

class HomeViewModel (application: Application): AndroidViewModel(application) {
    val getPropiedades:MutableLiveData<List<Propiedad>>
    private val repository: PropiedadRepository= PropiedadRepository(PropiedadDao())

    init {


        getPropiedades = repository.getPropiedad
    }

    fun savePropiedad(propiedad: Propiedad){
        repository.savePropiedead(propiedad)
    }

    fun deletePropiedad(propiedad: Propiedad){
        repository.deletePropiedad(propiedad)
    }


}