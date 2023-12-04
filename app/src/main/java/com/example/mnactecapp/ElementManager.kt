package com.example.mnactecapp


object ElementManager {
    //llistat d'objectes Element per a accedir-hi des de totes les classes
    val elements = mutableListOf<Element>()

    //Índex per al llistat elements, per localitzar un Element en particular (p.e. per mostrar a la pantalla de detalls del vehicle)
    var indexElements: Int = -1

    var defaultElement = 0

    //Definició d'idioma: 0 cat, 1 spa, 2 eng
    var idioma: Int = -1
    //var idioma = String
}