package pl.nepapp.core.common

import org.koin.core.annotation.Named
import org.koin.core.annotation.Scope
import org.koin.core.annotation.Scoped
import kotlin.reflect.KClass

const val mainScope = "NepAppMainScope"

class FinalScope

@Scope
class SomeOtherScope