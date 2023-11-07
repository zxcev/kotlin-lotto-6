package lotto.domain.lotto.validator

import lotto.domain.lotto.Lotto

object LottoValidator {
    fun validateBonusNumber(bonusNumber: Int) {

    }

    fun validateLottoNumbers(lottoNumbers: List<Int>) {

    }

    fun validateDuplication(lottoNumbers: List<Int>) {
        if (lottoNumbers.distinct().size != Lotto.NUMBERS_LENGTH) {
            throw IllegalArgumentException("로또 번호는 6자리여야 합니다")
        }
    }
}
