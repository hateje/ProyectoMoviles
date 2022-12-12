package com.example.caso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager

class FigurasActivity : AppCompatActivity() {
    // Se crean variables
    // viewpager adapter e image list.
    lateinit var viewPager: ViewPager
    lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var imageList: List<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_figuras)

        // initializacion de variables

        viewPager = findViewById(R.id.idViewPager)

        // Se inicializa la lista de imagenes
        // y se les añade datos
        imageList = ArrayList<Int>()

        imageList = imageList + R.drawable.circulo
        imageList = imageList + R.drawable.cuadrado
        imageList = imageList + R.drawable.estrella
        imageList = imageList + R.drawable.rombo
        imageList = imageList + R.drawable.triangulo

        // Inciailización de la vista
        // pager adapter y añadir la image list.
        viewPagerAdapter = ViewPagerAdapter(this@FigurasActivity, imageList)

        // seteo del adapter al viewpager
        viewPager.adapter = viewPagerAdapter
    }
}