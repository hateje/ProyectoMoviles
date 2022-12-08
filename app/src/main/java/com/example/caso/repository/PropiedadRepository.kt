package com.example.caso.repository

import androidx.lifecycle.MutableLiveData
import com.example.caso.data.PropiedadDao
import com.example.caso.model.Propiedad

class PropiedadRepository(private val propiedadDao: PropiedadDao) {

    fun savePropiedead(propiedad: Propiedad){
        propiedadDao.savePropiedad(propiedad)
    }

    fun deletePropiedad(propiedad: Propiedad){
        propiedadDao.deletePropiedad(propiedad)
    }

    val getPropiedad: MutableLiveData<List<Propiedad>> = propiedadDao.obtenerPropiedades()
}