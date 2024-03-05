package com.eniecole.tpmod2gestionbibliotheque

interface Borrowable {
    fun borrow(borrower: User):Boolean
    fun returnItem(borrower: User)
}