package com.example.firstkotlinapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun  addUser(user:User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData():LiveData<List<User>>

    @Query("SELECT * FROM user_table where firstName = (:userId) and password = (:password)")
    fun login (userId:String, password:String):User

    @Query("Select * FROM user_table where firstName = (:firstName) and password = (:password) ")
    //select all the records in the database that has the firstname and password that the user has given
    fun loginuser(firstName:String , password: String):User
}