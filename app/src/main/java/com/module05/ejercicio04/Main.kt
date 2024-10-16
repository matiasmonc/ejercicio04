package com.module05.ejercicio04

fun main(){

    var lista = ListaUsuarios(mutableListOf());


    var usuario1: Usuario = Usuario("Matias Moncada", 29, null, null)
    var usuario2: Usuario = Usuario("Gaspar Santander", 26, "Programador", usuario1)
    var usuario3: Usuario = Usuario("Fernanda Santander", 30, "Educadora de parvulos", null)
    var usuario4: Usuario = Usuario("Maite Valenzuela", 22, "Matrona", usuario3)
    var usuario5: Usuario = Usuario("Aurora Moncada", 20, "Doctora", usuario1)

    lista.agregarUsuario(usuario1)
    lista.agregarUsuario(usuario2)
    lista.agregarUsuario(usuario3)
    lista.agregarUsuario(usuario4)
    lista.agregarUsuario(usuario5)

    println(lista.mostrarLista())

    var listFiltrada = lista.filtrarListaPorEdad(25)

    println("\n\nLista FILTRADA")

    for (ls in listFiltrada){
        println("${ls.getNombre()} - ${ls.getEdad()} años")
    }
}

class Usuario(
    private var nombre: String,
    private var edad: Int,
    private var trabajo: String?,
    private var referencia: Usuario?
){

    fun getNombre():String{
        return nombre
    }

    fun getEdad():Int{
        return edad
    }

    fun mostrarDatos():Unit{
        println("$nombre - $edad años ${if(trabajo != null) "- $trabajo" else ""} ${if(referencia != null) "- Recomendado por: ${referencia?.nombre}" else ""}")
    }


}

class ListaUsuarios(
    private var listaUsuarios: MutableList<Usuario> = mutableListOf()
){
    fun agregarUsuario(usuario: Usuario): Unit{
        listaUsuarios.add(usuario)
    }

    fun eliminarUsuario(nombre: String): Unit{
        listaUsuarios.removeIf { it.getNombre() == nombre}
    }

    fun mostrarLista(): Unit{
        for (lista in listaUsuarios){
            lista.mostrarDatos()
        }
    }

    fun filtrarListaPorEdad(edad: Int):List<Usuario> {
        return listaUsuarios.filter { it.getEdad() > edad }.toList()
    }
}