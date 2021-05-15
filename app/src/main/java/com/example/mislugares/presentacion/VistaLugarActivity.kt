package com.example.mislugares.presentacion

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.mislugares.Aplicacion
import com.example.mislugares.R
import com.example.mislugares.casos_uso.CasosUsoLugar
import com.example.mislugares.modelo.Lugar
import org.jetbrains.anko.imageResource
import kotlinx.android.synthetic.main.vista_lugar.*
import java.text.DateFormat
import java.util.*

class VistaLugarActivity: AppCompatActivity() {
    val lugares by lazy { (application as Aplicacion).lugares }
    val usoLugar by lazy{ CasosUsoLugar(this,lugares) }
    var pos = 0
    lateinit var lugar:Lugar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vista_lugar)
        pos = intent.extras?.getInt("pos",0)?:0
        lugar = lugares.elemento(pos)
        actualizaVistas()
    }
    fun actualizaVistas(){
        nombre.text = lugar.nombre

        logo_tipo.imageResource = lugar.tipoLugar.recurso

        tipo.text = lugar.tipoLugar.texto

        direccion.text = lugar.direccion

        telefono.text = lugar.telefono.toString()

        //telefono.text = Integer.toString(lugar.telefono)

        url.text = lugar.url

        comentario.text = lugar.comentarios

        fecha.text = DateFormat.getDateInstance().format(Date(lugar.fecha))

        hora.text = DateFormat.getTimeInstance().format(Date(lugar.fecha))

        valoracion.rating = lugar.valoracion

        valoracion.setOnRatingBarChangeListener {

            ratingBar, valor, fromUser -> lugar.valoracion = valor

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.vista_lugar,menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.accion_compartir -> true
            R.id.accion_llegar -> true
            R.id.accion_editar -> true
            R.id.accion_borrar -> {
                usoLugar.borrar(pos)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}