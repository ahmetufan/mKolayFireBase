package com.ahmet.mkolay.adaptery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahmet.mkolay.databinding.RowSepetBinding
import com.ahmet.mkolay.models.ServiceModel
import com.ahmet.mkolay.utils.downloadFromUrl
import com.ahmet.mkolay.utils.placeHolderProgressBar
import com.ahmet.mkolay.viewmodel.SepetViewModel
import com.bumptech.glide.Glide


class Adaptery(val arraList: ArrayList<ServiceModel>) : RecyclerView.Adapter<Adaptery.Holder>() {

    class Holder(val binding: RowSepetBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adaptery.Holder {
        val binding = RowSepetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Adaptery.Holder, position: Int) {

        holder.binding.rowName.text = arraList[position].name
        holder.binding.rowGram.text = arraList[position].gram
        holder.binding.rowFiyat.text = arraList[position].fiyat
        holder.binding.rowAdet.text = arraList[position].adet


        holder.binding.rowImage.downloadFromUrl(arraList[position].image,
        placeHolderProgressBar(holder.itemView.context))

    }

    override fun getItemCount(): Int {

        return arraList.size
    }

    fun updateSepetList(newSepetList: List<ServiceModel>) {

        arraList.clear()
        arraList.addAll(newSepetList)
        notifyDataSetChanged()
    }
}