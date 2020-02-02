package ru.maximus.blank

import com.badlogic.gdx.Screen
import ktx.app.KtxGame

/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms.  */
class Main : KtxGame<Screen>() {
    override fun create() {
        addScreen(FirstScreen())
        setScreen<FirstScreen>()
    }
}