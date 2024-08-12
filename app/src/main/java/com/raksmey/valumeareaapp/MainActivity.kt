package com.raksmey.valumeareaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView

class MainActivity : AppCompatActivity() {
    // 1 - AdapterView : GridView
    private lateinit var gridView: GridView

    // 2 - Datasource
    private lateinit var shapeArrayList: ArrayList<Shape>

    // 3 - Adapter

    private lateinit var myCustomAdapter: MyCustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        gridView = findViewById(R.id.id_grid_view)

        shapeArrayList = arrayListOf(
            Shape(R.drawable.shape1, "Rectangle"),
            Shape(R.drawable.shape2, "Square"),
            Shape(R.drawable.shape3, "Triangle"),
            Shape(R.drawable.shape4, "Circle")
        )

        myCustomAdapter = MyCustomAdapter(shapeArrayList, applicationContext)

        gridView.adapter = myCustomAdapter

    }
}