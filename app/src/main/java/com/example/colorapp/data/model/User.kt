package com.example.colorapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
//    here,? defines entity can have  null value if you are sure that there will be value then no need to keep ?.
    @PrimaryKey(autoGenerate = true)val id:Int?,
    @ColumnInfo(name="first_name")val firstName:String?,
    @ColumnInfo(name="last_name")val lastName:String?,
    @ColumnInfo(name="age")val age:Int?,

    )