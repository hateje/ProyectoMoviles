package com.example.caso.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.caso.model.Propiedad
import com.example.caso.databinding.FragmentPropiedadFilaBinding
import com.example.caso.ui.home.HomeFragment
import com.example.caso.ui.home.HomeFragmentDirections

class PropiedadAdapter: RecyclerView.Adapter<PropiedadAdapter.PropiedadViewHolder>() {

    private var listaPropiedades = emptyList<Propiedad>()

    inner class PropiedadViewHolder( private val itemBinding: FragmentPropiedadFilaBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun dibujar(propiedad: Propiedad){
            itemBinding.tvNombre.text = propiedad.nombre
            itemBinding.tvDescripcion.text = propiedad.descripcion
            itemBinding.tvHabitaciones.text = propiedad.habitaciones.toString()
            itemBinding.tvPisos.text = propiedad.pisos.toString()
            itemBinding.tvBanos.text = propiedad.banos.toString()
            itemBinding.tvPrecio.text =  propiedad.precio.toString()
            itemBinding.tvNombreCorredor.text = propiedad.nombreCorredor
            itemBinding.tvTelefonoCorredor.text = propiedad.telefonoCorredor

            //Evento edit
            itemBinding.vistaFila.setOnClickListener{
               val accion = HomeFragmentDirections.actionNavHomeToUpdatePropiedad(propiedad)
                itemView.findNavController().navigate(accion)

            }
        }
    }

    //Función para llenar la lista
    fun setPropiedades(propiedades : List<Propiedad>){
        listaPropiedades = propiedades
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropiedadViewHolder {
        val itemBinding = FragmentPropiedadFilaBinding
            .inflate(
                LayoutInflater.from(parent.context)
                ,parent,false)

        return PropiedadViewHolder(itemBinding)

    }

    override fun onBindViewHolder(holder: PropiedadViewHolder, position: Int) {
        val propiedad = listaPropiedades[position]
        holder.dibujar(propiedad)
    }

    override fun getItemCount(): Int {
        return listaPropiedades.size
    }


}