package pl.nepapp.coreui.bottomNavigation

import pl.nepapp.coreui.DisplayType

data class NepappBottomNavigationModel<T> (
    val item: T,
    val displaytype: DisplayType
)