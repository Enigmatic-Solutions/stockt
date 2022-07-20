package stock.app.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities=[Stock::class, Issue::class,StockLot::class],version=1,exportSchema = false)
abstract class StockDatabase: RoomDatabase() {


    abstract val stockdao:StockDao
    abstract val issuedao:IssueDao
    abstract val stockLotDao:StockLotDao

    companion object {
        @Volatile
        private var INSTANCE:StockDatabase?=null


        fun getInstance (context: Context):StockDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance=
                    Room.databaseBuilder(context.applicationContext,StockDatabase::class.java,"stockDB").build()

                INSTANCE=instance
                return instance
            }
        }

    }



}