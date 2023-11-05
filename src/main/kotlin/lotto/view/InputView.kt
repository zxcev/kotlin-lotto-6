package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.controller.dto.input.CreateWalletDto

class InputView {
    fun inputCreateWalletDto(): CreateWalletDto {
        println("구입금액을 입력해 주세요.")
        return CreateWalletDto.from(readLine())
    }

    private fun readLine() =
        Console.readLine().trim()
}