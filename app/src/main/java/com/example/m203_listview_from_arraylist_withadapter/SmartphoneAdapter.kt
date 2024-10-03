package com.example.m203_listview_from_arraylist_withadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class SmartphoneAdapter(context: Context, private val smartphones: ArrayList<Smartphone>) : ArrayAdapter<Smartphone>(context, 0, smartphones) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

       val listItemView = LayoutInflater.from(context).inflate(R.layout.item, parent, false)


        // Récupération du smartphone actuel à la position donnée
        val currentSmartphone = smartphones[position]

        // Mise à jour de l'image du smartphone
        val imageView = listItemView!!.findViewById<ImageView>(R.id.smartphone_image)
        Glide.with(context)
            .load(currentSmartphone.image)  // Chargement de l'image à partir de l'URL
            .into(imageView)

        // Mise à jour du nom du smartphone
        val textView = listItemView.findViewById<TextView>(R.id.smartphone_nom)
        textView.text = currentSmartphone.nom

        return listItemView
    }
}