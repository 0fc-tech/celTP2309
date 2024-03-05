package com.eniecole.tpmod2gestionbibliotheque

open class Item(
    val titre: String,
    val auteur: String,
    val anneeSortie: Int,
    var isAvailable :Boolean = true)