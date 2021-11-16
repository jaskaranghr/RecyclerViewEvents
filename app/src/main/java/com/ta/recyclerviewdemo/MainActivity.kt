package com.ta.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.ta.recyclerviewdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var listAdapter: ListAdapter

    companion object {
        val TAG = "Rango"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        val dataset = arrayListOf("First", "Second", "Third")
        listAdapter = ListAdapter(dataset, itemClickListener)
        viewBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = listAdapter
        }
    }

    private val itemClickListener = object: ItemClickListener {
        override fun onItemClick(position: Int) {
            Log.d(TAG, "onItemClick: Before Notifying: ${viewBinding.recyclerView.findViewHolderForAdapterPosition(position)}")
            listAdapter.notifyItemChanged(position)
            Log.d(TAG, "onItemClick: After Notifying: ${viewBinding.recyclerView.findViewHolderForAdapterPosition(position)}")

            viewBinding.recyclerView.postDelayed({
                Log.d(TAG, "onItemClick: 2 seconds After Notifying: ${viewBinding.recyclerView.findViewHolderForAdapterPosition(position)}")
            }, 2000)

        }
    }
}