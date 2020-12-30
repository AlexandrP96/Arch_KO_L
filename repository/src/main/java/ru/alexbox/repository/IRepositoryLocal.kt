package ru.alexbox.repository

import ru.alexbox.model.AppState

interface IRepositoryLocal<T> : IRepository<T> {
    suspend fun saveToDb(appState: AppState)
}