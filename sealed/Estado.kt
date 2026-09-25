package org.example.sealed

import org.example.Model.Vehiculo
import java.time.LocalDateTime

sealed class Estado {
    data class exito(val Vehiculo : Vehiculo): Estado()
    data class Error(val error: String): Estado()
    object Procesando: Estado()
}

fun EstadoConsulta(estado : Estado) {
    when (estado) {
       is Estado.exito -> {
           val Horasalida = LocalDateTime.now()
           val costo = estado.Vehiculo.calcularCosto(Horasalida)
           println("Operacion realizada con exito, monto a pagar: $${costo}")
       }
        is Estado.Error -> {println("Error ${estado.error}")}
        is Estado.Procesando -> {println("PROCESANDO")}
    }

}