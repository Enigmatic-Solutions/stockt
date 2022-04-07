package stock.app.data.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import stock.app.data.db.IssueDao
import stock.app.data.db.StockDao
import stock.app.data.db.StockDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun getDB(@ApplicationContext  context: Context):StockDatabase
    {
        return StockDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun getStockDao(db:StockDatabase):StockDao
    {
        return db.stockdao
    }

    @Singleton
    @Provides
    fun getIssueDao(db:StockDatabase):IssueDao
    {
        return db.issuedao
    }

}