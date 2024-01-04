package com.example.testgamelaco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val countryInfos = arrayListOf<CountryInfo>(
        CountryInfo("America",11.2,R.drawable.dice_1,"ahihi1"),
        CountryInfo("Vietname",22.2,R.drawable.dice_2,"ahihi2"),
        CountryInfo("Canada",33.3,R.drawable.dice_3,"ahihi3"),
        CountryInfo("AoMaCanada",44.3,R.drawable.dice_4,"ahihi4"),
        CountryInfo("Russia",55.3,R.drawable.dice_5,"ahihi5")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val countryRV = findViewById<RecyclerView>(R.id.recycle_container)
        val countryAdapter = CountryAdapter(this, countryInfos)
        countryRV.layoutManager = GridLayoutManager(this,2)
        countryRV.adapter = countryAdapter

        countryAdapter.onItemClick = { countryInfo ->
            var intent = Intent(this,CountryDescriptionActivity::class.java)
            intent.putExtra("countryImage",countryInfo.imageResourceID)
            intent.putExtra("countryName",countryInfo.name)

            startActivity(intent)
        }
    }
}