package lotto.controller.dto.output

data class LottosDrawDto(
    val firstCount: Int,
    val secondCount: Int,
    val thirdCount: Int,
    val fourthCount: Int,
    val fifthCount: Int,
    val returnRatio: Double,
)
