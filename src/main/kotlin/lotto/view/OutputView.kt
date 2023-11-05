package lotto.view

import lotto.controller.dto.output.LottoDto
import lotto.controller.dto.output.LottosDto

class OutputView {
    fun printLottos(lottosDto: LottosDto) {
        val rendered = lottosDto
            .lottos
            .joinToString("\n") {
                renderLotto(it)
            }

        println("\n${lottosDto.lottos.size}개를 구매했습니다.")
        println(rendered)
    }

    private fun renderLotto(lottoDto: LottoDto) =
        "[${lottoDto.numbers.joinToString(", ")}]"

}