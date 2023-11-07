package lotto.service

import lotto.controller.dto.input.CreateWalletDto
import lotto.controller.dto.input.CreateWinningLottoDto
import lotto.controller.dto.output.LottosDrawDto
import lotto.controller.dto.output.LottosDto
import lotto.domain.lotto.LottoDrawer
import lotto.domain.lotto.LottoStore
import lotto.domain.lotto.Lottos
import lotto.domain.lotto.WinningLotto
import lotto.repository.LottoRepository

class LottoService(
    private val lottoStore: LottoStore,
    private val lottoRepository: LottoRepository,
) {
    fun buyLottos(dto: CreateWalletDto): LottosDto {
        val wallet = dto.toWallet()
        val lottos = lottoStore.buyUntilOutOfMoney(wallet)
        val copiedLottos = lottos.clone()
        lottoRepository.saveAll(lottos)
        return LottosDto.from(copiedLottos)
    }

    fun drawLottos(dto: CreateWinningLottoDto): LottosDrawDto {
        val lottos = Lottos(lottoRepository.findAll())
        val winningLotto = WinningLotto(dto.numbers, dto.bonusNumber)
        val lottoDrawer = LottoDrawer(winningLotto)

        return lottoDrawer.draw(lottos)
    }
}