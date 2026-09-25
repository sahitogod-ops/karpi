package org.example.Funciones

import kotlinx.coroutines.delay
import org.example.Model.Camioneta
import org.example.Model.Moto
import org.example.Model.TipoCliente
import org.example.Model.Vehiculo
import org.example.sealed.Estado
import java.time.LocalDateTime
import kotlin.compareTo

fun CrearVehiculos(): List<Vehiculo>{

    val camioneta1 = Camioneta("AB12CD", "Toyota", TipoCliente.REGULAR, LocalDateTime.now().minusHours(3).minusMinutes(5),800.0)
    val camioneta2 = Camioneta("AB12CD","Ford", TipoCliente.ABONADO, LocalDateTime.now().minusHours(2),1000.0 )
    val moto1= Moto("MN56OP","Honda", LocalDateTime.now().minusHours(4), TipoCliente.REGULAR,250)
    val moto2= Moto("PQ78RS", "Yamaha",LocalDateTime.now().minusHours(1), TipoCliente.ABONADO,600)


    return listOf(camioneta1, camioneta2, moto1, moto2)


}
fun mostrarVehiculos() {
     var vehiculos: List<Vehiculo> = listOf()
    println("--- ANÁLISIS DE FLOTA ---")
    println()
    println(vehiculos.forEach { println(it) })


}



suspend fun registrarSalida(patente: String, vehiculos: List<Vehiculo>): Estado{
    println("Registrando Salida de ${patente}")
    delay(500)
    println("Buscando vehiculo con patente ${patente}")
    delay(500)

    val vehiculo = vehiculos.find { it.patente==patente }?:
    return Estado.Error("Vehiculo con la patente ${patente} no encontrado")

    println("Procesando pago para ${vehiculo.marca} - ${vehiculo.patente}")

    if(vehiculo.CantidadHoras <= LocalDateTime.now().minusHours(0)) {
        return Estado.Error("el tiempo de permanecia es invalido")

    }
    val horas= LocalDateTime.now()
    val costo = vehiculo.calcularCosto(horas)

    if (costo > 10000){
        return Estado.Error("El costo escede el maximo permitido")
    }

    println("${vehiculo.patente} salio ")
    return Estado.exito(vehiculo)

}



fun Operaciones(vehiculos: List<Vehiculo>) {

    val totalhoras = vehiculos.sumOf { it.CantidadHoras as Int}
    println("Totalhoras ${totalhoras}")

    val abonados = vehiculos.filter { it.tipoCliente == TipoCliente.ABONADO }.map { it.patente }
    println("vehiculos: ${abonados}")

    val LargaPermanencia = vehiculos.filter { it.CantidadHoras <= LocalDateTime.now().minusHours(3) }.map { it.patente }
    println("Larga permanencia: ${LargaPermanencia}")

    val ordenados = vehiculos.sortedByDescending { it.CantidadHoras }
    var i = 1
    for (v in ordenados){
        println("$i. ${v.patente}")
    }



}

fun mostrar(vehiculos: List<Vehiculo>) {
    val horas= LocalDateTime.now()
    for (v in vehiculos){
        println("${v.patente}: ${v.calcularCosto(horas)}")
    }









}