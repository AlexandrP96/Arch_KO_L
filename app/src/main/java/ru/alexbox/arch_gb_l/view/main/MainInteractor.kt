package ru.alexbox.arch_gb_l.view.main

import ru.alexbox.arch_gb_l.utils.mapSearchResultToResult
import ru.alexbox.core.IInteractor
import ru.alexbox.model.AppState
import ru.alexbox.model.dto.SearchResultDto
import ru.alexbox.repository.IRepository
import ru.alexbox.repository.IRepositoryLocal

class MainInteractor(
    private val repositoryRemote: IRepository<List<SearchResultDto>>,
    private val repositoryLocal: IRepositoryLocal<List<SearchResultDto>>
) : IInteractor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(mapSearchResultToResult(repositoryRemote.getData(word)))
            repositoryLocal.saveToDb(appState)
        } else {
            appState = AppState.Success(mapSearchResultToResult(repositoryLocal.getData(word)))
        }
        return appState
    }
}
