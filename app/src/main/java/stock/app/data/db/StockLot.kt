package stock.app.data.db

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(

    foreignKeys = [
        ForeignKey(entity = Stock::class,
            parentColumns = ["stockId"],
            childColumns = ["stockId"],
            onDelete = ForeignKey.CASCADE)]
)
data class StockLot(
    @PrimaryKey
    var lotId:String,
    var stockId:Int,
    var lotQty:Int,
    var lotBal:Int,
)

