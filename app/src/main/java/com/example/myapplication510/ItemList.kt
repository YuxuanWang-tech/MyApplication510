package com.example.myapplication510
import java.io.Serializable

class ItemList (var description : String = "", var fait : Boolean = false) : Serializable {

    override fun toString(): String = "Tâche $description ${if (!fait) "non" else ""} effectuée"

}

