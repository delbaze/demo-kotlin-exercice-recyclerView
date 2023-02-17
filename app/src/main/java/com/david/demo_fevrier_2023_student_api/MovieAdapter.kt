package com.david.demo_fevrier_2023_student_api

import android.app.Activity
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.david.demo_fevrier_2023_student_api.databinding.ListItemMovieBinding
import com.david.demo_fevrier_2023_student_api.dataclasses.Movie
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.toDuration

//EXEMPLE AVEC LE DATA BINDER>
class MovieAdapter(var movieList: ArrayList<Movie>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    class ViewHolder(val binding: ListItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) //le databinder, va mapper les identifiants de notre view en valeur

    private fun applyColor(position: Int, holder: ViewHolder) {
        if (position % 2 === 1) {
            holder.binding.parentLayout.setBackgroundColor(Color.parseColor("#f7f5f5"))
        } else {
            holder.binding.parentLayout.setBackgroundColor(Color.parseColor("#ffffff"))
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val id = movieList[position].id
//        if (position % 2 === 1){
//            holder.binding.parentLayout.setBackgroundColor(Color.parseColor("#f7f5f5"))
//        }
        applyColor(position, holder)
        val duration: Int = movieList[position].duration
        val min = duration.toDuration(DurationUnit.MINUTES)
        val time = min.toComponents { _, hours, minutes, _, _ ->
            "${hours}h$minutes"
        }

        println("SELECTED ${movieList[position].selected}")

        println("TIME $time")
        holder.binding.title.text = movieList[position].title
        holder.binding.cb.isChecked = movieList[position].selected
        holder.binding.duration.text = time
            .toString()
        holder.binding.imageView.setImageResource(movieList[position].image)
        holder.binding.cb.setOnCheckedChangeListener { _, b ->
            println("!!!!!!!! $id -> $b")
        }

        holder.binding.parentLayout.setOnClickListener {
            val inversedValue = !movieList[position].selected
            holder.binding.cb.isChecked =  inversedValue
            movieList[position].selected = inversedValue

        }
        holder.binding.cb.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                holder.binding.parentLayout.setBackgroundColor(Color.parseColor("#e2e2e2"))
            } else {
                applyColor(position, holder)
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_movie,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}
