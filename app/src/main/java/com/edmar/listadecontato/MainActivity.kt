package com.edmar.listadecontato

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
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
        //Criar Toast para teste de menu selecionado
    private fun showToast(messagem: String){
        Toast.makeText(this, messagem, Toast.LENGTH_SHORT).show()
    }

        //Criar menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // inflar o menu criado
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    //Verificar qual menu está selecionado se não tiver menu selecionar execute o default
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.item_menu_1 -> {
                showToast("Exibindo item de Menu 1")
                return  true
            }
            R.id.item_menu_2 -> {
                showToast("Exibindo item de menu 2")
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}