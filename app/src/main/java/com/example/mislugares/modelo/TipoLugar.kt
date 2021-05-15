package com.example.mislugares.modelo

import com.example.mislugares.R

enum class TipoLugar private constructor(val texto:String,val recurso:Int) {
    OTROS("Otros", R.drawable.otros),
    RESTAURANTE("Restaurante", R.drawable.restaurante),
    BAR("Bar", R.drawable.bar),
    ESPECTACULO("Espectaculo", R.drawable.espectaculos),
    HOTEL("Hotel", R.drawable.hotel),
    COMPRAS("Compras", R.drawable.compras),
    EDUCACION("Educacion", R.drawable.educacion),
    DEPORTE("Deporte", R.drawable.deporte),
    NATURALEZA("Naturaleza", R.drawable.naturaleza),
    GASOLINERA("Gasolinera", R.drawable.gasolinera);

    fun getNombre(): Array<String?>{
        val resultado = arrayOfNulls<String>(TipoLugar.values().size)
        for (tipo in TipoLugar.values()){
            resultado[tipo.ordinal] = tipo.texto
        }
        return resultado
    }

}