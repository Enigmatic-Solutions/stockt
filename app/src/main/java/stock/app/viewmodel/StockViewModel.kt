package stock.app.viewmodel

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import stock.app.data.db.LotInventory
import stock.app.data.db.Stock
import stock.app.data.repository.StockRepository
import javax.inject.Inject

@HiltViewModel
class StockViewModel @Inject internal constructor (private val stockRepository:StockRepository) : ViewModel() {

    //private var stockRepository:StockRepository
    private lateinit var allstock:MutableLiveData<List<Stock>>
    private lateinit var lotInventory:MutableLiveData<List<LotInventory>>



    init{
        allstock= MutableLiveData()
        lotInventory= MutableLiveData()
    }


    fun InsertStock(stk: Stock){

        viewModelScope.launch(Dispatchers.IO){
            stockRepository.Insert(stk)
        }

    }


    fun getAllStock(){
        viewModelScope.launch(Dispatchers.IO){
            val list=stockRepository.getAllStock()
            allstock.postValue(list)
        }
    }

    fun getLotInventory(){
        viewModelScope.launch(Dispatchers.IO){
            val list=stockRepository.getLotInventory()
            lotInventory.postValue(list)
        }
    }



    fun getRecordObserver():MutableLiveData<List<Stock>>{
        return allstock
    }

    fun getDataset():MutableLiveData<List<LotInventory>>{
        return lotInventory
    }


}