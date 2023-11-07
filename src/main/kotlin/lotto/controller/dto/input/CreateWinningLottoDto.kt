package lotto.controller.dto.input

data class CreateWinningLottoDto(
    val numbers: List<Int>,
    val bonusNumber: Int,
) {


}