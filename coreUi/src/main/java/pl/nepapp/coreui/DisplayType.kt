package pl.nepapp.coreui

import androidx.annotation.StringRes

sealed class DisplayType {
    data class Text(val text: String) : DisplayType()
    data class Icon(@StringRes val icon: Int) : DisplayType()
    data class TextAndIcon(@StringRes val icon: Int, val text: String) : DisplayType()
}