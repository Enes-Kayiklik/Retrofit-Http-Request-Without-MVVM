package com.enes.retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.enes.retrofitalternative.R
import kotlinx.android.synthetic.main.one_row_dog_photo.view.*

class DogRecyclerViewAdapter(
    var photoList: List<String>
) : RecyclerView.Adapter<DogRecyclerViewAdapter.CustomViewHolder>() {
    override fun getItemCount(): Int {
        //Adapter oluştururken parametre olarak gelen itemList'in size verisini dönderir.
        //Bu değer Recycler View'ın child sayısıdır.
        //Gördüğünüz verilerde eksiklik varsa bakılması gereken ilk yer burasıdır.
        return photoList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        //Recycler View Item'ı için oluşturduğumuz Custom XML dosyasını inflate ediyoruz.
        return CustomViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.one_row_dog_photo, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        //Her Recycler View Item'ı farklı içerik barındıracağı için o anki (position)
        //item'ın verisini ayarlıyoruz.
        holder.itemView.apply {
            Glide.with(this)
                .load(photoList[position])
                .centerCrop()
                .into(imgDogPhoto)
        }
    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}