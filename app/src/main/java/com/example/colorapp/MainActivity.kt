package com.example.colorapp

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.colorapp.databinding.ActivityMainBinding
import com.example.colorapp.ui.login.LoginActivity
import kotlinx.coroutines.newFixedThreadPoolContext
import org.w3c.dom.Text
import com.google.android.material.bottomsheet.BottomSheetDialog
class MainActivity : AppCompatActivity() {
    lateinit var share:Button;
    lateinit var next:Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("main","create")
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )

        var user:User = User(this,"Suprim",33,"@mipmap/ic_logo_foreground",true);
         println("test")
        Log.d("asd","$user")
        binding.user=user;
        binding.setMyVariable( "Hello, World!")

        binding.button2.setOnClickListener{
            bottomSheet()
        }
        binding.open.setOnClickListener{
            openCamera()
        }
//        this is to set data in view using dataBinding
//        binding.setMyVariable("Suprim");

        next=findViewById(R.id.button3 )
        share=findViewById(R.id.button_next);
        next.setOnClickListener(){
            nextPage()
        }
        binding.btnNew.setOnClickListener {
            homePage()
        }
        share.setOnClickListener {
            var sender:String="hello"
            intent = Intent(Intent.ACTION_SEND)
//            intent.setData(Uri.parse("https://www.youtube.com/"))
            intent.setType("text/plain")
            intent.putExtra(Intent.EXTRA_TEXT,sender);
            startActivity(intent)
        }
    }

    override fun onStart() {
        Log.i("main","start")
        super.onStart()
    }

    override fun onStop() {
        Log.i("main","onstop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.i("main","destroy")
        super.onDestroy()
    }

    private fun homePage() {
        var homeIntent=Intent(this,homeActivity::class.java)
        startActivity(homeIntent)
    }

    /**
     * {@inheritDoc}
     *
     * Dispatch onPause() to fragments.
     */
    override fun onPause() {
        Log.i("main","pause")
        super.onPause()
    }

    override fun onRestart() {
        Log.i("main","restart")
        super.onRestart()
    }

    override fun onResume() {
        Log.i("main","resume")
        super.onResume()
    }

    private fun openCamera() {
        var intent =Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivity(intent)
//            try {
            // The photo was taken successfully, so display it in the ImageView
            val currentPhotoPath:String="";
            val photoBitmap = BitmapFactory.decodeFile(currentPhotoPath)
            Log.d("img","$photoBitmap.toString")

//            val imageView = findViewById<ImageView>(R.id.pic_set)
//            imageView.setImageBitmap(photoBitmap)
//            }
        }
        catch (e: ActivityNotFoundException){
//            Toast.makeText(applicationContext,"Error", Toast.LENGTH_LONG).show()

        }
    }

    private fun bottomSheet() {
        // on below line we are creating a new bottom sheet dialog.
        val dialog = BottomSheetDialog(this)

        // on below line we are inflating a layout file which we have created.
        val view = layoutInflater.inflate(R.layout.activity_bottom_sheet, null)

        // on below line we are creating a variable for our button
        // which we are using to dismiss our dialog.
        val btnClose = view.findViewById<ImageView>(R.id.button_crs)

        // on below line we are adding on click listener
        // for our dismissing the dialog button.
        btnClose.setOnClickListener {
            // on below line we are calling a dismiss
            // method to close our dialog.
            dialog.dismiss()
        }
        // below line is use to set cancelable to avoid
        // closing of dialog box when clicking on the screen.
        dialog.setCancelable(false)

        // on below line we are setting
        // content view to our view.
        dialog.setContentView(view)

        // on below line we are calling
        // a show method to display a dialog.
        dialog.show()
    }

    private fun nextPage() {
        val intent = Intent(this, LoginActivity::class.java)

        startActivity(intent)
    }
}