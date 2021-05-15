package com.example.mislugares.modelo

data class Lugar(val nombre: String,
                 val direccion: String = "",
                 val posicion: GeoPunto = GeoPunto.SIN_POSICION,
                 val tipoLugar: TipoLugar = TipoLugar.OTROS,
                 val foto: String = "",
                 val telefono: Long = 0,
                 val url: String = "",
                 val comentarios: String = "",
                 val fecha: Long = System.currentTimeMillis(),
                 var valoracion: Float = 3.5F
) {
}