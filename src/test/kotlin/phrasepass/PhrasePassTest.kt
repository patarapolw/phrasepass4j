package phrasepass

import org.junit.jupiter.api.Test

class PhrasePassTest {
    private val phasePass = PhasePass()

    @Test
    fun testGeneratePhrasePass() {
        List(5){}.forEach { println(phasePass.nextPassword()) }
    }
}