package stock.app.view.activities

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.core.view.drawToBitmap
import androidx.lifecycle.Observer
//import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import stock.app.R
import stock.app.data.db.Stock
import stock.app.databinding.ActivityAddstockBinding
import stock.app.viewmodel.StockViewModel
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream


@AndroidEntryPoint
class Addstock : AppCompatActivity() {

    private lateinit var binding:ActivityAddstockBinding
    //private lateinit var mstockViewModel: StockViewModel
    val REQUEST_IMAGE_CAPTURE = 1

    private lateinit var mstockViewModel: StockViewModel

//by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_addstock)

        binding= ActivityAddstockBinding.inflate(layoutInflater)
        setContentView(binding.root)

       mstockViewModel = ViewModelProvider(this).get(StockViewModel::class.java)


        binding.btnSave.setOnClickListener{
            addStock()
        }

        initVM()

        binding.imageView.setOnClickListener {
            dispatchTakePictureIntent()
        }


        binding.fltButton.setOnClickListener{


        }



    }





    fun addStock(){
        var stk: Stock



        var img :Bitmap
        img=binding.imageView.drawToBitmap()

        var imgPath:String?
        imgPath= saveImage(img)

        stk= Stock(0,binding.editItemName.text.toString(),binding.editQty.text.toString().toInt(),imgPath)


            mstockViewModel.InsertStock(stk)
            binding.editItemName.setText("")
            binding.editQty.setText("")
            binding.imageView.setImageResource(R.drawable.blank_img)

        try {
            mstockViewModel.getAllStock()
        }catch(ex:Exception){
            binding.resultTextView.setText(ex.message.toString())
        }

    }



    fun initVM(){
        mstockViewModel.getRecordObserver().observe(this,object: Observer<List<Stock>>{
            override fun onChanged(t:List<Stock>?){
                binding.resultTextView.setText("")
                t?.forEach{
                    binding.resultTextView.append(it.itemName+"\n")
                }
            }
        })
    }

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } catch (e: ActivityNotFoundException) {
            // display error state to the user
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            binding.imageView.setImageBitmap(imageBitmap)
        }
    }



    private fun saveImage(image: Bitmap): String? {
        var savedImagePath: String? = null
        val imageFileName = binding.editItemName.text.toString()+".jpg"
        val storageDir = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
                .toString() + "/StockApp"
        )
        var success = true
        if (!storageDir.exists()) {
            success = storageDir.mkdirs()
        }
        if (success) {
            val imageFile = File(storageDir, imageFileName)
            savedImagePath = imageFile.getAbsolutePath()
            try {
                val fOut: OutputStream = FileOutputStream(imageFile)
                image.compress(Bitmap.CompressFormat.JPEG, 100, fOut)
                fOut.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }

            // Add the image to the system gallery
            galleryAddPic(savedImagePath)
            //Toast.makeText(this, "IMAGE SAVED", Toast.LENGTH_LONG).show() // to make this working, need to manage coroutine, as this execution is something off the main thread
        }
        return savedImagePath
    }



    private fun galleryAddPic(imagePath: String?) {
        imagePath?.let { path ->
            val mediaScanIntent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
            val f = File(path)
            val contentUri: Uri = Uri.fromFile(f)
            mediaScanIntent.data = contentUri
            sendBroadcast(mediaScanIntent)
        }
    }


}


