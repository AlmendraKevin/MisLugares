package com.example.mislugares.presentacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.mislugares.Aplicacion
import com.example.mislugares.R
import com.example.mislugares.casos_uso.CasosUsoLugar
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity() {
    val lugares by lazy { (application as Aplicacion).lugares }
    val usoLugar by lazy { CasosUsoLugar(this, lugares) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val botonPreferencias: Button = findViewById(R.id.button2)
        val botonAcercaDe: Button = findViewById(R.id.button3)
        val botonSalir: Button = findViewById(R.id.button4)
        botonPreferencias.setOnClickListener {
            lanzarPreferencias()
        }
        botonAcercaDe.setOnClickListener {
            lanzarAcercaDe()
        }
        botonSalir.setOnClickListener {
            salirBoton()
        }
    }

    fun lanzarAcercaDe(view: View? = null) {
        val i = Intent(this, AcercaDeActivity::class.java)
        startActivity(i)
    }

    fun lanzarPreferencias(view: View? = null) {
        val i = Intent(this, PreferenciasActivity::class.java)
        startActivity(i)
    }

    fun salirBoton(view: View? = null) {
        finish()
    }

    fun lanzarVistaLugar(view: View? = null) {
        val entrada = EditText(this)
        entrada.setText("0")
        AlertDialog.Builder(this)
                .setTitle("Seleccion de Lugar")
                .setMessage("Indica su id")
                .setView(entrada)
                .setPositiveButton("Ok") { dialog, whichButton ->
                    val id = parseInt(entrada.text.toString())
                    usoLugar.mostrar(id);
                }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                lanzarPreferencias()
                true
            }
            R.id.acercaDe -> {
                lanzarAcercaDe()
                true
            }
            R.id.menu_buscar -> {
                lanzarVistaLugar()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}