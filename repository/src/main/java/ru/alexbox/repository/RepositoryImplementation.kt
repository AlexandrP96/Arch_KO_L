package ru.alexbox.repository

import ru.alexbox.model.dto.SearchResultDto

class RepositoryImplementation(private val dataSource: IDataSource<List<SearchResultDto>>) :
IRepository<List<SearchResultDto>> {
    override suspend fun getData(word: String): List<SearchResultDto> {
        return dataSource.getData(word)
    }
}