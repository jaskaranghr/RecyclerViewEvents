package com.ta.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ta.recyclerviewdemo.databinding.ActivityTextFileBinding
import java.io.File
import java.io.FileOutputStream

class TextFileActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityTextFileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityTextFileBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        viewBinding.btnSave.setOnClickListener {
            saveTextToFile(viewBinding.etContent.text.toString().trim(), viewBinding.etFileName.text.toString().trim())
        }
    }

    private fun saveTextToFile(content: String, fileName: String) {
        val textFilename = if (fileName.isEmpty()) "test" else fileName
        val file = File(externalCacheDir, "$textFilename.txt")
        val fos = FileOutputStream(file)
        fos.write(content.toByteArray())
        fos.close()
        Toast.makeText(this,"Saved to file at ${file.absolutePath}", Toast.LENGTH_SHORT).show()
    }

}