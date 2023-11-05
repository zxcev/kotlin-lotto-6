package lotto.controller.dto.output

import lotto.domain.lotto.Lotto

data class LottoDto(
    val numbers: List<Int>,
) {
    companion object {
        fun from(lotto: Lotto) = LottoDto(lotto.numbers)
    }
}