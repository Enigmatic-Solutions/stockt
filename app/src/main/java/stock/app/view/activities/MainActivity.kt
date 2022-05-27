package stock.app.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint
import org.jetbrains.anko.toolbar
import stock.app.R
import stock.app.databinding.ActivityMainBinding



@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    lateinit var toggle:ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //supportActionBar(customtoolbar)

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

        toggle= ActionBarDrawerToggle(this,drawyerLayout,R.string.open,R.string.close)

        Toast.makeText(this,"Menu Icon Selected",Toast.LENGTH_SHORT).show()
        drawyerLayout.addDrawerListener(toggle)
        toggle.syncState()

        //supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)

        toolbar_img1.setOnClickListener{

        }




    }




}