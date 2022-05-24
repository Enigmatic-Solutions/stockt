package stock.app.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import stock.app.R
import stock.app.data.db.Stock
import javax.inject.Inject


class StockAdapter @Inject constructor(val item: List<Stock>):RecyclerView.Adapter<StockAdapter.StockViewHolder>() {
 //private lateinit
//private lateinit var item:ArrayList<Stock>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockViewHolder {
      val view=LayoutInflater.from(parent.context).inflate(R.layout.stock_item,parent,false)
        return StockViewHolder(view)

    }


//    fun setListData(data:MutableLiveData<List<Stock>>){
//        val tasks: MutableLiveData<out List<Stock>> = data
//
//        item=tasks
//
//    }

    override fun onBindViewHolder(holder: StockViewHolder, position: Int) {

        val ItemsViewModel = item[position]

        holder.tvitem.text=ItemsViewModel.itemName
        holder.tvbalance.text=ItemsViewModel.stockBal.toString()

    }

    override fun getItemCount(): Int {
        return item.size
    }

    inner class StockViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val tvitem: TextView = itemView.findViewById(R.id.tvName)
        val tvbalance: TextView = itemView.findViewById(R.id.tvQty)




    }


}