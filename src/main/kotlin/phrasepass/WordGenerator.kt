package phrasepass

import java.security.SecureRandom

class WordGenerator {
    private val random = SecureRandom()
    private val wordList: List<String>

    init {
        wordList = this::class.java.classLoader.getResource("eff_large_wordlist.txt").readText().split('\n').map {
            val contents = it.split('\t')
            if(contents.size > 1) {
                return@map contents[1]
            }
            return@map null
        }.filterNotNull()
    }

    fun nextWord(): String = wordList[random.nextInt(wordList.size)]

    fun getNWords(n: Int): List<String> = List(n){ nextWord() }
}