package pl.nepapp.usecases.combined.impl

import pl.nepapp.usecases.combined.CombinedUseCase

class CombinedUseCaseImpl: CombinedUseCase {
    override suspend fun invoke(): String {
        return "success"
    }
}