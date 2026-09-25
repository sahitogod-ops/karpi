package org.example.Model

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import kotlin.math.roundToInt

class Camioneta(Patente: String, Marca: String, tipoCliente: TipoCliente, CantidadHoras: LocalDateTime, var CapacidadCarga: Double): Vehiculo(Patente,Marca, CantidadHoras, tipoCliente, ) {

    override fun calcularCosto(Horas: LocalDateTime): Int {
        val HorasLong = ChronoUnit.HOURS.between(this.CantidadHoras, Horas)
        val HorasInt = HorasLong.toInt()
        val Tarifa2: Double = 2500.0*HorasInt

        val TarifaFinal= AplicarDescuento(Tarifa2)
        return TarifaFinal.roundToInt()
    }
}
