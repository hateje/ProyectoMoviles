package com.example.caso

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity2 : AppCompatActivity() {


    // Se crean variables
    // viewpager adapter e image list.
    lateinit var viewPager: ViewPager
    lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var imageList: List<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // initializacion de variables

        viewPager = findViewById(R.id.idViewPager)

        // Se inicializa la lista de imagenes
        // y se les añade datos
        imageList = ArrayList<Int>()

        imageList = imageList + R.drawable.atardecer
        imageList = imageList + R.drawable.chico
        imageList = imageList + R.drawable.hollow
        imageList = imageList + R.drawable.motociclista

        // Inciailización de la vista
        // pager adapter y añadir la image list.
        viewPagerAdapter = ViewPagerAdapter(this@MainActivity2, imageList)

        // seteo del adapter al viewpager
        viewPager.adapter = viewPagerAdapter
    }
}