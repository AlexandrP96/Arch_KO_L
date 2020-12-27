package ru.alexbox.repository

interface IDataSource<T> {
    suspend fun getData(word: String): T
}