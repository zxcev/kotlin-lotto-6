package lotto.domain.money

class Money(private var amount: Long) {

    init {
        validateAmount(amount)
    }

    fun isLessThan(other: Money) = amount < other.amount

    fun decreased(other: Money) = Money(amount - other.amount)

    fun increased(other: Money) = Money(amount + other.amount)

    companion object {
        fun validateAmount(amount: Long) {
            require(amount >= MIN_AMOUNT) { "Money의 최소 금액은 0입니다." }
        }

        private const val MIN_AMOUNT = 0
    }
}