package com.edmar.listadecontato

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ClickItemContactListener {

    private  val rvList: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rv_List)
    }

    private  val  adapter = ContactAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_menu)

        initDrawer()
        bindViews()
        updateList()
    }

    private fun initDrawer(){
        val drawerLayout = findViewById<View>(R.id.drawer_Layout) as DrawerLayout
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.closer_drawer)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
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

    override fun clickItemContact(contact: Contact) {
        val intent = Intent(this, ContactDetail::class.java)
        startActivity(intent)
    }
}