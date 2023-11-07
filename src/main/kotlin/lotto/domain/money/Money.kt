package lotto.domain.money

class Money(private val amount: Long) {

    init {
        validateAmount(amount)
    }


    fun isLessThan(other: Money) = amount < other.amount

    fun decreased(other: Money) = Money(amount - other.amount)

    fun increased(other: Money) = Money(amount + other.amount)

    //    override operator plus() {
//
//    }
//
    fun multiplied(x: Int) = Money(amount * x)
    fun toDouble() = amount.toDouble()

    companion object {

        fun from(amount: Long) = Money(amount)
        fun validateAmount(amount: Long) {
            require(amount >= MIN_AMOUNT) { "Money의 최소 금액은 0입니다." }
        }


        fun zero() = Money(0)


        private const val MIN_AMOUNT = 0
    }
}