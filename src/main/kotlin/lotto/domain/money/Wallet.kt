package lotto.domain.money

class Wallet(private var money: Money) {
    fun spend(other: Money) {
        this.money = money.decreased(other)
    }

    fun fill(other: Money) {
        this.money = money.increased(other)
    }

    fun canBuy(other: Money) = money.isLessThan(other)
}