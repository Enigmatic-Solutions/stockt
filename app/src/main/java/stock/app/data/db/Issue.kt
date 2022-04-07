package stock.app.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Issue(
 var stockId:Int,
   @PrimaryKey (autoGenerate = true)
   var issueNo:Int,
   var IssueQty:Int

) {
}