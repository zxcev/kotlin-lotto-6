package lotto.domain.lotto

import lotto.domain.lotto.validator.LottoValidator
import lotto.domain.money.Money

open class Lotto(val numbers: List<Int>) {

    init {
        LottoValidator.validateDuplication(numbers)
    }

    fun contains(number: Int) =
        numbers.contains(number)

    fun countMathcedNumbers(numbers: List<Int>) =
        this.numbers.count { numbers.contains(it) }

    fun clone() = Lotto(
        numbers
            .sorted()
            .map { it },
    )

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val NUMBERS_LENGTH = 6
        val PRICE = Money(1_000)
    }
}
