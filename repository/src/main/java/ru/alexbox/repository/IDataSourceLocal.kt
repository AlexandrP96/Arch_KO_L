package ru.alexbox.repository

import ru.alexbox.model.AppState

interface IDataSourceLocal<T> : IDataSource<T> {
    suspend fun saveToDb(appState: AppState)
}