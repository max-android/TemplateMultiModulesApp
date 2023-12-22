package com.example.data.local

import android.app.RecoverableSecurityException
import android.content.ContentUris
import android.content.ContentValues
import android.content.Context
import android.content.IntentSender
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import com.example.domain.model.local.SharedStoragePhoto
import java.io.IOException

class ExternalImageFileManager(private val context: Context) {

    /**
     * Необходимо использовать запрос разрешения до андройд 10, иначе
     * просто есть доступ на чтение фото и запись своих фото
     */
    fun isRequestPermission(): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.Q
    }

    fun savePhotoToExternalStorage(displayName: String, bitmap: Bitmap) {
        val imageCollection = if (isRequestPermission()) {
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        } else {
            MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)
        }

        val contentValues = ContentValues().apply {
            put(MediaStore.Images.Media.DISPLAY_NAME, "$displayName.jpg")
            put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
            put(MediaStore.Images.Media.WIDTH, bitmap.width)
            put(MediaStore.Images.Media.HEIGHT, bitmap.height)
        }

        val uri = context.contentResolver.insert(imageCollection, contentValues)
        uri?.let {
            context.contentResolver.openOutputStream(it)?.use { stream ->
                if (!bitmap.compress(
                        Bitmap.CompressFormat.JPEG, 95, stream
                    )
                ) throw IOException("Failed to save bitmap.")
            } ?: throw IOException("Failed to open output stream.")
        } ?: throw IOException("Failed to create new MediaStore record.")
    }

    private fun loadPhotosFromExternalStorage(): List<SharedStoragePhoto> {

        val collection = if (isRequestPermission()) {
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        } else {
            MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL)
        }

        val projection = arrayOf(
            MediaStore.Images.Media._ID,
            MediaStore.Images.Media.DISPLAY_NAME,
            MediaStore.Images.Media.WIDTH,
            MediaStore.Images.Media.HEIGHT,
        )
        val photos = mutableListOf<SharedStoragePhoto>()
        return context.contentResolver.query(
            collection, projection, null, null, "${MediaStore.Images.Media.DISPLAY_NAME} ASC"
        )?.use { cursor ->
            val idColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
            val displayNameColumn =
                cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME)
            val widthColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.WIDTH)
            val heightColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.HEIGHT)

            while (cursor.moveToNext()) {
                val id = cursor.getLong(idColumn)
                val displayName = cursor.getString(displayNameColumn)
                val width = cursor.getInt(widthColumn)
                val height = cursor.getInt(heightColumn)
                val contentUri = ContentUris.withAppendedId(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id
                )
                photos.add(SharedStoragePhoto(id, displayName, width, height, contentUri))
            }
            photos.toList()
        } ?: listOf()
    }

    private fun deletePhotoFromExternalStorage(photoUri: Uri, loadIntent: (IntentSender) -> Unit) {
        try {
            context.contentResolver.delete(photoUri, null, null)
        } catch (e: SecurityException) {
            val intentSender = when {
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.R -> {
                    MediaStore.createDeleteRequest(
                        context.contentResolver, listOf(photoUri)
                    ).intentSender
                }

                Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q -> {
                    val recoverableSecurityException = e as? RecoverableSecurityException
                    recoverableSecurityException?.userAction?.actionIntent?.intentSender
                }

                else -> null
            }

            intentSender?.let { sender ->
                loadIntent.invoke(sender)
            }
        }
    }


    // intentSenderLauncher.launch(
    //                        IntentSenderRequest.Builder(sender).build()
    //                    )

//    private lateinit var intentSenderLauncher: ActivityResultLauncher<IntentSenderRequest>
//
//    intentSenderLauncher = registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) {
//        if(it.resultCode == RESULT_OK) {
//            if(Build.VERSION.SDK_INT == Build.VERSION_CODES.Q) {
//                lifecycleScope.launch {
//                    deletePhotoFromExternalStorage(deletedImageUri ?: return@launch)
//                }
//            }
//            Toast.makeText(this@MainActivity, "Photo deleted successfully", Toast.LENGTH_SHORT).show()
//        } else {
//            Toast.makeText(this@MainActivity, "Photo couldn't be deleted", Toast.LENGTH_SHORT).show()
//        }
//    }



    //val takePhoto = registerForActivityResult(ActivityResultContracts.OpenDocument()) {
    //
    //
    //    }


    // takePhoto.launch(
    //            arrayOf(
    //                "application/pdf",
    //                "application/msword",
    //                "application/ms-doc",
    //                "application/doc",
    //                "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
    //                "text/plain",
    //                "image/jpeg", "image/png", "image/jpg"
    //            )
    //        )
}