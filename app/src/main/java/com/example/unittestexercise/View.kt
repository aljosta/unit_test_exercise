package com.example.unittestexercise

class View {

    fun disableButton() {
        println("disabled button")
    }

    fun enableButton() {
        println("enabled button")
    }

    fun showLuckyMessage(message: String) {
        println(message)
    }

    fun displayPokeInformation(poke: Pokemon) {
        println("Pokemon ${poke.name}")
    }
}