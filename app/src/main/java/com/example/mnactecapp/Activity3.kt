package com.example.mnactecapp

import ElementsList
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import android.os.Handler

class Activity3 : AppCompatActivity() {

    object elementShownConstant {
        const val ELEMENT = "ELEMENT"
    }

    private val handler = Handler()
    private val inactivityRunnable = Runnable {
        // Tornar a la MainActivity
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity3)

        val btnPlay: Button = findViewById(R.id.btnPlay)
        val btnList: Button = findViewById(R.id.btnList)
        val txtVwDescripcio: TextView = findViewById(R.id.TxtVwDescripcio)
        val listView: ListView = findViewById(R.id.lvCaract1)
        val imgVwElement: ImageView = findViewById(R.id.imgShownElement)
        val act3FrameText: TextView = findViewById(R.id.act3FrameText)

        txtVwDescripcio.movementMethod = android.text.method.ScrollingMovementMethod.getInstance()

        val intent = getIntent()
        val elementShown = intent.getSerializableExtra(elementShownConstant.ELEMENT) as Element
        act3FrameText.text = elementShown.nameElement

        when (ElementManager.idioma) {
            0 -> {
                btnPlay.text = getString(R.string.btnPlayCAT)
                btnList.text = getString(R.string.btnFieldCAT)
            }
            1 -> {
                btnPlay.text = getString(R.string.btnPlaySPA)
                btnList.text = getString(R.string.btnFieldSPA)
            }
            2 -> {
                btnPlay.text = getString(R.string.btnPlayENG)
                btnList.text = getString(R.string.btnFieldENG)
            }
        }

        btnList.setOnClickListener {
            val intent = Intent(this, Activity4::class.java)
            startActivity(intent)
        }
        btnPlay.setOnClickListener {
            val intent = Intent(this, Activity6::class.java)
            startActivity(intent)
        }

        txtVwDescripcio.setText(elementShown.description)
        val imgElementPath = getFilesDir().toString() + "/imgelements/" + elementShown.image
        if (File(imgElementPath).exists()) {
            val bitmap = BitmapFactory.decodeFile(imgElementPath)
            imgVwElement.setImageBitmap(bitmap)
        } else {
            imgVwElement.setImageResource(R.drawable.defaultelement)
        }

        val elementsList = ElementsList(this)
        val datos = elementsList.filterAndMapElement(elementShown)
        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, datos)
        listView.adapter = adaptador

        val rootView = findViewById<View>(android.R.id.content)
        rootView.setOnTouchListener { _, _ ->
            resetInactivityTimer()
            false
        }
    }

    override fun onResume() {
        super.onResume()
        resetInactivityTimer()
    }

    override fun onPause() {
        super.onPause()
        stopInactivityTimer()
    }

    private fun resetInactivityTimer() {
        handler.removeCallbacks(inactivityRunnable)
        handler.postDelayed(inactivityRunnable, 30000)
    }

    private fun stopInactivityTimer() {
        handler.removeCallbacks(inactivityRunnable)
    }
}

/*codi branch main 30/11/2023 (crec que és igual, repassar)

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity3)

        val botonpasar: TextView = findViewById(R.id.botonpasar)
        val botonatras: TextView = findViewById(R.id.botonatras)
        val botonidiomas1: TextView = findViewById(R.id.botonidiomas1)
        val txtVwDescripcio: TextView = findViewById(R.id.TxtVwDescripcio)

        //permetre scroll en el textview TxtVwDescripcio
        txtVwDescripcio.movementMethod = android.text.method.ScrollingMovementMethod.getInstance()

        botonpasar.setOnClickListener {
            // Crear un Intent para abrir Activity2
            val intent = Intent(this@Activity3, Activity4::class.java)
            startActivity(intent)
        }

        botonatras.setOnClickListener {
            // Crear un Intent para abrir Activity1
            val intent = Intent(this@Activity3, MainActivity::class.java)
            startActivity(intent)
        }
        botonidiomas1.setOnClickListener {
            // Crear un Intent para abrir idiomas
            val intent = Intent(this@Activity3, idiomas::class.java)
            startActivity(intent)
        }
        val listView: ListView = findViewById(R.id.lvCaract1)

// Simulación de datos para el adaptador (reemplaza esto con tus propios datos)
        val datos = arrayOf("Número d'inventari: 12345", "Any d'ingrés: 1989", "Alçada: 2m")

// Configurar el adaptador
        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, datos)

// Establecer el adaptador en el ListView
        listView.adapter = adaptador
    }
}
 */