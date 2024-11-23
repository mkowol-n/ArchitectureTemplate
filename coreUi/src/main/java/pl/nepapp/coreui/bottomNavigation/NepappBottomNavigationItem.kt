package pl.nepapp.coreui.bottomNavigation

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import pl.nepapp.coreui.DisplayType

@Composable
internal fun <T> NepappBottomNavigationItem(
    item: NepappBottomNavigationModel<T>,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onClick: (T) -> Unit
) {
    val backgroundColor by animateColorAsState(
        if (isSelected) Color.Cyan else Color.White,
        label = ""
    )
    Box(modifier = modifier
        .background(color = backgroundColor)
        .clickable {
            onClick(item.item)
        }
        .fillMaxSize(), contentAlignment = Alignment.Center) {
        if (item.displaytype is DisplayType.Text) {
            Text(item.displaytype.text)
        }
    }
}