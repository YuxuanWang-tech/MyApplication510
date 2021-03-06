package com.example.myapplication510

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val actionListener: ItemAdapter.ActionListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


        private val dataSet : MutableList<ItemList> = mutableListOf()


        fun setData(newDataSet: List<ItemList>?) {
            dataSet.clear()
            if (newDataSet != null) {
                dataSet.addAll(newDataSet)
            }
            notifyDataSetChanged()
        }

        override fun getItemCount(): Int = dataSet.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val itemView = inflater.inflate(R.layout.item2, parent, false)

            return ItemViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            (holder as ItemViewHolder).bind(dataSet[position])
        }

        inner class ItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
            private val CBitem : CheckBox = itemView.findViewById(R.id.CBitem)

            init {
                val checkItemView : CheckBox = (itemView as ViewGroup).getChildAt(0) as CheckBox
                checkItemView.setOnCheckedChangeListener { cButton: CompoundButton, b: Boolean ->
                    val listPosition = adapterPosition
                    if (listPosition != RecyclerView.NO_POSITION) {
                        val clickedList = dataSet[listPosition]
                        actionListener.onItemClicked(clickedList, b)
                    }
                }
                val listPosition = adapterPosition
                if (listPosition != RecyclerView.NO_POSITION) {
                    checkItemView.isChecked = dataSet[adapterPosition].fait
                }
            }

            fun bind(itemToDo : ItemList) {
                CBitem.text = itemToDo.description
                CBitem.isChecked = itemToDo.fait
            }
        }


        interface ActionListener {
            fun onItemClicked(itemToDo : ItemList, value : Boolean)
        }


    }

