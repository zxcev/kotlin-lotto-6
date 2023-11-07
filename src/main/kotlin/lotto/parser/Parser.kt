package lotto.parser

import lotto.validator.InputValidator

object InputParser {
    fun toInt(input: String): Int {
        InputValidator.validateNumericInput(input)
        return input.toInt()
    }

    fun toLong(input: String): Long {
        InputValidator.validateNumericInput(input)
        return input.toLong()
    }

    fun toIntList(input: String): List<Int> {
        InputValidator.validateCommasSeparatedInput(input)
        return input.split(",").map { it.toInt() }
    }

}