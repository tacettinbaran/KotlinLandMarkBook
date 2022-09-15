package com.baran.kotlinlandmarkbook.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.baran.kotlinlandmarkbook.model.LandMark
import com.baran.kotlinlandmarkbook.R
import com.baran.kotlinlandmarkbook.adapter.LandMarkAdapter
import com.baran.kotlinlandmarkbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var landMarkList: ArrayList<LandMark>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) //ne zamanki xml ile kod bağlantısı kullanacaksak layoutInflater devreye girer
        val view = binding.root
        setContentView(view)

        landMarkList = ArrayList()

        //datalarımızı oluşrturuyoruz

        val pisa = LandMark("Pizza Kulesi", "Italya", R.drawable.pizzakulesi)
        val kolezyum = LandMark("Kolezyum", "Italya", R.drawable.kolezyum)
        val eyfel = LandMark("Eyfel", "Fransa", R.drawable.eyfel)
        val londraKoprusu = LandMark("Londra Koprusu", "Ingiltere", R.drawable.londrakoprusu)

        landMarkList.add(pisa)
        landMarkList.add(kolezyum)
        landMarkList.add(eyfel)
        landMarkList.add(londraKoprusu)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val landMarkAdapter = LandMarkAdapter(landMarkList)
        binding.recyclerView.adapter = landMarkAdapter


        /*
        //listView verimli değil.
        //Adapter : Layout & Data
        //Mapping
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, landMarkList.map {
            landMark -> landMark.name
        })
        binding.listView.adapter = adapter
        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
           val intent = Intent(MainActivity@this, DetailsActivity::class.java)
            //String, int gondermede sıkıntı yok ama oluşturduğumuz objeyi göndermek sıkıntı
            intent.putExtra("landMark",  landMarkList.get(position))
            startActivity(intent)
        }
         */


    }
}