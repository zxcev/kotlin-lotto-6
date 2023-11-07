package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.controller.dto.builder.CreateWinningLottoDtoBuilder
import lotto.controller.dto.input.CreateWalletDto
import lotto.controller.dto.input.CreateWinningLottoDto
import lotto.parser.InputParser

class InputView {
    fun inputCreateWalletDto(): CreateWalletDto {
        println("구입금액을 입력해 주세요.")
        try {
            return CreateWalletDto.from(readLine())
        } catch (e: Exception) {
            printErr(e.message!!)
            return inputCreateWalletDto()
        }
    }


    fun inputCreateWinningLottoDto(): CreateWinningLottoDto {
        val builder = CreateWinningLottoDtoBuilder.builder()
        inputLottoNumbers(builder)
        inputBonusNumber(builder)
        return builder.build()
    }

    private fun inputLottoNumbers(builder: CreateWinningLottoDtoBuilder) {
        println("\n당첨 번호를 입력해 주세요.")
        try {
            val lottoNumbers = InputParser.toIntList(readLine())
            builder.lottoNumbers(lottoNumbers)
        } catch (e: IllegalArgumentException) {
            printErr(e.message!!)
            inputLottoNumbers(builder)
        }
    }

    private fun inputBonusNumber(builder: CreateWinningLottoDtoBuilder) {
        println("\n보너스 번호를 입력해 주세요.")
        try {
            val bonusNumber = InputParser.toInt(readLine())
            builder.bonusNumber(bonusNumber)
        } catch (e: IllegalArgumentException) {
            printErr(e.message!!)
            inputBonusNumber(builder)
        }
    }

    private fun printErr(msg: String) {
        println("[ERROR] $msg")
    }

    private fun readLine() =
        Console.readLine().trim()
}