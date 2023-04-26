package com.example.colorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.colorapp.databinding.ActivityHomeBinding

class homeActivity : AppCompatActivity() {
    lateinit var navController:NavController;
    override fun onCreate(savedInstanceState: Bundle?) {
Log.i("home","onCreate Called")
        super.onCreate(savedInstanceState)
       val binding: ViewDataBinding? =DataBindingUtil.setContentView(this,R.layout.activity_home)
//By setting up the ActionBar with the NavController,
// the app will automatically update the ActionBar title and
//// back button as the user navigates through the app's screens
         navController=this.findNavController(R.id.navController)
        NavigationUI.setupActionBarWithNavController(this,navController)
    }
    //        for goBack in appbar here we call up
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

    override fun onStart() {
        super.onStart()
Log.i("Home","onStart")

    }
}