package ru.alexbox.historyscreen.view

import ru.alexbox.arch_gb_l.utils.mapSearchResultToResult
import ru.alexbox.core.IInteractor
import ru.alexbox.model.AppState
import ru.alexbox.model.dto.SearchResultDto
import ru.alexbox.repository.IRepository
import ru.alexbox.repository.IRepositoryLocal

class HistoryInteractor(
    private val repositoryRemote: IRepository<List<SearchResultDto>>,
    private val repositoryLocal: IRepositoryLocal<List<SearchResultDto>>
) : IInteractor<AppState> {
    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            mapSearchResultToResult(
                if (fromRemoteSource) {
                    repositoryRemote
                } else {
                    repositoryLocal
                }.getData(word)
            )
        )
    }
}