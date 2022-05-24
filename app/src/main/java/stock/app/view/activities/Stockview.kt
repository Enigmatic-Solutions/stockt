package stock.app.view.activities

import android.app.ProgressDialog.show
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import stock.app.data.db.Stock
import org.jetbrains.anko.doAsync
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

       //lateinit var data: <List<Stock>>

        mstockViewModel = ViewModelProvider(this).get(StockViewModel::class.java)

        //lateinit var stktest: MutableLiveData<List<Stock>>
        mstockViewModel.getAllStock()
        //var stktest:List<Stock> = mstockViewModel.getRecordObserver():List<Stock>
        var stk: Stock
        stk= Stock(0,"Test Item1",62,"//file")
        mstockViewModel.InsertStock(stk)

        val linearLayoutManager = LinearLayoutManager(
            this, RecyclerView.VERTICAL,false)
        binding.recyclestock.layoutManager = linearLayoutManager


        //binding.textView.text= binding.recyclestock.adapter?.itemCount.toString()

        try {
            mstockViewModel.getRecordObserver().observe(this, androidx.lifecycle.Observer { Stock ->
                binding.recyclestock.adapter =StockAdapter(Stock)

//                data.value = Stock
//                da = Stock!!
//                Log.d("MainActivity ", "Data Send" + data.value!!.size.toString())
//                binding.recyclestock.adapter = StockAdapter(Stock)
            })

        }catch (Ex:Exception)
        {
            //Toast.makeText(applicationContext, da[0].toString(), Toast.LENGTH_LONG).show()
            //Toast.show()

        }


    }
}