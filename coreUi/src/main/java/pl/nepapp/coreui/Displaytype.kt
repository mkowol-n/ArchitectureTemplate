package pl.nepapp.coreui

import androidx.annotation.StringRes

sealed class Displaytype {
    data class Text(val text: String) : Displaytype()
    data class Icon(@StringRes val icon: Int) : Displaytype()
    data class TextAndIcon(@StringRes val icon: Int, val text: String) : Displaytype()
}