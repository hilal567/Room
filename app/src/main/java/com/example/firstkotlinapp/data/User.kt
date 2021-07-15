package com.example.firstkotlinapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val firstName:String,
    val lastName : String,
    val password : Int

    // id    firstName   LastName  password
    //  1    fatma       ali       23
    //  2    joram       lastnam   18
    //  3    gad           last    13
)
