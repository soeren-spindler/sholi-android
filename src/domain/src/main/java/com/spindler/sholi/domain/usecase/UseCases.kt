package com.spindler.sholi.domain.usecase

import kotlinx.coroutines.flow.Flow

interface UseCase<Input, Output> {
    fun invoke(input: Input): Flow<Output>
}

interface UseCaseOutputOnly<Output> {
    fun invoke(): Flow<Output>
}
