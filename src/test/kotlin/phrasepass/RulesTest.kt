package phrasepass

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class RulesTest {
    @Test
    fun testTooFewWords() {
        assertThrows(AssertionError::class.java) {Rules(nWords = 0)}
    }

    @Test
    fun testTooManyWords() {
        assertThrows(AssertionError::class.java) {Rules(nWords = 10)}
    }

    @Test
    fun testTooFewPunctuations() {
        assertThrows(AssertionError::class.java) {Rules(nPunctuations = -1)}
    }

    @Test
    fun testTooManyPunctuations() {
        val n = 6
        assertThrows(AssertionError::class.java) {Rules(nPunctuations = n, nWords =  n + 1)}
    }

    @Test
    fun testTooFewDigits() {
        assertThrows(AssertionError::class.java) {Rules(nDigits = -1)}
    }

    @Test
    fun testTooManyDigit() {
        val n = 6
        assertThrows(AssertionError::class.java) {Rules(nDigits = n, nWords = n + 1)}
    }

    @Test
    fun testTooManyPunctuataionsAndDigitsRelativeToWords() {
        assertThrows(AssertionError::class.java) {Rules(nDigits = 3, nPunctuations = 3, nWords = 4)}
    }
}