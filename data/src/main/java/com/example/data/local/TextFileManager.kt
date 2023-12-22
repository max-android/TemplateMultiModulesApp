package com.example.data.local

import android.content.Context
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader

class TextFileManager(private val context: Context) {

    fun saveFile(fileName: String, text: String) {
        val file = File(context.filesDir, fileName)
        FileOutputStream(file).use { outputStream ->
            val bytes = text.toByteArray()
            outputStream.write(bytes)
        }
    }

    fun openFile(fileName: String): String {
        val file = File(context.filesDir, fileName)
        val inputStream = FileInputStream(file)
        val reader = InputStreamReader(inputStream)
        val bufferedReader = BufferedReader(reader)
        return bufferedReader.use { read ->
            read.readLines().joinToString(separator = "\n")
        }
    }

    fun openFile2(fileName: String): String {
        val file = File(context.filesDir, fileName)
        return FileInputStream(file).use { inputStream ->
            String(inputStream.readBytes())
        }
    }

    companion object {
        const val FILE_NAME = "my_file.txt"
    }

}