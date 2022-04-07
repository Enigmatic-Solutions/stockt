package stock.app.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import stock.app.data.repository.IssueRepository
import stock.app.data.repository.StockRepository
import javax.inject.Inject


@HiltViewModel
class IssueViewModel @Inject internal constructor (private val issueRepository:  IssueRepository) : ViewModel() {




}