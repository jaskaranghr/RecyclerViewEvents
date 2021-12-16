package com.ta.recyclerviewdemo

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.core.graphics.drawable.toBitmap
import com.ta.recyclerviewdemo.databinding.ActivityFileBinding
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream

class FileActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityFileBinding

    companion object {
        val TAG = "Rango"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityFileBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.imageView.setImageResource(R.drawable.test_img)

        val byteArrayOutputStream = ByteArrayOutputStream()

        viewBinding.imageView.drawable.toBitmap().compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream)

        val byteArray = byteArrayOutputStream.toByteArray()

        val file = File(externalCacheDir,"test.jpg")

        if (!file.exists()) {
            Log.d(TAG, "onCreate: file does not exist, creating the file")
            file.createNewFile()
            Log.d(TAG, "onCreate: file is created at: ${file.absolutePath}")
            Log.d(TAG, "onCreate: file size: ${file.length()}")
        } else {
            Log.d(TAG, "onCreate: file exists at ${file.absolutePath}, size:${file.length()}")
        }

        val fos = FileOutputStream(file)

//        Log.d(TAG, "onCreate: file size: ${file.length()}")

        // writing bytes to file
        fos.write(byteArray)
        Log.d(TAG, "onCreate: file is written successfully")
//        Toast.makeText(this,"file is written successfully",Toast.LENGTH_SHORT).show()

        // closing file output stream
        fos.close()

        Log.d(TAG, "onCreate: after writing data, file size: ${file.length()}")

        Handler(Looper.getMainLooper()).postDelayed(
            {
                Log.d(TAG, "onCreate: removing image from image view")
                viewBinding.imageView.setImageResource(0)
            }, 2000
        )

        Handler(Looper.getMainLooper()).postDelayed(
            {
                Log.d(TAG, "onCreate: setting image bitmap from file to image view")
                val bitmapFromFile = BitmapFactory.decodeFile(file.absolutePath)
                viewBinding.imageView.setImageBitmap(bitmapFromFile)
            }, 4000
        )


    }
}