package lotto.validator

object InputValidator {
    fun validateNumericInput(input: String) {
        require(input.all { it.isDigit() }) {
            "입력은 반드시 숫자로 이루어져야 합니다."
        }
    }
}