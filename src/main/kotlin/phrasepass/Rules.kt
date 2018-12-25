package phrasepass

data class Rules (
        val nWords: Int = 5,
        val nPunctuations: Int = 2,
        val nDigits: Int = 2
) {
    init {
        assert(nWords >= 1) {"Number of words must be at least 1"}
        assert(nWords <= 9) {"Number of words more than 9 is not supported"}

        assert(nPunctuations >= 0) {"Number of punctuations must be non-negative"}
        assert(nPunctuations <= 5) {"Number of punctuations more than 5 is not supported"}

        assert(nDigits >= 0) {"Number of digits must be non-negative"}
        assert(nDigits <= 5) {"Number of digits more than 5 is not supported"}

        assert(nPunctuations + nDigits <= nWords + 1)
            {"Number of punctuations and digits cannot be more than the slots between and after words (n+1)"}
    }
}