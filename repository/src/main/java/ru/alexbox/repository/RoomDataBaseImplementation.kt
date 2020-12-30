package ru.alexbox.repository

import ru.alexbox.model.AppState
import ru.alexbox.model.dto.SearchResultDto
import ru.alexbox.repository.room.IHistoryDao

class RoomDataBaseImplementation(private val historyDao: IHistoryDao) : IDataSourceLocal<List<SearchResultDto>>
{
    override suspend fun getData(word: String): List<SearchResultDto> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun saveToDb(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}