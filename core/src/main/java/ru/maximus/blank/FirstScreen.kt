package ru.maximus.blank

import com.badlogic.gdx.Input
import com.strongjoshua.console.CommandExecutor
import com.strongjoshua.console.GUIConsole
import com.strongjoshua.console.annotation.ConsoleDoc
import ktx.app.KtxScreen

/** First screen of the application. Displayed after the application is created.  */
class FirstScreen : KtxScreen {

    val console = GUIConsole().apply {
        displayKeyID = Input.Keys.GRAVE
        enableSubmitButton(true)
        setCommandExecutor(TestCommandExecutor())
    }

    override fun render(delta: Float) {
        console.draw()
    }

    class TestCommandExecutor : CommandExecutor() {

        @ConsoleDoc(description = "a + b = c")
        fun sumTest(a: Int, b: Int) {
            val c = a + b
            console.log("Test: $a + $b = $c")
        }

    }

}