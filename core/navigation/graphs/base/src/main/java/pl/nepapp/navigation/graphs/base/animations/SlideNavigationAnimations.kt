package pl.nepapp.navigation.graphs.base.animations

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.animation.core.spring
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.ui.unit.IntOffset

val EnterSlideInHorizontally =
    slideInHorizontally(
        initialOffsetX = { it }, animationSpec = spring(
            stiffness = Spring.StiffnessVeryLow,
            visibilityThreshold = IntOffset.VisibilityThreshold,
        )
    )


val ExitSlideOutHorizontally =
    slideOutHorizontally(
        targetOffsetX = { -it }, animationSpec = spring(
            stiffness = Spring.StiffnessVeryLow,
            visibilityThreshold = IntOffset.VisibilityThreshold
        )
    )


val PopExitSlideOutHorizontally =
    slideOutHorizontally(
        targetOffsetX = { it }, animationSpec = spring(
            stiffness = Spring.StiffnessVeryLow,
            visibilityThreshold = IntOffset.VisibilityThreshold
        )
    )


val PopExitSlideInHorizontally =
    slideInHorizontally(
        initialOffsetX = { -it }, animationSpec = spring(
            stiffness = Spring.StiffnessVeryLow,
            visibilityThreshold = IntOffset.VisibilityThreshold
        )
    )
