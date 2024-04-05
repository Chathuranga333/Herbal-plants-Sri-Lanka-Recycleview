package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class plant(val slname: String, val bname: String, val info: String, val imageId: Int)
private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var herbals: MutableList<plant>
    private lateinit var adapter: ItemAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        herbals = createHerbals()

        adapter = ItemAdapter(this,herbals)

        val recyclerView: RecyclerView = findViewById(R.id.slhplants)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun createHerbals(): MutableList<plant>{
       val herbals = mutableListOf<plant>()
        val infodataArray = resources.getStringArray(R.array.info_data_array)
        val bnameArray = resources.getStringArray(R.array.b_name_array)
        for (i in 1 .. 50)
        {
            val infodata = infodataArray.getOrNull(i-1)?:""
            val bdata = bnameArray.getOrNull(i-1)?:""
            val specificname = "plant$i"
            val imageresid = resources.getIdentifier(specificname,"drawable",packageName)
            herbals.add(plant("plant $i",bdata,infodata,imageresid))

            Log.i(TAG,"imageresid")
        }
        return herbals
    }
}