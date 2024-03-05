package com.eniecole.tpmod2gestionbibliotheque

class User(val name: String, val id :Int) {
    val borrowedItems = mutableListOf<Item>()
    fun borrow(item : Item){
        if(item is Borrowable && item.isAvailable){
            item.borrow(this)
            borrowedItems.add(item)
        }else{
            println("${item.titre} is not available for borrowing")
        }
    }
    fun returnItem(item : Item){
        if(item is Borrowable && borrowedItems.contains(item)){
            item.returnItem(this)
            borrowedItems.remove(item)
        }else{
            println("Cet item n'a pas été emprunté ou n'est pas empruntable")
        }
    }
}
