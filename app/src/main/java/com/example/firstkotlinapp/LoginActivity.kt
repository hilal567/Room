package com.example.firstkotlinapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firstkotlinapp.data.User
import com.example.firstkotlinapp.data.UserDao
import com.example.firstkotlinapp.data.UserDatabase
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        login_btn.setOnClickListener {
            //when the login button is clicked I will perform the following tasks
            // 1 fatma ali 23
             val firstname_login = first_name_login.text.toString()
             val age_login = login_age.text.toString()

             val thread: Thread
            //instantiate the database
            val  database_user : UserDatabase =  UserDatabase.getDatabase(this)

            //go to the database and accessing the dao
            val userdao : UserDao = database_user.userDao()

             Thread{
                 //prepare your query to execute in the background
                    Looper.prepare()
               val user :User = userdao.loginuser(firstname_login , age_login)
                 Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()

                 //execute looper
                 Looper.loop();
             }.start()
        }


    }
}

//        login_btn.setOnClickListener {
//
//            val firstName_login = first_name_login.text.toString()
//            val lastName_login =login_age.text.toString()
//            val userDatabase: UserDatabase = UserDatabase.getDatabase(this)
//            val userdao: UserDao = userDatabase.userDao()
//
//            val thread: Thread
//            Thread{
//                Looper.prepare();
//                val user: User = userdao.login(firstName_login,lastName_login)
//                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
//                Looper.loop();
//            }.start()
//
//
//
//
//        }