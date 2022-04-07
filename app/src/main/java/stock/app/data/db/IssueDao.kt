package stock.app.data.db

import android.database.Cursor
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface IssueDao {

    @Transaction
    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun InsertIssue(issue: Issue)


    @Query("select * from issue")
     fun getAllIssues():LiveData<List<Issue>>

    @Query("select * from issue where stockid=:id")
     fun getIssuesForItem(id:Int):LiveData<List<Issue>>

    @Query ("select * from stock,issue where stock.stockid=issue.stockId and stock.stockid=:stkid")
    fun getIssuedata (stkid:Int):Cursor


}