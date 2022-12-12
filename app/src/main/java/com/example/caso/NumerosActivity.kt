package com.example.caso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager

class NumerosActivity : AppCompatActivity() {
    // Se crean variables
    // viewpager adapter e image list.
    lateinit var viewPager: ViewPager
    lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var imageList: List<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numeros)

        // initializacion de variables

        viewPager = findViewById(R.id.idViewPager)

        // Se inicializa la lista de imagenes
        // y se les añade datos
        imageList = ArrayList<Int>()

        imageList = imageList + R.drawable.uno
        imageList = imageList + R.drawable.dos
        imageList = imageList + R.drawable.tres
        imageList = imageList + R.drawable.cuatro
        imageList = imageList + R.drawable.cinco
        imageList = imageList + R.drawable.seis
        imageList = imageList + R.drawable.siete
        imageList = imageList + R.drawable.ocho
        imageList = imageList + R.drawable.nueve
        imageList = imageList + R.drawable.diez

        // Inciailización de la vista
        // pager adapter y añadir la image list.
        viewPagerAdapter = ViewPagerAdapter(this@NumerosActivity, imageList)

        // seteo del adapter al viewpager
        viewPager.adapter = viewPagerAdapter
    }
}