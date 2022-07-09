package com.example.ichirakuramen

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import com.example.ichirakuramen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ramenListview.adapter = RamenAdapter(
            listOf(
                Ramen(R.drawable.beef_miso,"Beef Miso","$ 85.00"),
                Ramen(R.drawable.korean,"Korean","$ 64.25"),
                Ramen(R.drawable.chashu,"Chashu","$ 60.00"),
                Ramen(R.drawable.creamy_miso,"Creamy Miso","$ 70.50"),
                Ramen(R.drawable.shoyu,"Shoyu","$ 43.00"),
                Ramen(R.drawable.spicy_veg,"Spicy Veg","$ 40.75"),
                Ramen(R.drawable.kimchi,"Kimchi","$ 57.00"),
                Ramen(R.drawable.tonkotsu,"Tonkotsu","$ 52.30")
            )
        )
    }
}