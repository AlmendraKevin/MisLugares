package com.example.mislugares.casos_uso

import android.app.Activity
import android.content.Intent
import com.example.mislugares.datos.RepositorioLugares
import com.example.mislugares.presentacion.VistaLugarActivity

class CasosUsoLugar(val actividad:Activity,
val lugares:RepositorioLugares) {
    //Operaciones
    fun mostrar(pos:Int){
        val i = Intent(actividad,VistaLugarActivity::class.java)
        i.putExtra("pos",pos);
        actividad.startActivity(i);
    }
    fun borrar(id:Int){
        lugares.borrar(id)
        actividad.finish()
    }
}