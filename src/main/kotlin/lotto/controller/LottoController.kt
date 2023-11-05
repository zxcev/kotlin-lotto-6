package lotto.controller

import lotto.service.LottoService
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val lottoService: LottoService,
) {
    fun run() {
        buyLottos()
        drawLottos()
    }

    private fun buyLottos() {
        val inputDto = inputView.inputCreateWalletDto()
        val lottosDto = lottoService.buyLottos(inputDto)
        outputView.printLottos(lottosDto)
    }

    private fun drawLottos() {

    }
}