package com.example.caso.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.caso.model.Propiedad
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.ktx.Firebase

class PropiedadDao {

    //Firebase var
    private var codigoUsuario: String
    private var firestore: FirebaseFirestore

    init{
        val usuario = Firebase.auth.currentUser?.email
        codigoUsuario = "$usuario"
        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }

    //Insert
    fun savePropiedad(propiedad: Propiedad){
        val document: DocumentReference
        if (propiedad.id.isEmpty()){
            //Proceso de agregar
            document = firestore.
            collection("propiedades").
            document(codigoUsuario).
            collection("misPropiedades").
            document()
            propiedad.id= document.id
        }
        else{
            //modificar lugar
            document = firestore.
            collection("propiedades").
            document(codigoUsuario).
            collection("misPropiedades").
            document(propiedad.id)
        }
        document.set(propiedad) //el método set es el que hace el update o insert
            .addOnCompleteListener{
                Log.d("SaveLugar","Guardado con éxito")
            }
            .addOnCanceledListener {
                Log.e("SaveLugar","Error al guardar")
            }
    }

    //Delete

    fun deletePropiedad(propiedad: Propiedad){
        if (propiedad.id.isNotEmpty()){
            firestore.
            collection("propiedades").
            document(codigoUsuario).
            collection("misPropiedades").
            document(propiedad.id).delete().
            addOnCompleteListener{
                Log.d("deletePropiedad","Eliminado con éxito")
            }
                .addOnCanceledListener {
                    Log.e("deletePropiedad","Error al eliminar")
                }
        }
    }

    //Obtener datos

    fun obtenerPropiedades(): MutableLiveData<List<Propiedad>> {
        val listaPropiedades = MutableLiveData<List<Propiedad>>()
        firestore.
        collection("propiedades").
        document(codigoUsuario).
        collection("misPropiedades").
        addSnapshotListener{snapshot,e ->
            if(e != null){
                return@addSnapshotListener
            }
            if (snapshot !=null){
                val lista = ArrayList<Propiedad>()
                val propiedades = snapshot.documents
                propiedades.forEach{
                    val propiedad = it.toObject(Propiedad::class.java)
                    if (propiedad != null){
                        lista.add(propiedad)
                    }
                }
                listaPropiedades.value= lista
            }
        }
        return listaPropiedades
    }
}