package com.example.myapplication510
import java.io.Serializable

class ItemList(val description:String = "", val fait : Boolean = false) : Serializable{
    override fun toString(): String {
        return "Tâche $description ${if (!fait) "non" else ""} effectuée"
    }
}