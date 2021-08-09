package com.example.unittestexercise

class GetPokemonUseCase {

    fun execute(): Pokemon {
        println("GetPokemon")
        return Pokemon("NamePokemon")
    }
}