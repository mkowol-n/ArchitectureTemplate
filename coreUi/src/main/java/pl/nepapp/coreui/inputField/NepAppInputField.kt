package pl.nepapp.coreui.inputField

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun NepAppInputField(
    label: String,
    modifier: Modifier,
    inputFieldState: InputFieldState,
    onChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    enabled: Boolean,
) {
    BaseInputField(
        label= label,
        modifier = modifier,
        inputFieldState = inputFieldState,
        onChange = onChange,
        enabled = enabled,
        singleLine = true,
        visualTransformation = VisualTransformation.None,
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions
    )
}