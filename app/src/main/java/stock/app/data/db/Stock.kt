package stock.app.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Stock(
    @PrimaryKey(autoGenerate = true)
    var stockId:Int,
     var itemName:String?=null,
     var stockBal:Int?=null,
     var itemImage:String?=null
)



data class LotInventory(
    var itemName:String?=null,
    var lotId:Int,
    var lotQty:Int?=null,
    var lotBal:Int?=null,
    var itemImage:String?=null
)