package com.example.data.local

import android.content.Context
import android.net.Uri

class OpenDocumentManager(private val context: Context) {

    fun openTextFile(uri: Uri): String {
        return context.contentResolver.openInputStream(uri)?.use { inputStream ->
            String(inputStream.readBytes())
        }.orEmpty()
    }

    fun saveTextFile(uri: Uri, text: String) {
        context.contentResolver.openOutputStream(uri)?.use { outputStream ->
            outputStream.write(text.toByteArray())
        }
    }

}

//private val openLauncher = registerForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
//        try {
//            uri?.let {
//                val data = openTextFile(it)
//                Toast.makeText(this, "$data", Toast.LENGTH_SHORT).show()
//            }
//        } catch (throwable: Throwable) {
//
//        }
//    }
//
//    private val saveLauncher = registerForActivityResult(ActivityResultContracts.CreateDocument("text/plain")) { uri ->
//        try {
//            uri?.let {
//                saveTextFile(it, "Привет - как дела")
//            }
//        } catch (throwable: Throwable) {
//
//        }
//    }

// saveLauncher.launch("my_file.txt")
//        lifecycleScope.launch {
//            delay(10000L)
//            openLauncher.launch(arrayOf("text/plain"))
//        }