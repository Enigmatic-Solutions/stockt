package stock.app.view.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
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


        val toolbar_img1:ImageView=findViewById(R.id.menu_icon)
        val toolbar_img2:ImageView=findViewById(R.id.login_icon)
        val toolbar_caption:TextView=findViewById(R.id.appname)


        toolbar_caption.text="Main Dashboard"



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


        val drawyerLayout:DrawerLayout=findViewById(R.id.drawerlayout)
        val navView:NavigationView=findViewById(R.id.navView)

//        for (i in 0 until navView.getChildCount()) {
//            navView.getChildAt(i).setOverScrollMode(View.OVER_SCROLL_NEVER)
//        }


        toolbar_img1.setOnClickListener{
            drawyerLayout.open()
            Toast.makeText(this,"Menu Icon Selected",Toast.LENGTH_SHORT).show()
        }


        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_prod -> Toast.makeText(this,"Home Icon Selected",Toast.LENGTH_SHORT).show()
                R.id.nav_stocktaking -> Toast.makeText(this,"Stock Icon Selected",Toast.LENGTH_SHORT).show()
            }

            true
        }


    }




}