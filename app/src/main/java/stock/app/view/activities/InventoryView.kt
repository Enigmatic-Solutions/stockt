package stock.app.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import stock.app.R
import stock.app.data.db.LotInventory
import stock.app.data.db.StockDatabase
import stock.app.data.db.StockLot
import stock.app.data.db.StockLotDao
import stock.app.viewmodel.StockViewModel

@AndroidEntryPoint
class InventoryView : AppCompatActivity() {


    private lateinit var mLotViewModel: StockViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inventory_view)

        val btn: Button =findViewById(R.id.button3)
        val btnadd: Button =findViewById(R.id.btnAdd4)

        btn.setOnClickListener{
            mLotViewModel = ViewModelProvider(this).get(StockViewModel::class.java)
            mLotViewModel.getLotInventory()

            var x: MutableLiveData<List<LotInventory>> = mLotViewModel.getDataset()

            var y: List<LotInventory>? = x.value


            var tv: TextView =findViewById(R.id.tvLot)

            if (y != null) {
                tv.text=y.get(0).itemName+":"+y.get(0).lotQty.toString()
            }
    }


    btnadd.setOnClickListener{
        val lotDao: StockLotDao=StockDatabase.getInstance(this).stockLotDao

        val itemlot= StockLot("454",1,25,50)


        GlobalScope.launch(Dispatchers.IO){
            lotDao.insertStock(itemlot)
        }



    }

}
}
