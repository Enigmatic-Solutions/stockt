package stock.app.data.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StockDao {

@Insert (onConflict = OnConflictStrategy.REPLACE)
suspend fun insertStock(stock: Stock)


@Query("select * from Stock")
suspend fun getAllStockItems(): List<Stock>


@Query("select * from stock,StockLot where Stock.stockId=StockLot.stockId")
suspend fun getLotInventory(): List<LotInventory>

}