package ru.alexbox.core

interface IInteractor<T> {
    suspend fun getData(word: String, fromRemoteSource: Boolean) : T
}