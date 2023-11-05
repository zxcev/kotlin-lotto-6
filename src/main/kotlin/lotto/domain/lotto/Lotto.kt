package lotto.domain.lotto

import lotto.domain.money.Money

class Lotto(val numbers: List<Int>) {
    fun clone() = Lotto(numbers.map { it })

    init {
        require(numbers.size == NUMBERS_LENGTH)
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val NUMBERS_LENGTH = 6
        val PRICE = Money(1_000)
    }
}
