package com.example.colorapp
import android.content.ActivityNotFoundException
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.colorapp.databinding.ActivityBottomSheetBinding
import android.content.Intent
import android.graphics.BitmapFactory
import android.util.Log
import android.widget.ImageView
import android.widget.Toast

class BottomSheet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityBottomSheetBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_bottom_sheet
        )
        binding.camera.setOnClickListener() {
            Log.d("clicked","asddsadd")
openCamera()
        }
//        setContentView(R.layout.activity_bottom_sheet)

    }

    private fun openCamera() {
        Log.d("click","clicked")
        var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivity(intent)
//            try {
                // The photo was taken successfully, so display it in the ImageView
            val currentPhotoPath:String="";
            val photoBitmap = BitmapFactory.decodeFile(currentPhotoPath)
            Log.d("img","$photoBitmap.toString()")

//                val imageView = findViewById<ImageView>(R.id.pic_set)
//                imageView.setImageBitmap(photoBitmap)
//            }
        }
        catch (e:ActivityNotFoundException){
            Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()

        }

    }

}