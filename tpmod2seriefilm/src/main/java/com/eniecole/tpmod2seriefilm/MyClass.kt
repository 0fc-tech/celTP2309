package com.eniecole.tpmod2seriefilm

var mapFilmSerie = mutableMapOf<String, Boolean>()

fun afficherMenu(){
    println("Choisissez")
    println("1 - Ajouter un film/série déjà vu")
    println("2 - Ajouter un film/série à voir")
    println("3 - Voir toute la liste")
    println("4 - Exit")
}
fun ajoutFilmSerie(dejaVu : Boolean){
    if(dejaVu){
        println("Rentrez le nom d'un film/série déjà vu")
    }else
        println("Rentrez le nom d'un film/série à voir")
    val filmSerie = readln()
    mapFilmSerie[filmSerie] = dejaVu
}
fun affichageListeFilm(){
    for(filmSerie in mapFilmSerie){
        println("${filmSerie.key} : ${if (filmSerie.value) "déjà vu" else "à voir"}")
    }
}
fun main() {
    var choixUtilisateur : Int? = null
    do {
        afficherMenu()
        choixUtilisateur = readln().toIntOrNull()
        when(choixUtilisateur){
            1 -> ajoutFilmSerie(true)
            2 -> ajoutFilmSerie(false)
            3 -> affichageListeFilm()
        }
    }
    while (choixUtilisateur != 4)

}

