package com.example.ichirakuramen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ichirakuramen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var isLinear = true
    private lateinit var view: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        view = binding.ramenListview
        setContentView(binding.root)
        chooseLayout()
    }
    private fun chooseLayout(){
        if(isLinear)
            view.layoutManager = LinearLayoutManager(this)
        else
            view.layoutManager = GridLayoutManager(this,2)
        view.adapter = RamenAdapter(isLinear,
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
    private fun setIcon(menuItem: MenuItem?){
        if(menuItem==null)
            return
        menuItem.icon = if(!isLinear) ContextCompat.getDrawable(this,R.drawable.ic_linear_layout)
            else ContextCompat.getDrawable(this,R.drawable.ic_grid_layout)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu,menu)
        val layoutBtn = menu?.findItem(R.id.switch_layout)
        setIcon(layoutBtn)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.switch_layout -> {
                isLinear = !isLinear
                chooseLayout()
                setIcon(item)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}