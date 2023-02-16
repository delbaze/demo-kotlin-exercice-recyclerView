package com.david.demo_fevrier_2023_student_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_main_recycler)
        //RECYCLER VIEW

        val recyclerList: RecyclerView = findViewById(R.id.recyclerList)

        recyclerList.layoutManager = LinearLayoutManager(this)
        recyclerList.adapter = CategoryAdapter(generateCategoryList())

        //LIST VIEW =>

//        var data = arrayOf("Toto", "Tata", "Titi", "Tutu") //tableau statique de données
//        var adapter = ArrayAdapter(
//            this,
//            R.layout.list_item,
//            data
//        ) //on génère un adaptateur qui va avoir besoin de 3 paramètres : Le contexte, l'élément qui devra être rendu pour chaque tour de boucle du tableau, et les données sur lesquelles il devra boucler
//        var listView: ListView = findViewById(R.id.my_list_view)  //le selecteur de ma ListView
//
//        listView.adapter = adapter
//
//        listView.onItemClickListener =
//            AdapterView.OnItemClickListener { parent, view, position, id ->
//                val itemValue = listView.getItemAtPosition(position) as String
//                Toast.makeText(
//                    applicationContext,
//                    "Position: $position\nValeur de l'élément: $itemValue",
//                    Toast.LENGTH_LONG
//                ).show()
//            }
//

    }

    private fun generateCategoryList(): ArrayList<Category> {
        val cat1 = Category("1", "Javascript", selected = false)
        val cat2 = Category("2", "Java", selected = false)
        val cat3 = Category("3", "Kotlin", selected = false)
        val cat4 = Category("4", "Typescript", selected = false)
        val cat5 = Category("5", "PHP", selected = false)

        val categoryList : ArrayList<Category> = ArrayList()

        categoryList.add(cat1)
        categoryList.add(cat2)
        categoryList.add(cat3)
        categoryList.add(cat4)
        categoryList.add(cat5)


    return categoryList
    }
}