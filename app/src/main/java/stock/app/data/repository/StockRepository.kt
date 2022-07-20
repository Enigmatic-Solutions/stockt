package stock.app.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import stock.app.data.db.LotInventory
import stock.app.data.db.StockDao
import stock.app.data.db.Stock
import javax.inject.Inject


class StockRepository @Inject constructor (private val dao:StockDao) {


    suspend fun Insert(stock: Stock){
         dao.insertStock(stock)
    }

  suspend fun getAllStock(): List<Stock> {

        return dao.getAllStockItems()
    }

    suspend fun getLotInventory(): List<LotInventory> {

        return dao.getLotInventory()
    }



}