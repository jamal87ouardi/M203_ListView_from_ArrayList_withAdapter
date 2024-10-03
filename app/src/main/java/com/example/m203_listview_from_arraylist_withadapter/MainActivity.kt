package com.example.m203_listview_from_arraylist_withadapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

data class Smartphone (
    val id : Int,
    val nom : String,
    val prix : Double,
    val image : String
)






class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var LS = ArrayList<Smartphone>()
        val s1 = Smartphone(1,"Samsung A15", 3400.0, "https://tabtel.ma/14097-large_default/samsung-galaxy-a15-4g-8go-256go-dual-sim.jpg")
        val s2 = Smartphone(2,"iphone 15 pro", 6400.0, "https://uno.ma/pub/media/catalog/product/cache/af8d7fd2c4634f9c922fba76a4a30c04/l/d/ld0005977505_2.jpeg")

        LS.add(s1)
        LS.add(s2)



        val lv = findViewById<ListView>(R.id.lv)

        val adapter = SmartphoneAdapter(this, LS)
        lv.adapter = adapter

        lv.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            val imgView = findViewById<ImageView>(R.id.imageView)
            Glide.with(applicationContext)
                .load(LS[position].image)
                .into(imgView)

            val txtV_nom = findViewById<TextView>(R.id.textView3)
            txtV_nom.text = LS[position].nom

            val txtV_prix = findViewById<TextView>(R.id.textView4)
            txtV_prix.text = LS[position].prix.toString()+" MAD"


        }
    }
}