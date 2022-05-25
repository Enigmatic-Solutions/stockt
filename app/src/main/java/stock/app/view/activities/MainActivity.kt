package stock.app.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import dagger.hilt.android.AndroidEntryPoint
import stock.app.R
import stock.app.databinding.ActivityMainBinding



@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var toolbar_img1:ImageView=findViewById(R.id.menu_icon)
        var toolbar_img2:ImageView=findViewById(R.id.login_icon)
        var toolbar_caption:TextView=findViewById(R.id.appname)


        toolbar_caption.text="Main Dashboard"

        toolbar_img1.setOnClickListener({
            Toast.makeText(this,"Menu Icon Selected",Toast.LENGTH_SHORT).show()
        })

        toolbar_img2.setOnClickListener({
            Toast.makeText(this,"Login Icon Selected",Toast.LENGTH_SHORT).show()
        })


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