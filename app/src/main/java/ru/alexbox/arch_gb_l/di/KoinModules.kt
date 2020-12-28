package ru.alexbox.arch_gb_l.di

import androidx.room.Room
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.alexbox.arch_gb_l.view.MainActivity
import ru.alexbox.arch_gb_l.view.main.MainInteractor
import ru.alexbox.arch_gb_l.view.main.MainViewModel
import ru.alexbox.model.dto.SearchResultDto
import ru.alexbox.repository.*
import ru.alexbox.repository.room.HistoryDataBase


fun injectDependencies() = loadModules

private val loadModules by lazy {
    loadKoinModules(listOf(application, mainScreen))
}

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<IRepository<List<SearchResultDto>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<IRepositoryLocal<List<SearchResultDto>>> {
        RepositoryImplementationLocal(RoomDataBaseImplementation(get()))
    }
}

val mainScreen = module {
    scope(named<MainActivity>()) {
        scoped { MainInteractor(get(), get()) }
        viewModel { MainViewModel(get()) }
    }
}