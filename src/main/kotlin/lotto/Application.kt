package lotto

import lotto.controller.LottoController
import lotto.domain.lotto.LottoStore
import lotto.domain.lotto.RandomLottoGenerator
import lotto.repository.LottoRepository
import lotto.service.LottoService
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val lottoRepository = LottoRepository()
    val lottoGenerator = RandomLottoGenerator()
    val lottoStore = LottoStore(lottoGenerator)
    val lottoService = LottoService(lottoStore, lottoRepository)

    val lottoController = LottoController(
        inputView,
        outputView,
        lottoService,
    )

    lottoController.run()
}
