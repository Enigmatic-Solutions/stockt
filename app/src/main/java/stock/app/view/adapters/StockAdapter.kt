package stock.app.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import hilt_aggregated_deps._dagger_hilt_android_internal_modules_ApplicationContextModule
import stock.app.R
import stock.app.data.db.Stock
import javax.inject.Inject


class StockAdapter @Inject constructor(var item: List<Stock>):RecyclerView.Adapter<StockAdapter.StockViewHolder>() {
 //private lateinit
//private lateinit var item:ArrayList<Stock>
    private lateinit var _context:android.content.Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockViewHolder {
      val view=LayoutInflater.from(parent.context).inflate(R.layout.stock_item,parent,false)

        _context=parent.context





        return StockViewHolder(view)


    }

    fun setData(data: List<Stock>) {
        item = data
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: StockViewHolder, position: Int) {

        val ItemsViewModel = item[position]

        holder.tvitem.text=ItemsViewModel.itemName
        holder.tvbalance.text=ItemsViewModel.stockBal.toString()

        holder.tvitem.setOnClickListener{
            Toast.makeText(_context,"Hello",50).show()
        }



    }

    override fun getItemCount(): Int {
        return item.size
    }

    inner class StockViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val tvitem: TextView = itemView.findViewById(R.id.tvName)
        val tvbalance: TextView = itemView.findViewById(R.id.tvQty)




    }


}