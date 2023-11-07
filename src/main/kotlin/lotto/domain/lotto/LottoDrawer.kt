package lotto.domain.lotto

import lotto.controller.dto.output.LottosDrawDto
import lotto.domain.money.Money
import java.util.*

class LottoDrawer(
    private val winningLotto: WinningLotto,
    private val mp: EnumMap<LottoPrize, Int> = EnumMap<LottoPrize, Int>(LottoPrize::class.java),
    private var spent: Money = Money.zero(),
    private var earning: Money = Money.zero(),
) {

    init {
        LottoPrize.entries.forEach { mp[it] = 0 }
    }

    fun draw(lottos: Lottos): LottosDrawDto {
        _draw(lottos)

        return LottosDrawDto(
            mp[LottoPrize.FIRST]!!,
            mp[LottoPrize.SECOND]!!,
            mp[LottoPrize.THIRD]!!,
            mp[LottoPrize.FOURTH]!!,
            mp[LottoPrize.FIFTH]!!,
            returnOnRate(),
        )
    }

    private fun _draw(lottos: Lottos) {
        if (lottos.isEmpty()) return

        val lotto = lottos.next()
        val matchingCount = lotto.countMathcedNumbers(winningLotto.numbers)
        val hasBonusNumber = lotto.contains(winningLotto.bonusNumber)
        val prize = LottoPrize.of(matchingCount, hasBonusNumber)
        mp[prize] = mp[prize]!! + 1
        earning = earning.increased(prize.prize)
        spent = spent.increased(Lotto.PRICE)

        _draw(lottos)
    }

    private fun returnOnRate(): Double {
        val v = earning.toDouble() / spent.toDouble() * 100
        return Math.round(v * 10.0) / 10.0
    }
}