package com.david.demo_fevrier_2023_student_api

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.checkbox.MaterialCheckBox
import com.david.demo_fevrier_2023_student_api.databinding.ListItem2Binding

//EXEMPLE AVEC LE DATA BINDER>
class CategoryAdapter(val categoryList: ArrayList<Category>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    class ViewHolder(val binding: ListItem2Binding) : RecyclerView.ViewHolder(binding.root) //le databinder, va mapper les identifiants de notre view en valeur

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val id = categoryList[position].id
        holder.binding.name.text = categoryList[position].name
        holder.binding.cb.isChecked = categoryList[position].selected
        holder.binding.cb.setOnCheckedChangeListener{ compoundButton, b ->
            println("!!!!!!!! $id -> $b")

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_2,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
}

//EXEMPLE SANS LE DATA BINDER>
//class CategoryAdapter(val categoryList: ArrayList<Category>) :
//    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
//
//    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
//        val name = itemView.findViewById<TextView>(R.id.name)
//        val cb = itemView.findViewById<MaterialCheckBox>(R.id.cb)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val id = categoryList[position].id
//        holder.name.text = categoryList[position].name
//        holder.cb.isChecked = categoryList[position].selected
//        holder.cb.setOnCheckedChangeListener{ compoundButton, b ->
//            println("!!!!!!!! $id -> $b")
//
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_2, parent, false)
//        return ViewHolder(
//            view
//        )
//    }
//
//    override fun getItemCount(): Int {
//      return categoryList.size
//    }
//}