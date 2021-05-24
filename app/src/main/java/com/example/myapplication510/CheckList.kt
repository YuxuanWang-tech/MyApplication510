package com.example.myapplication510

import java.io.Serializable

class CheckList (var login : String = "") : Serializable {

        var mesListeToDo : MutableList<ItemLtName> = mutableListOf()

        constructor(log: String, mesListes: MutableList<ItemLtName>) : this() {
            login = log
            mesListeToDo = mesListes
        }

        fun addListe(uneListe : ItemLtName) {
            mesListeToDo.add(uneListe)
        }

        // Add unItem to the list uneListe if it is present in mesListeToDo
        fun addItem(uneListe: ItemLtName?, unItem : ItemList) {
            var updatedListes : MutableList<ItemLtName> = mutableListOf()
            for (list : ItemLtName in mesListeToDo) {
                if (list.titreList == uneListe!!.titreList) {
                    list.addItem(unItem)
                    uneListe.addItem((unItem))
                }
                updatedListes.add(list)
            }
            mesListeToDo = updatedListes
        }

        // Update unItem from the list uneListe
        fun updateItem(uneListe: ItemLtName?, unItem : ItemList) {
            var updatedListes : MutableList<ItemLtName> = mutableListOf()
            for (list : ItemLtName in mesListeToDo) {
                if (list.titreList == uneListe!!.titreList) {
                    list.updateItem(unItem)
                    uneListe.updateItem((unItem))
                }
                updatedListes.add(list)
            }
            mesListeToDo = updatedListes
        }

        // Check if a list with the given title already exists
        fun listAlreadyExists(title : String) : Boolean {
            for (list : ItemLtName in mesListeToDo) {
                if (list.titreList == title) {
                    return true
                }
            }
            return false
        }

        override fun toString(): String = "Listes du profil $login : $mesListeToDo"



    }
