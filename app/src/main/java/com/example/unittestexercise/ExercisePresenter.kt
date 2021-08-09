package com.example.unittestexercise

class ExercisePresenter (
    private val view: View,
    private val getPokemon: GetPokemonUseCase,
    private val analyticsManager: AnalyticsManager,
    private val savePokemon: SavePokemonUseCase
) {

    fun onClickGetPokemon() {
        analyticsManager.track("Click getPokemon button")
        view.disableButton()

        val poke = getPokemon.execute()

        if(poke.name == "Pikachu") {
            view.showLuckyMessage("This is a great day!")
        } else {
            view.displayPokeInformation(poke)
        }

        savePokemon(poke)
        view.enableButton()
    }

    private fun savePokemon(pokemon: Pokemon) {
        savePokemon.execute(pokemon)
    }
}