package com.example.myapplication510

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*

class ShowListActivity : AppCompatActivity(), ItemAdapter.ActionListener, View.OnClickListener {
    private val activityScope = CoroutineScope(
        SupervisorJob()//
                + Dispatchers.Main
                + CoroutineExceptionHandler { _, throwable ->
            Log.e("MainActivity", "${throwable.message}")
        }
    )
    private var adapter: ItemAdapter? = null
    private var BtnOK: Button? = null
    private var ListInput: EditText? = null
    private var prefs: SharedPreferences? = null
    private var itemList: ItemList? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.showlist)
        /*
        Declarations
         */
        BtnOK = findViewById(R.id.BtnShowList)
        ListInput = findViewById(R.id.ShowListInput)
        adapter = newAdapter()
        prefs = PreferenceManager.getDefaultSharedPreferences(this)
        BtnOK?.let { btn -> btn.setOnClickListener(this) }

        /*
        Get from ChoixList
         */
        val bundle = this.intent.extras
        //NameList = bundle!!.getSerializable("liste") as NameList
        //信息列表


        /*
        RecyclerView
         */
        val ItemList: RecyclerView = findViewById(R.id.listofitem)

        ItemList.adapter = adapter
        ItemList.layoutManager = LinearLayoutManager(this)
        val dataSet: String = itemList!!.description
        //adapter!!.setData(newDataSet)
    }

    private fun newAdapter(): ItemAdapter = ItemAdapter(actionListener = this)
    //cocher/décocher chaque item,
    /*
     private fun cocherTask(hash:String,idList:Int,idTask: Int,check:Int){
        activityScope.launch{
            val result=DataProvider.checkItem(hash,idList,idTask,check)
            if( result!=null){
                adapter?.notifyDataSetChanged()
                Log.i("ShowListActivity","Success: list${idList} task${idTask}'s etat is $check")
            }else{
                Log.i("ShowListActivity","check task fail")
            }
        }
    }
     */


    override fun onItemClicked(itemList: ItemList, value: Boolean) {
        val sharedPreference = getSharedPreferences("Setting", Context.MODE_PRIVATE)

    }

    /*
    OK Button listener
    */
    override fun onClick(v: View) {
        when (v.id) {
            R.id.BtnShowList -> {
                val descItem = ListInput!!.text.toString()
                // Check if an item with the same description doesn't already exists
                // Update list
                // Serialize the new list of players
                /// Update the file

            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        //val inflater: MenuInflater = menuInflater
        //inflater.inflate(R.menu.main, menu)
        return true

    }
    // Handle item selection
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return true
    }



}
