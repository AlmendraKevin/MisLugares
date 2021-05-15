package com.example.mislugares.casos_uso

import android.app.Activity
import android.content.Intent
import com.example.mislugares.presentacion.AcercaDeActivity
import com.example.mislugares.presentacion.PreferenciasActivity

class CasosUsoActividades(val actividad: Activity) {

    fun lanzarAcercaDe() = actividad.startActivity(
            Intent(actividad, AcercaDeActivity::class.java))

    fun lanzarPreferencias(codigoSolicitud: Int) = actividad.startActivity(
            Intent(actividad, PreferenciasActivity::class.java))
}