package lotto.repository

import lotto.domain.lotto.Lotto
import lotto.domain.lotto.Lottos

class LottoRepository(
    private val storage: MutableList<Lotto> = mutableListOf(),
) {

    fun findAll() = storage.map { it.clone() }

    fun saveAll(lottos: Lottos) {
        while (lottos.isNotEmpty()) {
            storage.add(lottos.next())
        }
    }
}