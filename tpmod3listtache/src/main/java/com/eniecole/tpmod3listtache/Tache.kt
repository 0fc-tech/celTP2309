package com.eniecole.tpmod3listtache
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Tache(
    val name: String,
    var isAlreadyDone : Boolean = false
) :Parcelable
