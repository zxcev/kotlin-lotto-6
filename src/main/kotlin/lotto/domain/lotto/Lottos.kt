package lotto.domain.lotto

class Lottos(lottos: List<Lotto>) {
    private val _lottos: ArrayDeque<Lotto> = ArrayDeque(lottos)

    fun next() = _lottos.removeFirst()
    fun isEmpty() = _lottos.size == 0
    fun isNotEmpty() = !isEmpty()
    fun clone() = _lottos.map { it.clone() }

    companion object {
    }
}
