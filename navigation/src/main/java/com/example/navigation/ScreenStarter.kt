package com.example.navigation

interface ScreenStarter {

    fun startRoot(): ComposeNavFactory
    fun startProfile(): ComposeNavFactory

}