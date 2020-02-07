package ru.maximus.blank.console

import com.strongjoshua.console.CommandExecutor
import com.strongjoshua.console.annotation.ConsoleDoc

class GameConsoleCommandExecutor : CommandExecutor() {

    @ConsoleDoc(description = "a + b = c")
    fun sumTest(a: Int, b: Int) {
        val c = a + b
        console.log("Test: $a + $b = $c")
    }

}