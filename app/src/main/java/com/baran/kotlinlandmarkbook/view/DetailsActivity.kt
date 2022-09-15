package com.baran.kotlinlandmarkbook.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.baran.kotlinlandmarkbook.Singleton
import com.baran.kotlinlandmarkbook.model.LandMark
import com.baran.kotlinlandmarkbook.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater) //ne zamanki xml ile kod bağlantısı kullanacaksak layoutInflater devreye girer
        val view = binding.root
        setContentView(view)

        val intent = intent
        //casting
        //val selectedLandMark = intent.getSerializableExtra("landMark") as LandMark

        val selectedLandMark = Singleton.chosenLandMark

        selectedLandMark?.let {

            binding.nameText.text = it.name
            binding.countryText.text = it.country
            binding.imageView.setImageResource(it.image)
        }
    }
}