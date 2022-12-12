package com.example.caso

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.viewpager.widget.PagerAdapter
import java.util.*

class ViewPagerAdapter(val context: Context, val imageList: List<Int>) : PagerAdapter() {
    //Método para retornar el tamaño de la lista
    override fun getCount(): Int {
        return imageList.size
    }

    // return del objeto
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as RelativeLayout
    }

    // inciailización e inflado del layout
    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        // inicializando el layout inflater.
        val mLayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        // inflado del layout
        val itemView: View = mLayoutInflater.inflate(R.layout.image_slider_item, container, false)

        // inicializando el image view con el id.
        val imageView: ImageView = itemView.findViewById<View>(R.id.idIVImage) as ImageView

        // seteo del image resource para el image view.
        imageView.setImageResource(imageList.get(position))

        // se añade el item view al contenedor
        Objects.requireNonNull(container).addView(itemView)

        // return del item view.
        return itemView
    }

    // método destroy item
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        // removiendo vista
        container.removeView(`object` as RelativeLayout)
    }
}