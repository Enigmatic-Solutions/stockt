package stock.app.view.activities

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import stock.app.R
import java.util.*


class Languages : AppCompatActivity() {

    lateinit var locale:Locale
    var keyString:String="Language"





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_languages)

        val sharedpreferences: SharedPreferences =getSharedPreferences("LANGUAGE", Context.MODE_PRIVATE)

        val tv:TextView=findViewById<TextView>(R.id.tvwords)

        val SavedString:String?=sharedpreferences.getString("LANGUAGE",null)



        tv.text=SavedString

        val btn:Button=findViewById<Button>(R.id.btnKey)

        btn.setOnClickListener {


            val sharedpreferences: SharedPreferences =getSharedPreferences("LANGUAGE", Context.MODE_PRIVATE)
            val editor:SharedPreferences.Editor=sharedpreferences.edit()

            editor.apply{
                putString("LANGUAGE","Sinhala")
            }.apply()

        }


    }


    fun setLocale(languagename:String){
        locale=Locale(languagename)
        var res=resources
        var dm=res.displayMetrics
        var conf=res.configuration
        res.updateConfiguration(conf,dm)


    }


}