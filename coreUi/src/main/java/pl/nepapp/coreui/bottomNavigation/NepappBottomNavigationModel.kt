package pl.nepapp.coreui.bottomNavigation

import pl.nepapp.coreui.Displaytype

data class NepappBottomNavigationModel<T> (
    val item: T,
    val displaytype: Displaytype
)