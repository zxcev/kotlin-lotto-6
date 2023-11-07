package lotto.domain.lotto

import lotto.controller.dto.input.CreateWinningLottoDto
import lotto.controller.dto.output.LottosDrawDto
import java.util.*

class WinningLotto(
    numbers: List<Int>,
    val bonusNumber: Int,
) : Lotto(numbers) {

    private fun hasBonusNumber(lotto: Lotto) = lotto.numbers.contains(bonusNumber)

    private fun containsSize(lotto: Lotto) = lotto.numbers.count { numbers.contains(it) }

    fun drawLottos(lottos: Lottos): LottosDrawDto {
        val prizeCounter = createPrizeCounter()
        _drawLottos(lottos, prizeCounter)

        return LottosDrawDto(
            prizeCounter[LottoPrize.FIRST]!!,
            prizeCounter[LottoPrize.SECOND]!!,
            prizeCounter[LottoPrize.THIRD]!!,
            prizeCounter[LottoPrize.FOURTH]!!,
            prizeCounter[LottoPrize.FIFTH]!!,
            1.0,
        )
    }

    fun _drawLottos(lottos: Lottos, prizeMap: EnumMap<LottoPrize, Int>) {
        if (lottos.isEmpty()) {
            return
        }
        val lotto = lottos.next()
        val prize = drawLotto(lotto)
        prizeMap[prize] = prizeMap[prize]!! + 1
        _drawLottos(lottos, prizeMap)
    }

    private fun createPrizeCounter(): EnumMap<LottoPrize, Int> {
        val mp = EnumMap<LottoPrize, Int>(LottoPrize::class.java)
        LottoPrize.entries.forEach { mp[it] = 0 }
        return mp
    }

    private fun drawLotto(lotto: Lotto): LottoPrize {
        val hasBonusNumber = lotto.contains(bonusNumber)
        val matchedCount = lotto.countMathcedNumbers(numbers)
        return LottoPrize.of(matchedCount, hasBonusNumber)
    }

    companion object {
        fun from(dto: CreateWinningLottoDto) =
            WinningLotto(dto.numbers, dto.bonusNumber)
    }
}