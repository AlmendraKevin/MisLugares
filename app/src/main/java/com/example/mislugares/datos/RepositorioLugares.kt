package com.example.mislugares.datos

import com.example.mislugares.modelo.GeoPunto
import com.example.mislugares.modelo.Lugar
import com.example.mislugares.modelo.TipoLugar

interface RepositorioLugares {
    fun elemento(id:Int): Lugar
    fun  añade(lugar: Lugar)
    fun nuevo():Int
    fun borrar(id:Int)
    fun tamaño():Int
    fun actualiza(id: Int,lugar: Lugar)

    fun  añadeEjemplos(){
        añade(Lugar("Hotel Fiesta Inn Mexicali", "BOULEVARD ADOLFO LOPEZ MATEOS 1029 COLONIA INDUSTRIAL, Centro Cívico, 21000 Mexicali, B.C."
                , GeoPunto(32.6455925, -115.4750889), TipoLugar.HOTEL, ""
                , 6868373300, "www.fiestainn.com", "Ideal para visitantes", 1, 4.4F))
    }
}