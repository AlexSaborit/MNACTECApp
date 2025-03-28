package com.example.mnactecapp

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.io.File

class ElementAdapter(val elements: List<Element>, val onItemClick: (Element) -> Unit) :
    RecyclerView.Adapter<ElementAdapter.ElementViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.element_itema4, parent, false)
        return ElementViewHolder(view)
    }

    override fun onBindViewHolder(holder: ElementViewHolder, position: Int) {
        val element = elements[position]
        holder.bindElement(element)

        // Configurar el clic del elemento
        holder.itemView.setOnClickListener {
            onItemClick(element)
        }
    }

    override fun getItemCount(): Int = elements.size

    class ElementViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindElement(element: Element) {
            val imgVwElement = itemView.findViewById<ImageView>(R.id.ImgListElement)
            val imgElementPath = itemView.context.getFilesDir().toString() + "/imgelements/" + element.image
            //val bitmap = BitmapFactory.decodeFile(imgElementPath)
            //val bitmap = BitmapFactory.decodeResource(itemView.resources, R.drawable.defaultelement)

            val bitmap = if (File(imgElementPath).exists()) {
                BitmapFactory.decodeFile(imgElementPath)
            } else {
                BitmapFactory.decodeResource(itemView.resources, R.drawable.defaultelement)
            }
            imgVwElement.setImageBitmap(bitmap)


            val elementNom = itemView.findViewById<TextView>(R.id.NomListElement)
            elementNom.text = element.nameElement
        }
    }
}

/*codi branch main 30/11/2023

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ElementAdapter(val elements: List<Element>) :
    RecyclerView.Adapter<ElementAdapter.ElementViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.element_itema4, parent, false)
        return ElementViewHolder(view)
    }

    override fun onBindViewHolder(holder: ElementViewHolder, position: Int) {
        val element = elements[position]
        holder.bindElement(element)
    }

    override fun getItemCount(): Int = elements.size

    class ElementViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindElement(element: Element) {
            val imgElement = itemView.findViewById<ImageView>(R.id.ImgListElement)
            imgElement.setImageResource(element.image)
            val elementNom = itemView.findViewById<TextView>(R.id.NomListElement)
            elementNom.text = element.nomElement//comento per provar objecte element segons json
            //elementNom.text = element.nomElementCA//comento per provar objecte element segons json
        }
    }
}
*/