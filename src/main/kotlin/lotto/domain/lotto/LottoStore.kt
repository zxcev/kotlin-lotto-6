package lotto.domain.lotto

import lotto.domain.money.Wallet

class LottoStore(private val lottoGenerator: LottoGenerator) {
    fun buyUntilOutOfMoney(wallet: Wallet): Lottos {
        val lottos = mutableListOf<Lotto>()
        _buyUntilOutOfMoney(lottos, wallet)
        return Lottos(lottos.toList())
    }

    private fun _buyUntilOutOfMoney(lottos: MutableList<Lotto>, wallet: Wallet) {
        if (!wallet.canBuy(Lotto.PRICE)) {
            buyLotto(lottos, wallet)
            _buyUntilOutOfMoney(lottos, wallet)
        }
    }

    private fun buyLotto(lottos: MutableList<Lotto>, wallet: Wallet) {
        wallet.spend(Lotto.PRICE)
        val lotto = lottoGenerator.generate()
        lottos.add(lotto)
    }

}