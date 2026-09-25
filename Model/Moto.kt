package org.example.Model

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import kotlin.math.roundToInt

class Moto(Patente: String, Marca: String, CantidadHoras: LocalDateTime, tipoCliente: TipoCliente, var Cilindrada: Int): Vehiculo(Marca, Marca, CantidadHoras, tipoCliente) {

    override fun calcularCosto(Horas: LocalDateTime): Int {
        val Horaslong = ChronoUnit.HOURS.between(this.CantidadHoras,Horas)
        val HorasInt = Horaslong.toInt()
        val Tarifa3: Double = 1500.0*HorasInt

        val TarifaFinal = AplicarDescuento(Tarifa3)

        if (this.Cilindrada > 500){
            val Cilin: Double = Tarifa3*1.2
            TarifaFinal*Cilin
        }

        return TarifaFinal.roundToInt()
    }

}