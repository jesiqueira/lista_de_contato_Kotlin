package com.edmar.listadecontato

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private  val rvList: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rv_List)
    }

    private  val  adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindViews()
        updateList()
    }

    private  fun bindViews(){
        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
    }

    private  fun updateList(){
        adapter.updateList(
            arrayListOf(
                Contact(
                    "Jose Edmar",
                    "(00) 99999-9999",
                    "img.png"
                ),
                Contact(
                    "Jose Edmar",
                    "(00) 99999-9999",
                    "img.png"
                )
            )
        )
    }
}