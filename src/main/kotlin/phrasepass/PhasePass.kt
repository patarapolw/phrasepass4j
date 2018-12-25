package phrasepass

import java.security.SecureRandom

class PhasePass {
    private val generator = WordGenerator()
    private val random = SecureRandom()

    private val punctuations = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~".toCharArray()
    private val digits = List(10) { it.toString()[0] }

    fun nextPassword(rules: Rules = Rules()): String {
        val slots = List(rules.nWords + 1) { it }.toMutableList()
        val punctuationsMap = mutableMapOf<Int, Char>()
        val digitsMap = mutableMapOf<Int, Char>()

        while (slots.size > 0) {
            val i = slots[random.nextInt(slots.size)]
            slots.remove(i)

            if (punctuationsMap.size < rules.nPunctuations) {
                punctuationsMap[i] = punctuations[random.nextInt(punctuations.size)]
            } else if (digitsMap.size < rules.nDigits) {
                digitsMap[i] = digits[random.nextInt(digits.size)]
            } else {
                break
            }
        }

        return generator.getNWords(rules.nWords).mapIndexed { i, s -> {
            val prefix = punctuationsMap[i] ?: digitsMap[i]
            val sCap = s.capitalize()
            if(prefix != null) prefix.toString() + sCap else sCap
        }() }.joinToString("") + (punctuationsMap[rules.nWords] ?: digitsMap[rules.nWords] ?: ' ').toString().trim()
    }
}
