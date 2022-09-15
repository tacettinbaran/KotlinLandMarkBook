package com.baran.kotlinlandmarkbook.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.baran.kotlinlandmarkbook.Singleton
import com.baran.kotlinlandmarkbook.databinding.RecyclerRowBinding
import com.baran.kotlinlandmarkbook.model.LandMark
import com.baran.kotlinlandmarkbook.view.DetailsActivity

class LandMarkAdapter(val landMarkList: ArrayList<LandMark>) : RecyclerView.Adapter<LandMarkAdapter.LandMarkHolder>() {


    class LandMarkHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    //ilk bağladığında ne olacak
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandMarkHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LandMarkHolder(binding)
    }

    // bağladıktan sonra ne olacak
    override fun onBindViewHolder(holder: LandMarkHolder, position: Int) {
        holder.binding.rowNameText.text = landMarkList.get(position).name

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailsActivity::class.java)
            //intent.putExtra("landMark",  landMarkList.get(position))
            Singleton.chosenLandMark = landMarkList.get(position)
            holder.itemView.context.startActivity(intent)
        }
    }


    // kaç tane eleman dönecek
    override fun getItemCount(): Int {
        return landMarkList.size
    }

}