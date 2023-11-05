package lotto.controller.dto.output

import lotto.domain.lotto.Lotto

data class LottosDto(
    val lottos: List<LottoDto>,
) {
    companion object {
        fun from(lottos: List<Lotto>) =
            LottosDto(lottos.map { LottoDto.from(it) })
    }

}
