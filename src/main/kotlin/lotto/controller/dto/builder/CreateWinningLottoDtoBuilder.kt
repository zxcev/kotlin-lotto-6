package lotto.controller.dto.builder

import lotto.controller.dto.input.CreateWinningLottoDto
import lotto.domain.lotto.validator.LottoValidator

class CreateWinningLottoDtoBuilder private constructor(
    private var lottoNumbers: List<Int>? = null,
    private var bonusNumber: Int = 0,
    private var isLottoNumbersSet: Boolean = false,
    private var isBonusNumberSet: Boolean = false,
) {

    fun lottoNumbers(lottoNumbersInput: List<Int>): CreateWinningLottoDtoBuilder {
        LottoValidator.validateLottoNumbers(lottoNumbersInput)
        this.lottoNumbers = lottoNumbersInput
        isLottoNumbersSet = true
        return this
    }

    fun bonusNumber(bonusNumber: Int): CreateWinningLottoDtoBuilder {
        LottoValidator.validateBonusNumber(bonusNumber)
        this.bonusNumber = bonusNumber
        isBonusNumberSet = true
        return this
    }

    fun build(): CreateWinningLottoDto {
        validateIsAllFieldsSet()
        return CreateWinningLottoDto(lottoNumbers!!, bonusNumber)
    }

    private val isAllFieldsSet: Boolean
        get() = isLottoNumbersSet && isBonusNumberSet

    private fun validateIsAllFieldsSet() {
        require(isAllFieldsSet) {
            "반드시 모든 필드가 set 되어야 합니다."
        }
    }

    companion object {
        fun builder() = CreateWinningLottoDtoBuilder()

    }
}