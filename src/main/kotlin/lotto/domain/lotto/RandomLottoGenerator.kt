package lotto.domain.lotto

import camp.nextstep.edu.missionutils.Randoms

class RandomLottoGenerator : LottoGenerator {
    override fun generate(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(
            Lotto.MIN_NUMBER,
            Lotto.MAX_NUMBER,
            Lotto.NUMBERS_LENGTH
        )
        return Lotto(numbers)
    }
}