package ru.maximus.blank

import com.badlogic.gdx.Screen
import com.strongjoshua.console.Console
import ktx.app.KtxGame
import ktx.app.KtxScreen
import ktx.async.enableKtxCoroutines
import ktx.inject.Context
import ru.maximus.blank.console.GameConsole
import ru.maximus.blank.screens.MainMenuScreen
import ru.maximus.blank.screens.SettingsScreen

/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms.  */
class Main : KtxGame<Screen>() {

    companion object {
        lateinit var instance: Main
        val context = Context()
    }

    override fun create() {
        instance = this

        enableKtxCoroutines(asynchronousExecutorConcurrencyLevel = 1)
        context.register {
            bindSingleton<Console>(GameConsole.createConsole())

            bindSingleton(MainMenuScreen())
            bindSingleton(SettingsScreen())
        }

        addScreen(context.inject<MainMenuScreen>())
        addScreen(context.inject<SettingsScreen>())

        setScreen<MainMenuScreen>()
    }

    override fun render() {
        super.render()
        context.inject<Console>().draw()
    }

    override fun resize(width: Int, height: Int) {
        super.resize(width, height)
        context.inject<Console>().refresh()
    }

}