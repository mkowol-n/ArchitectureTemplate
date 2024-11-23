package pl.nepapp.coreui.bottomNavigation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList

@Composable
fun <T> NepappBottomNavigation(
    items: ImmutableList<NepappBottomNavigationModel<T>>,
    modifier: Modifier = Modifier,
    selectedItem: T,
    onClick: (T) -> Unit
) {
    Row(modifier = modifier.height(60.dp)) {
        items.forEach { item ->
            NepappBottomNavigationItem(
                modifier = Modifier.weight(1f),
                item = item,
                onClick = onClick,
                isSelected = selectedItem == item
            )
        }
    }
}