package lotto.domain.lotto

import lotto.domain.money.Money

enum class LottoPrize(
    val prize: Money,
    private val matchCount: Int,
    private val hasBonusNumber: Boolean,
) {
    FIRST(Money(2_000_000_000), 6, false),
    SECOND(Money(30_000_000), 5, true),
    THIRD(Money(1_500_000), 5, false),
    FOURTH(Money(50_000), 4, false),
    FIFTH(Money(5_000), 3, false),
    NONE(Money(0), 0, false);

    companion object {

        private val lottoPrizes = entries.toList()

        fun of(matchCount: Int, hasBonusNumber: Boolean) =
            if (hasBonusNumber && matchCount == SECOND.matchCount) {
                SECOND
            } else {
                lottoPrizes
                    .firstOrNull { it.matchCount == matchCount }
                    ?: NONE
            }
    }

}