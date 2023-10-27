package com.example.featureProfile

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavBackStackEntry
import com.example.coreUi.components.Person
import com.example.navigation.parcelableData

@Composable
fun ProfileComponent(navController: NavController, navBackStackEntry: NavBackStackEntry) {

    //TODO пример с передачей объектов по компонентам
    Log.i("--DATA", "-------------- "+navBackStackEntry.parcelableData<Person>("myKey"))
}