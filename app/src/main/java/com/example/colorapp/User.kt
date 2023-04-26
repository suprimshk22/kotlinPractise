package com.example.colorapp


import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class User(private val context: Context) {

    var name: String = ""
        get() = field
        set(value) {
            field = value
        }

    var age: Int = 0
        get() = field
        set(value) {
            field = value
        }

    var imageUrl: String? = ""
        get() = field
        set(value) {
            field = value
        }

    var isActive: Boolean? = true
        get() = field
        set(value) {
            field = value
        }
    constructor(
        context: Context,
        name: String,
        age: Int,
        ImageUrl: String?,
        isActive: Boolean?
    ):this(context) {
        this.name = name
        this.age = age
        this.imageUrl = ImageUrl
        this.isActive = isActive
    }
fun handleClick(){
    Log.d("User","$name")

        var homeIntent= Intent(context,homeActivity::class.java)
        context.startActivity(homeIntent)

}
    override fun toString(): String {
        return "User(name='$name', age=$age, imageUrl='$imageUrl', isActive=$isActive)"
    }


    fun loadImage(imageView: ImageView, imageUrl:String){
    Glide.with(imageView).load(imageUrl).into(imageView)
}

}
