package lotto.view

import lotto.controller.dto.output.LottoDto
import lotto.controller.dto.output.LottosDrawDto
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

    fun printLottosDrawStatistic(lottosDrawDto: LottosDrawDto) {
        System.out.printf(
            """
            3개 일치 (5,000원) - %d개
            4개 일치 (50,000원) - %d개
            5개 일치 (1,500,000원) - %d개
            5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
            6개 일치 (2,000,000,000원) - %d개
            총 수익률은 %.1f%%입니다.
        """.trimIndent(),
            lottosDrawDto.fifthCount,
            lottosDrawDto.fourthCount,
            lottosDrawDto.thirdCount,
            lottosDrawDto.secondCount,
            lottosDrawDto.firstCount,
            lottosDrawDto.returnRatio,
        )
    }

    private fun renderLotto(lottoDto: LottoDto) =
        "[${lottoDto.numbers.joinToString(", ")}]"


}