package org.example.Model

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import kotlin.math.roundToInt

open class Vehiculo(val patente:String, val marca:String, var CantidadHoras: LocalDateTime, var tipoCliente: TipoCliente) {

    open fun AplicarDescuento(CostoBase: Double): Double {
        return if (this.tipoCliente == TipoCliente.ABONADO) {
            CostoBase * 0.85
        }else{
            CostoBase
        }
    }

    open fun calcularCosto(Horas: LocalDateTime): Int {

        val Horaslong = ChronoUnit.HOURS.between(this.CantidadHoras, Horas)
        val HorasInt = Horaslong.toInt()
        val TarifaBase: Double = 2000.0*HorasInt

        val TarifaFinal= AplicarDescuento(TarifaBase)

        return TarifaFinal.roundToInt()



    }


}