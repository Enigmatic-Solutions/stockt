package stock.app.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_stockview)
        binding= ActivityStockviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

       //lateinit var data: <List<Stock>>

        mstockViewModel = ViewModelProvider(this).get(StockViewModel::class.java)

        //lateinit var stktest: MutableLiveData<List<Stock>>

        //var stktest:List<Stock> = mstockViewModel.getRecordObserver():List<Stock>

        val linearLayoutManager = LinearLayoutManager(
            this, RecyclerView.VERTICAL,false)
        binding.recyclestock.layoutManager = linearLayoutManager


        //binding.textView.text= binding.recyclestock.adapter?.itemCount.toString()

        mstockViewModel.getRecordObserver().observe(this, androidx.lifecycle.Observer { Stock ->
            //binding.recyclestock.adapter =StockAdapter(Stock)
            StockAdapter(Stock as List<Stock>)


        })




            //adapter.setListData(mstockViewModel.getAllStock())



        //mstockViewModel.getRecordObserver().observe(this, androidx.lifecycle.Observer { adapter.setListData(ArrayList(it)) })
        //binding.recyclestock.layoutManager=LinearLayoutManager(this)



    }
}