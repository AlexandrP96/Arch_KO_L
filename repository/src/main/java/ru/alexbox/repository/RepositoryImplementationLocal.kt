package ru.alexbox.repository

import ru.alexbox.model.AppState
import ru.alexbox.model.dto.SearchResultDto

class RepositoryImplementationLocal(private val dataSource: IDataSourceLocal<List<SearchResultDto>>) :
IRepositoryLocal<List<SearchResultDto>> {

    override suspend fun getData(word: String): List<SearchResultDto> {
        return dataSource.getData(word)
    }

    override suspend fun saveToDb(appState: AppState) {
        dataSource.saveToDb(appState)
    }
}