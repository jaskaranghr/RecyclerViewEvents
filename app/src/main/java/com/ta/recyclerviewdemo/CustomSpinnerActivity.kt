package com.ta.recyclerviewdemo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.ta.recyclerviewdemo.databinding.ActivityCustomSpinnerBinding

class CustomSpinnerActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityCustomSpinnerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityCustomSpinnerBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val array = arrayOf("Monday","Tuesday","Wednesday")

        val arrayAdapter = CustomSpinnerAdapter(this,android.R.layout.simple_spinner_item, array)

        arrayAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item)

        viewBinding.spinner.apply {
            setPopupBackgroundResource(R.drawable.bg_spinner)
            adapter = arrayAdapter
        }

//        viewBinding.spinner.adapter = arrayAdapter
    }

    class CustomSpinnerAdapter(
        private val mContext: Context,
        private val resourceId: Int,
        private val array: Array<String>
    ): ArrayAdapter<String>(mContext, resourceId, array) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

            return super.getView(position, convertView, parent)
        }

        override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {

//            return super.getDropDownView(position, convertView, parent)
        }
    }

}