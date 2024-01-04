package com.example.testgamelaco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class CountryDescriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_description)

        if(intent != null) {
            findViewById<ImageView>(R.id.image_description).setImageResource(intent.getIntExtra("countryImage",1))
            findViewById<TextView>(R.id.name_description).text = intent.getStringExtra("countryName")
        }
    }
}