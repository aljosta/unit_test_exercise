package com.example.unittestexercise

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.StrictStubs::class)
class ExercisePresenterTest {

    @Mock
    lateinit var view: View

    @Mock
    lateinit var analyticsManager: AnalyticsManager

    @Mock
    lateinit var getPokemonUseCase: GetPokemonUseCase

    @Mock
    lateinit var savePokemonUseCase: SavePokemonUseCase

    @Mock
    lateinit var pokemon: Pokemon

    lateinit var exercisePresenter: ExercisePresenter

    @Before
    fun setup() {
        exercisePresenter = ExercisePresenter(
            view,
            getPokemonUseCase,
            analyticsManager,
            savePokemonUseCase
        )
    }

    @Test
    fun `Test get pikachu pokemon when on click`() {
        val textTrack = "Click getPokemon button"
        val luckyMessage = "This is a great day!"

        `when`(getPokemonUseCase.execute()).thenReturn(pokemon)
        `when`(pokemon.name).thenReturn("Pikachu")

        exercisePresenter.onClickGetPokemon()

        verify(analyticsManager).track(textTrack)
        verify(view).disableButton()
        verify(getPokemonUseCase).execute()
        verify(pokemon).name
        verify(view).showLuckyMessage(luckyMessage)
        verify(savePokemonUseCase).execute(pokemon)
        verify(view).enableButton()

    }

    @Test
    fun `Test get pokemon different pikachu when on click`() {
        val textTrack = "Click getPokemon button"

        `when`(getPokemonUseCase.execute()).thenReturn(pokemon)
        `when`(pokemon.name).thenReturn("OtroPokemon")

        exercisePresenter.onClickGetPokemon()

        verify(analyticsManager).track(textTrack)
        verify(view).disableButton()
        verify(getPokemonUseCase).execute()
        verify(pokemon).name
        verify(view).displayPokeInformation(pokemon)
        verify(savePokemonUseCase).execute(pokemon)
        verify(view).enableButton()
    }


}