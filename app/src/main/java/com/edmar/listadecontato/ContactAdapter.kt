package com.edmar.listadecontato

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter (var listener: ClickItemContactListener): RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>(){

    private val list: MutableList<Contact> = mutableListOf()

//    Cria cada item visual da tela
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false) //responsável por carregar o layout
        return  ContactAdapterViewHolder(view, list, listener)
    }

//    Popular item na lista
    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

//    criar metodo puplico para chamar adapter
    fun updateList(list: List<Contact>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged() // notifica o adapter que tem modificação
    }

//    Gerencia toda lista
    class ContactAdapterViewHolder(itemView: View, var list: List<Contact>, var listener: ClickItemContactListener) : RecyclerView.ViewHolder(itemView){
        private val tvName: TextView = itemView.findViewById(R.id.tv_name)
        private val tvPhone: TextView = itemView.findViewById(R.id.tv_phone)
        private val ivPhotograph: ImageView = itemView.findViewById(R.id.iv_photograph)

        init {
            itemView.setOnClickListener {
                listener.clickItemContact(list[adapterPosition])
            }
        }

        fun bind(contact: Contact){
            tvName.text = contact.name
            tvPhone.text = contact.phone
        }
    }
}