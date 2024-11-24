package pl.nepapp.coreui.inputField

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
internal fun BaseInputField(
    label: String,
    modifier: Modifier,
    inputFieldState: InputFieldState,
    onChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    enabled: Boolean,
    singleLine: Boolean,
    visualTransformation: VisualTransformation
) {

    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomStart
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = label)
            Spacer(modifier = Modifier.height(10.dp))

            BasicTextField(
                modifier = Modifier.fillMaxWidth(),
                value = inputFieldState.value,
                onValueChange = onChange,
                cursorBrush = SolidColor(Color.Red),
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                enabled = enabled,
                singleLine = singleLine,
                visualTransformation = visualTransformation,
            ) {
                Box(
                    contentAlignment = Alignment.BottomStart
                ) {
                    Column(
                        modifier = Modifier
                            .animateContentSize()
                    ) {
                        InnerTextField(
                            innerTextField = it,
                        )
                        AnimatedContent(
                            inputFieldState.validator,
                            modifier = Modifier.fillMaxWidth(), label = "",
                            transitionSpec = {
                                (fadeIn() + expandVertically()).togetherWith(fadeOut() + shrinkVertically())
                            }
                        ) {
                            if (it is InputFieldValidator.Invalid) {
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(it.errorMessage, color = Color.Red)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun InnerTextField(
    modifier: Modifier = Modifier,
    innerTextField: @Composable () -> Unit,
) {
    Row(
        modifier = modifier
            .height(60.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(18.dp))
        Box(modifier = Modifier.weight(1f)) {
            innerTextField()
        }
        Spacer(modifier = Modifier.width(18.dp))
    }
}