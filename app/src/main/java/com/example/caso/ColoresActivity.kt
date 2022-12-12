package com.example.caso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager

class ColoresActivity : AppCompatActivity() {
    // Se crean variables
    // viewpager adapter e image list.
    lateinit var viewPager: ViewPager
    lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var imageList: List<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colores)

        // initializacion de variables

        viewPager = findViewById(R.id.idViewPager)

        // Se inicializa la lista de imagenes
        // y se les añade datos
        imageList = ArrayList<Int>()

        imageList = imageList + R.drawable.azul
        imageList = imageList + R.drawable.morado
        imageList = imageList + R.drawable.naranja
        imageList = imageList + R.drawable.rojo
        imageList = imageList + R.drawable.verde
        imageList = imageList + R.drawable.amarillo
        imageList = imageList + R.drawable.celeste
        imageList = imageList + R.drawable.blanco
        imageList = imageList + R.drawable.negro

        // Inciailización de la vista
        // pager adapter y añadir la image list.
        viewPagerAdapter = ViewPagerAdapter(this@ColoresActivity, imageList)

        // seteo del adapter al viewpager
        viewPager.adapter = viewPagerAdapter

    }
}