package com.example.idbmapi.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.idbmapi.MainActivity
import com.example.idbmapi.R
import com.example.idbmapi.Retrofit.DItem
import com.example.idbmapi.Retrofit.Modeldata
import com.google.android.material.bottomsheet.BottomSheetDialog

class MovieAdapter(val mainActivity: MainActivity, var list: ArrayList<DItem>) : RecyclerView.Adapter<MovieAdapter.ViewData>() {

    class ViewData(itemView: View) :ViewHolder(itemView){

       var image =itemView.findViewById<ImageView>(R.id.imgmovie)
       var name =itemView.findViewById<TextView>(R.id.moviename)
       var category =itemView.findViewById<TextView>(R.id.category)
       var year =itemView.findViewById<TextView>(R.id.year)
       var card =itemView.findViewById<CardView>(R.id.cardview)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {

        var view = LayoutInflater.from(mainActivity).inflate(R.layout.movie_view,parent,false)
        return ViewData(view)
    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {
        holder.name.setText(list[position].l).toString()
        holder.category.setText(list[position].q).toString()
        holder.year.setText(list[position].y).toString()
        Glide.with(mainActivity).load(list[position].i?.imageUrl).placeholder(R.drawable.movie).into(holder.image)

        holder.card.setOnClickListener {
            var dialog = BottomSheetDialog(mainActivity)
            dialog.setContentView(R.layout.movie_dialog)
            var image = dialog.findViewById<ImageView>(R.id.imgmovie)
            var name = dialog.findViewById<TextView>(R.id.moviename)
            var category = dialog.findViewById<TextView>(R.id.category)
            var year = dialog.findViewById<TextView>(R.id.year)

            name?.setText(list[position].l).toString()
            category?.setText(list[position].q).toString()
            year?.setText(list[position].y).toString()
            Glide.with(mainActivity).load(list[position].i?.imageUrl).placeholder(R.drawable.movie).into(image!!)

            dialog.show()
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
    fun UpdateData(l3: ArrayList<DItem>) {
        list = l3
        notifyDataSetChanged()
    }
}