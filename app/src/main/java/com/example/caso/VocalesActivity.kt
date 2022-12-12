package com.example.caso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager

class VocalesActivity : AppCompatActivity() {
    // Se crean variables
    // viewpager adapter e image list.
    lateinit var viewPager: ViewPager
    lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var imageList: List<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vocales)

        // initializacion de variables

        viewPager = findViewById(R.id.idViewPager)

        // Se inicializa la lista de imagenes
        // y se les añade datos
        imageList = ArrayList<Int>()

        imageList = imageList + R.drawable.a
        imageList = imageList + R.drawable.e
        imageList = imageList + R.drawable.i
        imageList = imageList + R.drawable.o
        imageList = imageList + R.drawable.u


        // Inciailización de la vista
        // pager adapter y añadir la image list.
        viewPagerAdapter = ViewPagerAdapter(this@VocalesActivity, imageList)

        // seteo del adapter al viewpager
        viewPager.adapter = viewPagerAdapter
    }
}