package ru.alexbox.repository

interface IRepository<T> {
    suspend fun getData(word: String) : T
}