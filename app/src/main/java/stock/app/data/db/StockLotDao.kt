package stock.app.data.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StockLotDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStock(stkLot: StockLot)


    @Query("select * from StockLot")
    suspend fun getAllStockItems(): List<StockLot>

}