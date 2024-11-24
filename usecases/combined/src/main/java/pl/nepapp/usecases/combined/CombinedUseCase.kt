package pl.nepapp.usecases.combined

interface CombinedUseCase {
    suspend operator fun invoke(): String
}