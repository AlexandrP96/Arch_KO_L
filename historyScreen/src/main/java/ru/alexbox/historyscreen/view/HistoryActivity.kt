package ru.alexbox.historyscreen.view

import android.os.Bundle
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_history.*
import org.koin.android.scope.currentScope
import ru.alexbox.core.BaseActivity
import ru.alexbox.historyscreen.R
import ru.alexbox.historyscreen.injectDependencies
import ru.alexbox.model.AppState
import ru.alexbox.model.userData.DataModel

class HistoryActivity : BaseActivity<AppState, HistoryInteractor>() {

    override val layoutRes = R.layout.activity_history
    override lateinit var model: HistoryViewModel
    private val adapter: HistoryAdapter by lazy { HistoryAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        initViewModel()
        initViews()
    }

    override fun setDataToAdapter(data: List<DataModel>) {
        adapter.setData(data)
    }

    override fun onResume() {
        super.onResume()
        model.getData("", false)
    }

    private fun initViews() {
        history_recycler.adapter = adapter
    }

    private fun initViewModel() {
        check(history_recycler.adapter == null) { "The ViewModel should be initialised first" }
        injectDependencies()
        val viewModel: HistoryViewModel by currentScope.inject()
        model = viewModel
        model.subscribe().observe(this@HistoryActivity, Observer<AppState> { renderData(it) })
    }
}