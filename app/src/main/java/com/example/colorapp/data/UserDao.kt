package com.example.colorapp.data

import androidx.room.Dao
import androidx.room.Query
import com.example.colorapp.data.model.User

//we will write all the query here
@Dao
interfacea UserDao {
@Query("Select * FROM user_table")
fun getAll():List<User>
}