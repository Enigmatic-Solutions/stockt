package stock.app.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import stock.app.databinding.ActivityMainBinding



@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {

            val intent = Intent(this, Addstock::class.java)

            startActivity(intent)
        }



        binding.btnStockView.setOnClickListener{
            val intent = Intent(this, Stockview::class.java)

            startActivity(intent)
        }

    }




}