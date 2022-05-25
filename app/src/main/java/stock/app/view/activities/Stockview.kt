package stock.app.view.activities

import android.app.ProgressDialog.show
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.drawToBitmap
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import stock.app.data.db.Stock
//import org.jetbrains.anko.doAsync
import java.util.*

import stock.app.databinding.ActivityStockviewBinding
import stock.app.view.adapters.StockAdapter
import stock.app.viewmodel.StockViewModel
import java.util.Observer


@AndroidEntryPoint
class Stockview : AppCompatActivity() {

    private lateinit var mstockViewModel: StockViewModel
    private lateinit var binding: ActivityStockviewBinding

    var data=MutableLiveData<List<Stock>>()
    lateinit  var da:List<Stock>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_stockview)
        binding= ActivityStockviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mstockViewModel = ViewModelProvider(this).get(StockViewModel::class.java)

        mstockViewModel.getAllStock()

        val linearLayoutManager = LinearLayoutManager(
            this, RecyclerView.VERTICAL,false)
        binding.recyclestock.layoutManager = linearLayoutManager

            mstockViewModel.getRecordObserver().observe(this, androidx.lifecycle.Observer { Stock ->
                binding.recyclestock.adapter =StockAdapter(Stock)
            })

        binding.button.setOnClickListener{

            var stk: Stock

            stk= Stock(0,"Hello LiveData 2",50,"c\\file")

            mstockViewModel.InsertStock(stk)
        }







    }


}