package lotto.validator

object InputValidator {

    private val REGEX = Regex("^(\\d+,)+\\d+$")
    fun validateCommasSeparatedInput(input: String) {
        require(REGEX.matches(input)) {
            "입력은 1,2,3,4,5,6 형태로 이루어져야 합니다."
        }
    }

    fun validateNumericInput(input: String) {
        require(input.all { it.isDigit() }) {
            "입력은 반드시 숫자로 이루어져야 합니다."
        }
    }

    fun validateAmountUnit(amount: Long) {
        require(amount % 1000 == 0L) { "구매 금액은 1000원 단위로 나누어 떨어져야 합니다." }
    }
}