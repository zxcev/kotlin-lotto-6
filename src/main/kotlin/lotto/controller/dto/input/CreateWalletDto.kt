package lotto.controller.dto.input

import lotto.domain.money.Money
import lotto.domain.money.Wallet
import lotto.validator.InputValidator

class CreateWalletDto(val amount: Long) {

    fun toWallet() = Wallet(
        Money(amount),
    )

    companion object {
        fun from(input: String): CreateWalletDto {
            InputValidator.validateNumericInput(input)
            return CreateWalletDto(input.toLong())
        }
    }

}