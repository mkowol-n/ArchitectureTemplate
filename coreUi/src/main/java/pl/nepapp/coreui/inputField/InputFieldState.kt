package pl.nepapp.coreui.inputField


data class InputFieldState(
    val value: String,
    val validator: InputFieldValidator = InputFieldValidator.Valid,
) {
    val isValidAndNotBlank = validator is InputFieldValidator.Valid && value.isNotBlank()

    companion object {
        val EMPTY = InputFieldState(
            value = "",
            validator = InputFieldValidator.Valid
        )
    }
}

sealed class InputFieldValidator {
    data object Valid : InputFieldValidator()
    data class Invalid(val errorMessage: String) : InputFieldValidator()
}