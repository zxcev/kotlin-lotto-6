package lotto.service

import lotto.controller.dto.input.CreateWalletDto
import lotto.controller.dto.output.LottosDto
import lotto.domain.lotto.LottoStore
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
}